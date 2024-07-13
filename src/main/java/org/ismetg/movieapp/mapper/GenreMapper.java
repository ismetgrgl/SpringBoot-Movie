package org.ismetg.movieapp.mapper;

import org.ismetg.movieapp.dto.request.GenreSaveRequestDto;
import org.ismetg.movieapp.dto.response.GenreFindAllResponseDto;
import org.ismetg.movieapp.entity.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface GenreMapper {
    GenreMapper INSTANCE = Mappers.getMapper(GenreMapper.class);


    Genre genresaverequestdtoTogenre(GenreSaveRequestDto genreSaveRequestDTO);


    GenreFindAllResponseDto genreToGenreFindAllResponseDTO(Genre genre);
}
