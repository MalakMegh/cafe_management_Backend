package com.inn.cafe.video.mapper;



import com.inn.cafe.video.dto.UserDto;
import com.inn.cafe.video.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserDto userDto);

    UserDto toDto(User user);

    List<UserDto> toDtoList(List<User> userList);
}
