package org.me.learning.springmongodb;


import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
public class PostController {

//i want here to create a methode just for swagger , so everytime someone send a request to the home page , it should redirect to the swagger page
    @RequestMapping(value = "/")
    public void redirect (HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }



}
