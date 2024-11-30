package org.me.learning.springmongodb.controller;


import jakarta.servlet.http.HttpServletResponse;
import org.me.learning.springmongodb.model.Post;
import org.me.learning.springmongodb.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
public class PostController {


    @Autowired
    private PostRepo repo  ;

    public PostController(PostRepo repo) {
        this.repo = repo;
    }

    //i want here to create a methode just for swagger , so everytime someone send a request to the home page , it should redirect to the swagger page
    @RequestMapping(value = "/")
    public void redirect (HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }


    @GetMapping("/posts")
    public List<Post> getPosts()  {
        return repo.findAll();
    }

    @PostMapping("/posts")
    public Post addPost(@RequestBody Post post) {
       return   repo.save(post);

    }

}
