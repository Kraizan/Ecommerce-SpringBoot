package com.kraizan.oneshop.service.image;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.kraizan.oneshop.dto.ImageDto;
import com.kraizan.oneshop.model.Image;

public interface IImageService {
    Image getImageById(Long id);
    void deleteImageById(Long id);
    List<ImageDto> saveImage(List<MultipartFile> files, Long productId);
    Image updateImage(MultipartFile file, Long id);
}
