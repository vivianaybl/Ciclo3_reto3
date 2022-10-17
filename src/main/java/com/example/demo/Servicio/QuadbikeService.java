/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Servicio;

import com.example.demo.Repositorio.QuadbikeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Modelo.Quadbike;
/**
 *
 * @author USUARIO
 */

@Service

public class QuadbikeService {
      @Autowired
    private QuadbikeRepository quadbikeRepository;
    
    public List<Quadbike> getAll(){
        return quadbikeRepository.getAll();
    }
    
    public Optional<Quadbike> getQuadbike(int id){
        return quadbikeRepository.getQuadbike(id);
    }
    
    public Quadbike save (Quadbike quadbike){
        if (quadbike.getId() == null){
            return quadbikeRepository.save(quadbike);
        } else {
            Optional<Quadbike> quadbike1 = quadbikeRepository.getQuadbike(quadbike.getId());
            if(quadbike1.isEmpty()){
                return quadbikeRepository.save(quadbike);
            } else {
                return quadbike;
            }
        }
    }
}
