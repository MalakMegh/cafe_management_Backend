package com.inn.cafe.video.controller;

import com.inn.cafe.video.constant.ExceptionMessageConstant;
import com.inn.cafe.video.dto.UserDto;
import com.inn.cafe.video.exception.InternalServerError;
import com.inn.cafe.video.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path ="/api/v1/users", method = { RequestMethod.GET, RequestMethod.POST })
public class UserController {

    @Autowired
    UserFacade userFacade;

    @GetMapping
    public List<UserDto> getAllUsers() {
        try {
            return userFacade.getAllUsers();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        throw new InternalServerError(ExceptionMessageConstant.INTERNAL_SERVER_ERROR);
    }
}
