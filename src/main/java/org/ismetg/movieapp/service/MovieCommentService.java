package org.ismetg.movieapp.service;

import org.ismetg.movieapp.dto.request.MovieCommentSaveRequestDto;
import org.ismetg.movieapp.dto.response.MovieCommentFindAllResponseDto;
import org.ismetg.movieapp.entity.MovieComment;
import org.ismetg.movieapp.mapper.MovieCommentMapper;
import org.ismetg.movieapp.repository.MovieCommentRepository;
import org.ismetg.movieapp.utility.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieCommentService extends ServiceManager<MovieComment, Long> {
    private final MovieCommentRepository movieCommentRepository;
    private final MovieService movieService;
    private final UserService userService;

    public MovieCommentService(MovieCommentRepository movieCommentRepository, MovieService movieService, UserService userService) {
        super(movieCommentRepository);
        this.movieCommentRepository = movieCommentRepository;
        this.movieService = movieService;
        this.userService = userService;
    }

    public MovieCommentFindAllResponseDto saveDTO(MovieCommentSaveRequestDto movieCommentSaveRequestDTO) {

        return MovieCommentMapper.INSTANCE.moviecommentToMovieCommentFindAllResponseDto(save(MovieComment.builder()
                .movie(movieService.findById(movieCommentSaveRequestDTO.movieid()).get())
                .user(userService.findById(movieCommentSaveRequestDTO.userid()).get())
                .yorum(movieCommentSaveRequestDTO.yorum())
                .build()));
    }

    public List<MovieCommentFindAllResponseDto> findAllDto() {
        List<MovieCommentFindAllResponseDto> movieCommentFindAllResponseDtoList = new ArrayList<>();
        findAll().forEach(movie->{
			/*MovieCommentFindAllResponseDto movieCommentFindAllResponseDto =
					new MovieCommentFindAllResponseDto(movie.getId(),
					                                   movie.getContent(),
					                                   movie.getDate(),
					                                   movie.getMovie().getId(),
					                                   movie.getUser().getId());*/
            movieCommentFindAllResponseDtoList.add(MovieCommentMapper.INSTANCE.moviecommentToMovieCommentFindAllResponseDto(movie));
        });
        return movieCommentFindAllResponseDtoList;
    }
}
