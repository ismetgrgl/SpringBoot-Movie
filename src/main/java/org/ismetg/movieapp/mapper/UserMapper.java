package org.ismetg.movieapp.mapper;

import org.ismetg.movieapp.dto.request.UserSaveRequestDto;
import org.ismetg.movieapp.dto.response.UserFindAllResponseDto;
import org.ismetg.movieapp.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User userSaveRequestDtoToUser (UserSaveRequestDto dto);
    UserFindAllResponseDto userToUserFindAllResponseDto(User user);
}
