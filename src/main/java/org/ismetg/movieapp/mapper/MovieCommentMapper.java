package org.ismetg.movieapp.mapper;

import org.ismetg.movieapp.dto.request.MovieCommentSaveRequestDto;
import org.ismetg.movieapp.dto.response.MovieCommentFindAllResponseDto;
import org.ismetg.movieapp.entity.MovieComment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MovieCommentMapper {
    MovieCommentMapper INSTANCE = Mappers.getMapper( MovieCommentMapper.class );

    @Mapping(target = "movieid", source = "movieComment.movie.id")
    @Mapping(target = "userid", source = "movieComment.user.id")

    MovieCommentFindAllResponseDto moviecommentToMovieCommentFindAllResponseDto(MovieComment movieComment);


    MovieComment moviecommentSaveRequestDtoToMovieComment (MovieCommentSaveRequestDto dto);
}
