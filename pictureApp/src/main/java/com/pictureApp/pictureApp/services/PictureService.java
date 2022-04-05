package com.pictureApp.pictureApp.services;

import com.pictureApp.pictureApp.domain.Picture;
import com.pictureApp.pictureApp.repositories.IPictureRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureService implements IPictureService {
    
    @Autowired
    IPictureRepository pictureRepository;
    
    private static final Logger logger = LogManager.getLogger("PictureService");
    
    /**
     * (non-javadoc)
     *
     * @see IPictureService#createPicture(Picture)
     */
    @Override
    public Picture createPicture(Picture picture) {
        logger.info("Creating picture in DB with id:", picture.getId()+" and named:"+picture.getName());
        if(alreadyExists(picture)){
            logger.error("Picture already exists");
            return null;
        }
        return pictureRepository.save(picture);
    }
    
    /**
     * (non-javadoc)
     *
     * @see IPictureService#getPictures()
     */
    @Override
    public List<Picture> getPictures() {
        List<Picture> pictures = pictureRepository.findAll();
        logger.info("Picture list is: " + pictures);
        return pictures;
    }
    
    /**
     * (non-javadoc)
     *
     * @see IPictureService#alreadyExists(Picture)
     */
    @Override
    public boolean alreadyExists(Picture picture) {
        Example<Picture>pictureExample=Example.of(picture);
        return pictureRepository.exists(pictureExample);
    }
}
