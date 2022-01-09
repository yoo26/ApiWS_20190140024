/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rioan
 */
@CrossOrigin
@RestController
@RequestMapping("/datatas")
public class DatabaseController {
  @Autowired
  private DataTas tas;
 
  @GetMapping("/tas")
  public List<Tas> getAlltas(){
      return tas.findAll();
  }
   @GetMapping ("/tas/{id}")
    public Tas getTasById(@PathVariable String id){
        return tas.findById(id).get();
    }
    
    @PostMapping ("/tas")
    public Tas savetasDetails(@RequestBody Tas s){
        return tas.save(s);
    }
    
    @PutMapping("/tas")
    public Tas updateTas(@RequestBody Tas s){
        return tas.save(s);
    }
    
    @DeleteMapping("/tas/{id}")
    public ResponseEntity<HttpStatus> deleteTasById(@PathVariable String id){
        tas.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/tas/nama")
    public ResponseEntity<List<Tas>> getTasByNama(@RequestParam(required=false) String nama) {
        try{
            List<Tas> t = new ArrayList<Tas>();
            tas.findByNamaContaining(nama).forEach(t::add);
            
            if (t.isEmpty()){
                tas.findAll().forEach(t::add);
            }
            
            return new ResponseEntity<>(t, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}