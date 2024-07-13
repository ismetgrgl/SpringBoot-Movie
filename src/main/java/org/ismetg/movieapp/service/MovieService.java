package org.ismetg.movieapp.service;

import org.ismetg.movieapp.dto.request.MovieSaveRequestDto;
import org.ismetg.movieapp.dto.request.UserSaveRequestDto;
import org.ismetg.movieapp.dto.response.MovieFindAllResponseDto;
import org.ismetg.movieapp.dto.response.UserFindAllResponseDto;
import org.ismetg.movieapp.entity.Movie;
import org.ismetg.movieapp.exception.ErrorType;
import org.ismetg.movieapp.exception.MovieAppException;
import org.ismetg.movieapp.mapper.MovieMapper;
import org.ismetg.movieapp.mapper.UserMapper;
import org.ismetg.movieapp.repository.MovieRepository;
import org.ismetg.movieapp.repository.UserRepository;
import org.ismetg.movieapp.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService extends ServiceManager<Movie , Long> {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        super(movieRepository);
        this.movieRepository = movieRepository;
    }
    public void saveDto(MovieSaveRequestDto dto){
        movieRepository.save(MovieMapper.INSTANCE.movieSaveRequestDtoToMovie(dto));
    }

    public List<MovieFindAllResponseDto> findAllResponseDto(){
        List<MovieFindAllResponseDto> responseDtoList = new ArrayList<>();
        findAll().forEach(movie -> {
            responseDtoList.add(MovieMapper.INSTANCE.movieToMovieFindAllResponseDto(movie));
        });
        return responseDtoList;
    }

    public List<Movie> findAllByIds(List<Long> ids) {
        return ids.stream().map(id -> findById(id).orElseThrow(() -> new MovieAppException(ErrorType.MOVIE_NOT_FOUND)))
                .collect(Collectors.toList());
    }



}
