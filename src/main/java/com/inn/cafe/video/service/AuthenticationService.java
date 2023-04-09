package com.inn.cafe.video.service;

import com.inn.cafe.video.model.AuthenticationRequestModel;
import com.inn.cafe.video.model.AuthenticationResponeModel;

public interface AuthenticationService {


    AuthenticationResponeModel authenticate(AuthenticationRequestModel authenticationRequestModel) throws Exception;
}
