package com.example.dao;

import com.example.pojo.Image;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository {
    List<Image> findAll();
    List<Image> findByIsPrimary(boolean isPrimary);
    List<Image> findByListingId(Long listingId);
    Image findPrimaryByListingId(Long listingId);
}
