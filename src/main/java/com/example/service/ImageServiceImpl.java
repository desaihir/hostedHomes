package com.example.service;

import com.example.dao.ImageRepository;
import com.example.pojo.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    @Override
    public List<Image> getPrimaryImages() {
        return imageRepository.findByIsPrimary(true);
    }

    @Override
    public List<Image> getImagesByListingId(Long listingId) {
        return imageRepository.findByListingId(listingId);
    }
    
    @Override
    public Image getPrimaryImageByListingId(Long listingId) {
        return imageRepository.findPrimaryByListingId(listingId);
    }
}
