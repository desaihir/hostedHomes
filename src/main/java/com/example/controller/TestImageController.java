package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.pojo.Image;
import com.example.service.ImageService;

@Controller
public class TestImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/testImages")    
    public String testImages(Model model) {
    	System.out.println("entered function...");
        // Fetch all images from the database
        List<Image> images = imageService.getAllImages();

        // Add the images to the model
        model.addAttribute("images", images);

        // Forward the request to the testImages.jsp view
        return "testImages";
    }
}

