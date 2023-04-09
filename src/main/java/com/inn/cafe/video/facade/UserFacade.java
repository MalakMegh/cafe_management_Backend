package com.inn.cafe.video.facade;

import com.inn.cafe.video.dto.UserDto;

import java.util.List;

public interface UserFacade {

    UserDto createUser(UserDto userDto) ;

    List<UserDto> getAllUsers();
}
