package com.user.springauth.controllers;

import com.user.springauth.models.BlogWithComment;
import com.user.springauth.models.Blogging;
import com.user.springauth.models.User;
import com.user.springauth.services.BlogCORSService;
import com.user.springauth.services.UserCORSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogCORSService blogCORSService;

    @PreAuthorize("hasPermission({'ADMIN','NORMAL'}, 'saveBlog')")
    @PostMapping("/saveBlog")
    public String saveBlog(@RequestBody Blogging blogging) {
        blogCORSService.save(blogging);
        return "Saved Successfully";
    }

    @PreAuthorize("hasPermission({'ADMIN','NORMAL'}, 'saveBlog')")
    @PutMapping("/editBlog")
    public String editBlog(@RequestBody Blogging blogging) {
        blogCORSService.save(blogging);
        return "Edited Successfully";
    }

    @PreAuthorize("hasPermission({'ADMIN'}, 'delete')")
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        blogCORSService.deleteById(id);
        return "Deleted Successfully";
    }

    @GetMapping("/getBlogWithComment/{id}")
    public BlogWithComment getBlogWithComment(@PathVariable Long id) {
        var result = blogCORSService.getBlogWithComment(id);
        return result;
    }
}
