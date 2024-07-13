package org.ismetg.movieapp.service;

import org.ismetg.movieapp.dto.request.GenreSaveRequestDto;
import org.ismetg.movieapp.dto.response.GenreFindAllResponseDto;
import org.ismetg.movieapp.entity.Genre;
import org.ismetg.movieapp.mapper.GenreMapper;
import org.ismetg.movieapp.repository.GenreRepository;
import org.ismetg.movieapp.utility.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GenreService extends ServiceManager<Genre , Long> {
private final GenreRepository genreRepository;
    public GenreService(GenreRepository genreRepository) {
        super(genreRepository);
        this.genreRepository = genreRepository;
    }

    public Genre saveDTO(GenreSaveRequestDto genreSaveRequestDTO) {
        return save(GenreMapper.INSTANCE.genresaverequestdtoTogenre(genreSaveRequestDTO));
    }

    public List<GenreFindAllResponseDto> findAllDTO() {
        List<GenreFindAllResponseDto> genreFindAllResponseDTOList = new ArrayList<>();
        findAll().forEach(genre -> {
            genreFindAllResponseDTOList.add(GenreMapper.INSTANCE.genreToGenreFindAllResponseDTO(genre));
        });
        return genreFindAllResponseDTOList;
    }

    public List<Genre> saveGenreString(List<String> genres){
        List<Genre> genreList = new ArrayList<>();
        for (String genreName:genres){
            Optional<Genre> optionalGenre = genreRepository.findByName(genreName);
            if (optionalGenre.isPresent()){
                genreList.add(optionalGenre.get());
            }else {
                Genre yeniGelenGenre = Genre.builder().name(genreName).build();
                Genre genreSave = genreRepository.save(yeniGelenGenre);
                genreList.add(genreSave);

            }
        }
return genreList;
    }

}
