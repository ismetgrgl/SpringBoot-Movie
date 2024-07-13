package org.ismetg.movieapp.controller;

import lombok.RequiredArgsConstructor;
import org.ismetg.movieapp.dto.request.GenreSaveRequestDto;
import org.ismetg.movieapp.dto.response.GenreFindAllResponseDto;
import org.ismetg.movieapp.entity.Genre;
import org.ismetg.movieapp.service.GenreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.ismetg.movieapp.constant.EndPoints.*;

@RestController
@RequestMapping("/genre")
@RequiredArgsConstructor
public class GenreController {
    private final GenreService genreService;

/*
    @PostMapping(SAVE)
    public ResponseEntity<Genre> save(@RequestBody Genre genre) {
        return ResponseEntity.ok(genreService.save(genre));
    }


    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Genre>> findAll() {
        return ResponseEntity.ok(genreService.findAll());
    }

 */

    @PostMapping(SAVE)
    public ResponseEntity<Genre> saveDTO(@RequestBody GenreSaveRequestDto genreSaveRequestDTO) {
        return ResponseEntity.ok(genreService.saveDTO(genreSaveRequestDTO));
    }

    @CrossOrigin("*")
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<GenreFindAllResponseDto>> findAllDTO() {
        return ResponseEntity.ok(genreService.findAllDTO());
    }


}
