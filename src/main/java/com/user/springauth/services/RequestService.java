package com.user.springauth.services;

import com.user.springauth.models.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;

public class RequestService {
    public HttpEntity getHeadersWithToken(Object obj) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity request = new HttpEntity(obj, headers);
        return request;
    }

    public HttpEntity getHeadersWithToken() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity request = new HttpEntity(headers);
        return request;
    }

    public Long getCurrentUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getId();
    }
}
