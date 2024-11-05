package com.kraizan.oneshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kraizan.oneshop.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
