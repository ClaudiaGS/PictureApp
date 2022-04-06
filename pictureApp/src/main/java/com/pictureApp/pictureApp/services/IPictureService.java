package com.pictureApp.pictureApp.services;

import com.pictureApp.pictureApp.domain.Picture;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IPictureService {
    
    /**
     * get picture list
     * @return List<Picture>
     */
    public List<Picture> getPictures();
    
    /**
     * add picture to DB
     * @param name
     * @param file
     * @return Long
     */
    public Long addPicture(String name, MultipartFile file) throws IOException;
    
    /**
     * get picture from DB
     * @param id
     * @return Picture
     */
    public Picture getPicture(Long id);
}
