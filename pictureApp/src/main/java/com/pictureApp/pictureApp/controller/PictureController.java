package com.pictureApp.pictureApp.controller;

import com.pictureApp.pictureApp.domain.Picture;
import com.pictureApp.pictureApp.services.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Controller
public class PictureController {
    
    @Autowired
    IPictureService pictureService;
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("pictures", pictureService.getPictures());
        return "home";
    }
    
    @GetMapping("/pictures/add")
    public String addPatient(Picture picture, Model model) {
        model.addAttribute("picture", picture);
        model.addAttribute("name", picture.getName());
        model.addAttribute("content",picture.getContent());
        return "uploadPicture";
    }
    
    @PostMapping("/pictures/add")
    public String addPicture(@RequestParam("name") String name,
                           @RequestParam("content") MultipartFile content, Model model)
            throws IOException {
        Long id = pictureService.addPicture(name,content);
      //  model.addAttribute("name",name);
//        model.addAttribute("content",content);
        return "redirect:/pictures/" + id;
    }
   
    
    @GetMapping("/pictures/{id}")
    public String getPicture(@PathVariable String id, Model model) {
        Picture picture= pictureService.getPicture(Long.parseLong(id));
        model.addAttribute("picture",picture);
        model.addAttribute("name", picture.getName());
        model.addAttribute("content",
                Base64.getEncoder().encodeToString(picture.getContent()));
        return "pictures";
    }
    
  
}
