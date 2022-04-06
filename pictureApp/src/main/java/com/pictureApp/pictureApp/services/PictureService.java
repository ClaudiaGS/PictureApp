package com.pictureApp.pictureApp.services;

import com.pictureApp.pictureApp.domain.Picture;
import com.pictureApp.pictureApp.repositories.IPictureRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class PictureService implements IPictureService {
    
    @Autowired
    IPictureRepository pictureRepository;
    
    private static final Logger logger = LogManager.getLogger("PictureService");
    
    
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
    
    @Override
    public Long addPicture(String name, MultipartFile file) throws IOException {
        Picture picture = new Picture();
        picture.setName(name);
        picture.setContent(file.getBytes());
        picture = pictureRepository.save(picture);
        return picture.getId();
    }
    
    @Override
    public Picture getPicture(Long id) {
        return pictureRepository.findById((id)).get();
    }
}
