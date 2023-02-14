package com.boa.customerapi.queries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boa.customerapi.models.Individual;
import com.boa.customerapi.services.IndividualService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
@Component
public class IndividualGLQuery implements GraphQLQueryResolver {
	@Autowired
	private IndividualService individualService;
	
	public List<Individual> findAllIndividuals(){
		return this.individualService.getAllIndividuals();
	}
	public Individual findIndividual(long customerId) {
		return this.individualService.getIndividualById(customerId);
	}

	public List<Individual> findIndividualByFirstName(String firstName){
		return this.individualService.findAllByFirstName(firstName);
	}
}
