package org.ismetg.movieapp.mapper;

import org.ismetg.movieapp.dto.request.MovieSaveRequestDto;
import org.ismetg.movieapp.dto.response.MovieFindAllResponseDto;
import org.ismetg.movieapp.entity.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper( MovieMapper.class );



    MovieFindAllResponseDto movieToMovieFindAllResponseDto(Movie movie);


    Movie movieSaveRequestDtoToMovie (MovieSaveRequestDto dto);
}
