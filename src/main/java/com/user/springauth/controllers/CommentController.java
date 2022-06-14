package com.user.springauth.controllers;

import com.user.springauth.models.Blogging;
import com.user.springauth.models.Comment;
import com.user.springauth.services.BlogCORSService;
import com.user.springauth.services.CommentCORSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentCORSService commentCORSService;
    @PreAuthorize("hasPermission({'ADMIN','NORMAL'}, 'save')")
    @PostMapping("/save")
    public String saveComment(@RequestBody Comment comment) {
        comment.setPostedOn(new Date());
        commentCORSService.save(comment);
        return "Saved Successfully";
    }

    @PreAuthorize("hasPermission({'ADMIN','NORMAL'}, 'edit')")
    @PutMapping("/edit")
    public String editComment(@RequestBody Comment comment) {
        comment.setPostedOn(new Date());
        commentCORSService.save(comment);
        return "Edited Successfully";
    }

    @PreAuthorize("hasPermission({'ADMIN'}, 'delete')")
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        commentCORSService.deleteById(id);
        return "Deleted Successfully";
    }
}
