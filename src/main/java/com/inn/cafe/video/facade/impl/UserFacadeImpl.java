package com.inn.cafe.video.facade.impl;


import com.inn.cafe.video.dto.UserDto;
import com.inn.cafe.video.facade.UserFacade;
import com.inn.cafe.video.mapper.UserMapper;
import com.inn.cafe.video.model.User;
import com.inn.cafe.video.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFacadeImpl implements UserFacade {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userService.createUser(userDto);
        return userMapper.toDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return userMapper.toDtoList(users);
    }
}
