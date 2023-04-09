package com.inn.cafe.video.service.impl;

import com.inn.cafe.video.dto.UserDto;
import com.inn.cafe.video.model.AuthenticationRequestModel;
import com.inn.cafe.video.model.AuthenticationResponeModel;
import com.inn.cafe.video.security.utils.JwtUtils;
import com.inn.cafe.video.service.AuthenticationService;
import com.inn.cafe.video.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticaionServiceImpl implements AuthenticationService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    JwtUtils jwtUtils;

    @Override
    public AuthenticationResponeModel authenticate(AuthenticationRequestModel authenticationRequestModel) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequestModel.getUserName(),
                    authenticationRequestModel.getPassword()));
        } catch (BadCredentialsException e) {
             throw new Exception("BadCredentials Exception", e);
        }

        final UserDetails user = userService.loadUserByUsername(authenticationRequestModel.getUserName());

        final String jwt = jwtUtils.generateToken(user);

        return new AuthenticationResponeModel(jwt);
    }

}
