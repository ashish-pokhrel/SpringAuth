package com.user.springauth.controllers;

import com.user.springauth.models.Blogging;
import com.user.springauth.models.User;
import com.user.springauth.services.BlogCORSService;
import com.user.springauth.services.UserCORSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogCORSService blogCORSService;

    @PreAuthorize("hasPermission({'ADMIN','NORMAL'}, 'saveBlog')")
    @PostMapping("/saveBlog")
    public String saveBlog(@RequestBody Blogging blogging) {
//        Object user = SecurityContextHolder.getContext().getAuthentication().getDetails();
        blogCORSService.save(blogging);
        return "Saved Successfully";
    }

    @PreAuthorize("hasPermission({'ADMIN','NORMAL'}, 'saveBlog')")
    @PostMapping("/editBlog")
    public String editBlog(@RequestBody Blogging blogging) {
//        Object user = SecurityContextHolder.getContext().getAuthentication().getDetails();
        blogCORSService.save(blogging);
        return "Saved Successfully";
    }
}
