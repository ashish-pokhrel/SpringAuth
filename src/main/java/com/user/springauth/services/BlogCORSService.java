package com.user.springauth.services;

import com.user.springauth.models.BlogWithComment;
import com.user.springauth.models.Blogging;
import com.user.springauth.models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BlogCORSService extends RequestService {
    @Value("${domain.blog}")
    private String blogDomain;

    @Value("${domain.comment}")
    private String commentDomain;
    @Autowired
    private RestTemplate restTemplate;

    public String save(Blogging blogging) {
        Long currentUser = getCurrentUser();
        blogging.setPostedBy(currentUser);
        String path = (blogDomain + "save");
        HttpMethod methodType = HttpMethod.POST;
        String result = restTemplate.exchange(path, methodType, getHeadersWithToken2(blogging), String.class).getBody();
        return result;
    }

    public String edit(Blogging blogging) {
        Long currentUser = getCurrentUser();
        blogging.setPostedBy(currentUser);
        String path = (blogDomain + "edit");
        HttpMethod methodType = HttpMethod.POST;
        String result = restTemplate.exchange(path, methodType, getHeadersWithToken2(blogging), String.class).getBody();
        return result;
    }

    public HttpEntity getHeadersWithToken2(Blogging obj) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity request = new HttpEntity(obj, headers);
        return request;
    }

    public HttpEntity getHeadersWithToken() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity request = new HttpEntity(headers);
        return request;
    }

    public void deleteById(Long id) {
        String path = (blogDomain + "delete/" + id);
        HttpMethod methodType = HttpMethod.DELETE;
        restTemplate.exchange(path, methodType, getHeadersWithToken(), String.class);
    }

    public BlogWithComment getBlogWithComment(Long id) {
        String path = (blogDomain + "getById/" + id);
        String commetnpath = (commentDomain + "getByBlogId/" + id);
        HttpMethod methodType = HttpMethod.GET;
        Blogging blogging = restTemplate.exchange(path, methodType, getHeadersWithToken(), Blogging.class).getBody();
        BlogWithComment comments = restTemplate.exchange(commetnpath, methodType, getHeadersWithToken(), BlogWithComment.class).getBody();
        BlogWithComment bwc = new BlogWithComment();
        bwc.setComments(comments.getComments());
        bwc.setDescription(blogging.getDescription());
        bwc.setTopic(blogging.getTopic());
        bwc.setPostedBy(blogging.getPostedBy());
        bwc.setId(blogging.getId());
        bwc.setPostedOn(blogging.getPostedOn());
        return bwc;
    }
}
