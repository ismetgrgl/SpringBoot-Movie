package org.ismetg.movieapp.util;

import com.google.gson.Gson;
import org.ismetg.movieapp.entity.Movie;
import org.ismetg.movieapp.entity.MovieComment;
import org.ismetg.movieapp.entity.User;
import org.ismetg.movieapp.service.GenreService;
import org.ismetg.movieapp.service.MovieService;
import org.ismetg.movieapp.service.UserService;
import org.ismetg.movieapp.util.Data.Root;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class DataImpl implements ApplicationRunner {
    private final MovieService movieService;
    private final GenreService genreService;
    private final UserService userService;

    public DataImpl(MovieService movieService, GenreService genreService, UserService userService) {
        this.movieService = movieService;
        this.genreService = genreService;
        this.userService = userService;
    }


    public void saveMoviesFromTvMaze() {
        try {
            URL url = new URL("https://api.tvmaze.com/shows");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            InputStream inputStream=connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String jsonIcerik="";
            jsonIcerik=reader.readLine(); //value içinde tüm json dosyası var.

            Root[] movieArray=new Gson().fromJson(jsonIcerik,Root[].class);
            //Arrays.stream(movieArray).forEach(System.out::println);
            Arrays.stream(movieArray).forEach(x->{
                Movie movie=Movie.builder()
                        .id((long) x.id)
                        .language(x.language)
                        .image(x.image.original)
                        .name(x.name)
                        .country(x.network != null ? x.network.country.name : null)
                        .rating(x.rating.average)
                        .summary(x.summary)
                        .premired(LocalDate.parse(x.premiered))
                        .url(x.url)
                        .genres(genreService.saveGenreString(x.genres))
                        .build();
                movieService.save(movie);
            });



        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveUsers(){
        User user1=User.builder()
                .name("Berkay")
                .surname("Güzel")
                .email("güzel@gmail.com")
                .phone("5554443322")
                .password("123")
                .favgenre(genreService.saveGenreString(List.of("Drama","Horror")))
                .favmovie(movieService.findAllByIds(List.of(1L,15L,20L)))
                .build();

        user1.setComments(List.of(
                MovieComment.builder().yorum("Çok iyi bir filmdi").movie(movieService.findById(1L).get()).user(user1).build(),
                MovieComment.builder().yorum("İzlediğin en harika  filmdi").movie(movieService.findById(15L).get()).user(user1).build(),
                MovieComment.builder().yorum("Sonunu göremeden uyudum...").movie(movieService.findById(20L).get()).user(user1).build()
        ));
        userService.save(user1);

        User user2=User.builder()
                .name("Aslı")
                .surname("Mert")
                .email("asli@gmail.com")
                .phone("5554443322")
                .password("123")
                .favgenre(genreService.saveGenreString(List.of("Action","Adventure")))
                .favmovie(movieService.findAllByIds(List.of(2L,16L,21L)))
                .build();

        user2.setComments(List.of(
                MovieComment.builder().yorum("Çok iyi bir filmdi").movie(movieService.findById(2L).get()).user(user2).build(),
                MovieComment.builder().yorum("İzlediğin en harika  filmdi").movie(movieService.findById(16L).get()).user(user2).build(),
                MovieComment.builder().yorum("Sonunu göremeden uyudum...").movie(movieService.findById(21L).get()).user(user2).build()
        ));
        userService.save(user2);

        User user3=User.builder()
                .name("Kenan")
                .surname("Öktener")
                .email("kenan@gmail.com")
                .phone("5554443322")
                .password("123")
                .favgenre(genreService.saveGenreString(List.of("Mystery","Legal")))
                .favmovie(movieService.findAllByIds(List.of(3L,17L,22L)))
                .build();

        user3.setComments(List.of(
                MovieComment.builder().yorum("Çok iyi bir filmdi").movie(movieService.findById(3L).get()).user(user3).build(),
                MovieComment.builder().yorum("İzlediğin en harika  filmdi").movie(movieService.findById(17L).get()).user(user3).build(),
                MovieComment.builder().yorum("Sonunu göremeden uyudum...").movie(movieService.findById(22L).get()).user(user3).build()
        ));
        userService.save(user3);

        User user4=User.builder()
                .name("Salih")
                .surname("Er")
                .email("salih@gmail.com")
                .phone("5554443322")
                .password("123")
                .favgenre(genreService.saveGenreString(List.of("Science-Fiction","War")))
                .favmovie(movieService.findAllByIds(List.of(5L)))
                .build();

        user4.setComments(List.of(
                MovieComment.builder().yorum("Çok iyi bir filmdi").movie(movieService.findById(5L).get()).user(user4).build(),
                MovieComment.builder().yorum("İzlediğin en harika  filmdi").movie(movieService.findById(22L).get()).user(user4).build(),
                MovieComment.builder().yorum("Sonunu göremeden uyudum...").movie(movieService.findById(17L).get()).user(user4).build()
        ));
        userService.save(user4);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        saveMoviesFromTvMaze();
        saveUsers();
    }
}
