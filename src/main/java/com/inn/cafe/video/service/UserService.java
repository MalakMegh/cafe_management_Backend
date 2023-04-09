package com.inn.cafe.video.service;



import com.inn.cafe.video.dto.UserDto;
import com.inn.cafe.video.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService extends UserDetailsService {
    User createUser(UserDto userDto);

    List<User> getAllUsers();

}
