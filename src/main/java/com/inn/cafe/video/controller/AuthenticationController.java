package com.inn.cafe.video.controller;

import com.inn.cafe.video.constant.ExceptionMessageConstant;
import com.inn.cafe.video.dto.UserDto;
import com.inn.cafe.video.exception.InternalServerError;
import com.inn.cafe.video.facade.UserFacade;
import com.inn.cafe.video.model.AuthenticationRequestModel;
import com.inn.cafe.video.model.AuthenticationResponeModel;
import com.inn.cafe.video.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    UserFacade userFacade;

    @PostMapping("authenticate")
    public ResponseEntity<AuthenticationResponeModel> authenticate(@RequestBody AuthenticationRequestModel authenticationRequestModel) throws Exception {
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequestModel));
    }


    @PostMapping(path = "register")
    public UserDto addUser(@RequestBody(required = true) UserDto userDto) {
        try {
            return userFacade.createUser(userDto);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        throw new InternalServerError(ExceptionMessageConstant.INTERNAL_SERVER_ERROR);
    }

}
