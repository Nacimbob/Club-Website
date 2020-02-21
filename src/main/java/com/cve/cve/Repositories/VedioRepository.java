package com.cve.cve.Repositories;

import java.util.List;

import com.cve.cve.Models.Video;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VedioRepository extends JpaRepository<Video, Long> {
    List<Video> findByVisibleTrue();

    
    
}