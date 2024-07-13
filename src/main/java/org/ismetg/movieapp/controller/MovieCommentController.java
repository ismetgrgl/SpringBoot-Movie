package org.ismetg.movieapp.controller;

import lombok.RequiredArgsConstructor;
import org.ismetg.movieapp.dto.request.MovieCommentSaveRequestDto;
import org.ismetg.movieapp.dto.response.MovieCommentFindAllResponseDto;
import org.ismetg.movieapp.service.MovieCommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.ismetg.movieapp.constant.EndPoints.*;

@RestController
@RequestMapping("/moviecomment")
@RequiredArgsConstructor
public class MovieCommentController {
    private final MovieCommentService movieCommentService;

    /*
    @PostMapping(SAVE)
    public ResponseEntity<MovieComment> save(@RequestBody MovieComment movieComment) {
        return ResponseEntity.ok(movieCommentService.save(movieComment));
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<MovieComment>> findAll() {
        return ResponseEntity.ok(movieCommentService.findAll());
    }

     */

    @PostMapping(SAVE)
    public ResponseEntity<MovieCommentFindAllResponseDto> saveDTO(@RequestBody MovieCommentSaveRequestDto movieCommentSaveRequestDTO) {
        return ResponseEntity.ok(movieCommentService.saveDTO(movieCommentSaveRequestDTO));
    }


    @CrossOrigin("*")
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<MovieCommentFindAllResponseDto>> findAll() {
        return ResponseEntity.ok(movieCommentService.findAllDto());

    }


}