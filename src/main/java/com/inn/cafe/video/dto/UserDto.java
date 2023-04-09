package com.inn.cafe.video.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class UserDto extends BaseDto{


    private String name;
    private String contactNumber;
    private String email;
    private String password;
    private String status;
    private String role;
}
