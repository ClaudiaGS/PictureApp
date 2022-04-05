package com.pictureApp.pictureApp.controller;

import com.pictureApp.pictureApp.domain.Picture;
import com.pictureApp.pictureApp.services.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PictureController {
    
    @Autowired
    IPictureService pictureService;
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("pictures", pictureService.getPictures());
        return "home";
    }
    @GetMapping("/picture/list")
    public List<Picture> getPictures() {
        return pictureService.getPictures();
    }
}
