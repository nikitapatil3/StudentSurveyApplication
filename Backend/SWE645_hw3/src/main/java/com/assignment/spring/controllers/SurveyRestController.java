package com.assignment.spring.controllers;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.assignment.spring.models.SurveyClass;
import com.assignment.spring.services.SurveyServiceImpl;

@CrossOrigin(origins = "*")
@RestController
public class SurveyRestController {
	
	//survice class DI
	@Autowired
	private SurveyServiceImpl surveyServiceIm;
	
	//get method for all the survey
	@RequestMapping("/survey")
	public List<SurveyClass> getAllSurveys() {
		return surveyServiceIm.getAllSurveys();
	}
	
	//get method to get a single survey
	@RequestMapping("/survey/{id}")
	public Optional<SurveyClass> getSurvey(@PathVariable String id) {
		return surveyServiceIm.getSurvey(id);
	}
	
	
	//post method and api to add a new survey
	@RequestMapping(method = RequestMethod.POST, value="/addSurvey")
	public void addSurvey(@RequestBody SurveyClass survey) {
		surveyServiceIm.addSurvey(survey);
	}
}
