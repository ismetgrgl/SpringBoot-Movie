package org.ismetg.movieapp.controller;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.ismetg.movieapp.constant.EndPoints;
import org.ismetg.movieapp.dto.request.MovieSaveRequestDto;
import org.ismetg.movieapp.dto.request.UserSaveRequestDto;
import org.ismetg.movieapp.dto.response.MovieFindAllResponseDto;
import org.ismetg.movieapp.dto.response.UserFindAllResponseDto;
import org.ismetg.movieapp.entity.Movie;
import org.ismetg.movieapp.entity.MovieComment;
import org.ismetg.movieapp.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.ismetg.movieapp.constant.EndPoints.*;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;
/*
    @GetMapping(SAVE)
    @CrossOrigin("*")
    public ResponseEntity<Movie> save(Movie movie){
        return ResponseEntity.ok(movieService.save(movie));
    }

    @GetMapping(FIND_ALL)
    @CrossOrigin("*")
    public ResponseEntity<List<Movie>> findAll(){
        return ResponseEntity.ok(movieService.findAll());
    }
 */
@PostMapping(SAVE)
public ResponseEntity<String> save(@RequestBody MovieSaveRequestDto dto){
    movieService.saveDto(dto);
    return ResponseEntity.ok("Başarılı");
}
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<MovieFindAllResponseDto>> findAllDto(){
        return ResponseEntity.ok(movieService.findAllResponseDto());
    }
}
