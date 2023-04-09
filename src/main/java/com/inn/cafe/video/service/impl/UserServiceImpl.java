package com.inn.cafe.video.service.impl;


import com.inn.cafe.video.constant.ExceptionMessageConstant;
import com.inn.cafe.video.dto.UserDto;
import com.inn.cafe.video.exception.ConflictException;
import com.inn.cafe.video.mapper.UserMapper;
import com.inn.cafe.video.model.User;
import com.inn.cafe.video.repository.UserRepository;
import com.inn.cafe.video.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class UserServiceImpl implements UserService , UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;
    @Override
    public User createUser(UserDto userDto) {
        if (Boolean.TRUE.equals(userRepository.existsByEmail(userDto.getEmail()))) {
            throw new ConflictException(ExceptionMessageConstant.USER_ALREADY_EXISTS);
        }
        return userRepository.save(userMapper.toEntity(userDto));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByName(username).orElseThrow();
    }
}
