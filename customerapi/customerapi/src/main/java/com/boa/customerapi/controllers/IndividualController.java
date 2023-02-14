package com.boa.customerapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    @GetMapping({"/v1.0/{customerId}"})
    @CrossOrigin("*")
    public ResponseEntity<?> getIndividualById(@PathVariable("customerId") 
    long customerId){
    
    	Individual instance=this.individualService.getIndividualById(customerId);
    	if(instance !=null) 
    		return ResponseEntity.status(HttpStatus.ACCEPTED).body(instance);
    	
    	else
    	 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Individual "
    	 		+ "instance not found");	
    	
    }
    @GetMapping({"/v1.0/emailfilter/{email}"})
    @CrossOrigin("*")
    public ResponseEntity<?> getIndividualByEmail(@PathVariable("email") 
    String email){
    
    	List<Individual> instances=this.individualService.findAllByEmailId(email);
    	if(instances.size()>0) 
    		return ResponseEntity.status(HttpStatus.ACCEPTED).body(instances);
    	
    	else
    	 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Individual "
    	 		+ "instances not found");	
    	
    }
    @GetMapping({"/v1.0/firstnamefilter/{firstName}"})
    @CrossOrigin("*")
    public ResponseEntity<?> getIndividualByFirstName(@PathVariable("firstName") 
    String firstName){
    
    	List<Individual> instances=this.individualService.findAllByFirstName(firstName);
    	if(instances.size()>0) 
    		return ResponseEntity.status(HttpStatus.ACCEPTED).body(instances);
    	
    	else
    	 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Individual "
    	 		+ "instances not found");	
    	
    }
    @DeleteMapping({"/v1.0/{customerId}"})
    @CrossOrigin("*")
    public ResponseEntity<?> deleteIndividualById(@PathVariable("customerId") 
    long customerId){
    
    	
    	if(this.individualService.deleteIndividualById(customerId)) 
    		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Individual Deleted");
    	
    	else
    	 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Individual "
    	 		+ "instance not found");	
    	
    }
    @PutMapping({"/v1.0/{customerId}"})
    @CrossOrigin("*")
    public ResponseEntity<?> updateIndividual(@RequestBody Individual individual,
    		@PathVariable("customerId") long customerId){
    
    	Individual instance=this.individualService.updateIndividual(individual,customerId);
    	if(instance !=null) 
    		return ResponseEntity.status(HttpStatus.CREATED).body(instance);
    	
    	else
    	 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Individual "
    	 		+ "instance not created");	
    	
    }
}
