package com.cve.cve.Services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.cve.cve.Models.Video;
import com.cve.cve.Repositories.VedioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * EventService
 */
 @Service
public class VedioSercice {

    @Autowired
    private VedioRepository vedioRepository;

    public Video save(Video vedio) {
        return vedioRepository.save(vedio);
    }

    public Video update (Video vedio){
        return vedioRepository.save(vedio);
           
    }

    public Optional<Video> findById(Long id) {
        return vedioRepository.findById(id);
    } 
    /*
     find all vedios
    */ 

    public List<Video> findAll(){
        return vedioRepository.findAll();
    }

    public List<Video> findAllVisiblVedios(){
        return vedioRepository.findByVisibleTrue();
    }
    
    public void delete(@Valid Long id){
         vedioRepository.deleteById( id);
    }
    
    public Long countVedio(){
        return vedioRepository.count();
    }

}