package com.pictureApp.pictureApp.repositories;

import com.pictureApp.pictureApp.domain.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * CRUD implementation for Picture object
 *
 */

@Repository
public interface IPictureRepository extends JpaRepository<Picture, Long> {

}
