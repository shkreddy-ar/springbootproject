package com.boa.customerapi.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boa.customerapi.models.Individual;
import com.boa.customerapi.repositories.IndividualRepo;

@Service
public class IndividualService {
    @Autowired 
	private IndividualRepo individualRepo;
    @Autowired
    private EntityManager entityManager;
    
    //insert
    
    public Individual addIndividual(Individual individual) {
    	
    	return this.individualRepo.save(individual);
    }
    
    //all the records
    
    public List<Individual> getAllIndividuals(){
    	return this.individualRepo.findAll();
    }
    
    public Individual getIndividualById(long customerId) {
    	return this.individualRepo.findById(customerId).orElse(null);
    }
    
    public boolean deleteIndividualById(long customerId) {
    	this.individualRepo.deleteById(customerId);
    	if(getIndividualById(customerId)==null)
    		return true;    	
    	else
    		return false;
    	
    }
    
 //update
    
    public Individual updateIndividual(Individual individual, long customerId) {
    	if(getIndividualById(customerId)!=null)
    	   	
    	  return this.individualRepo.save(individual);
    	else
    		return this.individualRepo.save(individual);
    }
    
    //non primary key
    public List<Individual> findAllByEmailId(String email){
    	return this.individualRepo.findByEmail(email);
    }
    public List<Individual> findAllByFirstName(String firstName){
    	CriteriaBuilder cb= entityManager.getCriteriaBuilder();
    	AbstractQuery<Individual> cq=cb.createQuery(Individual.class);
    	
    	Root<Individual> individualObject=cq.from(Individual.class);
    	cq.where(cb.equal(individualObject.get("name.firstName"),firstName));
    	
    	CriteriaQuery<Individual> selectResult=((CriteriaQuery<Individual>)cq).select(individualObject);
    	TypedQuery<Individual> tq=entityManager.createQuery(selectResult);
    	return tq.getResultList();
    }
    
	
}
