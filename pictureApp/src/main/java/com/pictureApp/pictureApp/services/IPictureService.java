package com.pictureApp.pictureApp.services;

import com.pictureApp.pictureApp.domain.Picture;

import java.util.List;

public interface IPictureService {

    
    /**
     * create new entry in DB
     * @param picture
     * @return Picture
     */
    public Picture createPicture(Picture picture);
    
    /**
     * get picture list
     * @return List<Picture>
     */
    public List<Picture> getPictures();
    
    /**
     * check if picture already stored in DB
     * @param picture
     * @return boolean
     */
    public boolean alreadyExists(Picture picture);
}
