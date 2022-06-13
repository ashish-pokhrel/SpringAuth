package com.user.springauth.services;

import com.user.springauth.models.Blogging;
import com.user.springauth.models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CommentCORSService extends RequestService {
    @Value("${domain.blog}")
    private String blogDomain;
    @Autowired
    private RestTemplate restTemplate;

    public HttpEntity getHeadersWithToken(Comment obj) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity request = new HttpEntity(obj, headers);
        return request;
    }

    public HttpEntity getHeadersWithToken() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity request = new HttpEntity(headers);
        return request;
    }
    public String save(Comment comment) {
        Long currentUser = getCurrentUser();
        comment.setPostedBy(currentUser);
        String path = (blogDomain + "save");
        HttpMethod methodType = HttpMethod.POST;
        String result = restTemplate.exchange(path, methodType, getHeadersWithToken(comment), String.class).getBody();
        return result;
    }
    public HttpEntity getHeadersWithToken2(Blogging obj) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity request = new HttpEntity(obj, headers);
        return request;
    }
}

