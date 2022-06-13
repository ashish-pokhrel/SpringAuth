package com.user.springauth.controllers;

import com.user.springauth.models.Blogging;
import com.user.springauth.models.Comment;
import com.user.springauth.services.BlogCORSService;
import com.user.springauth.services.CommentCORSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentCORSService commentCORSService;
    @PreAuthorize("hasPermission({'ADMIN','NORMAL'}, 'save')")
    @PostMapping("/save")
    public String saveComment(@RequestBody Comment comment) {
        commentCORSService.save(comment);
        return "Saved Successfully";
    }

    @PreAuthorize("hasPermission({'ADMIN','NORMAL'}, 'edit')")
    @PostMapping("/edit")
    public String editComment(@RequestBody Comment comment) {
        commentCORSService.save(comment);
        return "Saved Successfully";
    }
}
