package com.boa.customerapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boa.customerapi.models.Individual;
import com.boa.customerapi.services.IndividualService;

@RestController
@RequestMapping("/individuals")
public class IndividualController {
    @Autowired
	private IndividualService individualService;
    
    @PostMapping({"/v1.0/"})
    @CrossOrigin("*")
    public ResponseEntity<?> addIndividual(@RequestBody Individual individual){
    
    	Individual instance=this.individualService.addIndividual(individual);
    	if(instance !=null) 
    		return ResponseEntity.status(HttpStatus.CREATED).body(instance);
    	
    	else
    	 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Individual "
    	 		+ "instance not created");	
    	
    }
    @GetMapping({"/v1.0/"})
    @CrossOrigin("*")
    public List<Individual> getAllIndividuals(){
    
    	return this.individualService.getAllIndividuals();
    	
    }
}
