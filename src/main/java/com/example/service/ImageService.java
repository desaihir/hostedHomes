package com.example.service;

import com.example.pojo.Image;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ImageService {
    List<Image> getAllImages();
    List<Image> getPrimaryImages();
    List<Image> getImagesByListingId(Long listingId);
    Image getPrimaryImageByListingId(Long listingId);
}
