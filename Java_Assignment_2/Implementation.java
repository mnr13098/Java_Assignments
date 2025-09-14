package com.example.Java2Ass.model;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Implementation {

	public static Map<String, Long> getCount(List<Candidate> list){
		
		return list.stream().collect(Collectors.groupingBy(Candidate::getGender, Collectors.counting()));
		
	}
	
	public static Map<String, Double> getAverageAge(List<Candidate> list){
		return list.stream().collect(Collectors.groupingBy(Candidate::getGender, Collectors.averagingInt(Candidate::getAge)));
		
	}
	
	public static Map<String, Long> countCandidatesDepartmentWise(List<Candidate> list){
		return list.stream().collect(Collectors.groupingBy(Candidate::getDepartment, Collectors.counting()));
		
	}
	
	public static Optional<Candidate> getYoungestCandidateDetails(List<Candidate> list){
		return list.stream()
                .filter(c -> c.getGender().equalsIgnoreCase("Male") 
                        && c.getDepartment().equalsIgnoreCase("Product Development"))
              .min(Comparator.comparingInt(Candidate::getAge));
	}
}

