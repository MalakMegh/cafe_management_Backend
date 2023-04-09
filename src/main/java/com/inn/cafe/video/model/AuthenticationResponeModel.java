package com.inn.cafe.video.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponeModel {
    private String jwtToken;
}
