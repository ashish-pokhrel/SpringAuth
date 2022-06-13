package com.user.springauth.services;

import com.user.springauth.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class UserCORSService extends  RequestService{
    @Value("${domain.user}")
    private String userDomain;
    @Value("${domain.blog}")
    private String blogDomain;
    @Value("${domain.comment}")
    private String commentDomain;
    @Autowired
    private RestTemplate restTemplate;
    

    public String login(User user) {
        String path = (userDomain + "login/");
        HttpMethod methodType = HttpMethod.POST;
        String token = restTemplate.exchange(path, methodType, getHeadersWithToken(user), String.class).getBody();
        //   String token = restTemplate.getForObject(path,String.class);
        return token;
    }

    public String saveUser(User user, String type) {
        String path = (userDomain + type);
        HttpMethod methodType = HttpMethod.POST;
        String result = restTemplate.exchange(path, methodType, getHeadersWithToken(user), String.class).getBody();
        return result;
    }

    public User getUserById(Long id) {
        String path = (userDomain + "get/" + id);
        HttpMethod methodType = HttpMethod.GET;
        User result = restTemplate.exchange(path, methodType, getHeadersWithToken(), User.class).getBody();
        return result;
    }

    public User getUserByUserName(String userName)
    {
        String path = (userDomain + "getUserByName/" + userName);
        HttpMethod methodType = HttpMethod.GET;
        User result = restTemplate.exchange(path, methodType, getHeadersWithToken(), User.class).getBody();
        return result;
    }
}
