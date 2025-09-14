package com.example.Java2Ass.model;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Candidate> candidates = Arrays.asList(
				
		new Candidate("MNR", 1, 22, "Male", "Product Development", 2025, 10000),
        new Candidate("Priya", 2, 23, "Female", "HR", 2021, 50000),
        new Candidate("Santosh", 3, 22, "Male", "Product Development", 2024, 10000),
        new Candidate("Sonam", 4, 21, "Female", "Sales", 2025, 30000),
        new Candidate("Veeru", 5, 25, "Male", "HR", 2023, 10000)
        
		);
		
		System.out.println("Count (Male/Female): " + Implementation.getCount(candidates));
        System.out.println("Average Age (Male/Female): " + Implementation.getAverageAge(candidates));
        System.out.println("Count Department Wise: " + Implementation.countCandidatesDepartmentWise(candidates));
        System.out.println("Youngest Male in Product Development: " +
                Implementation.getYoungestCandidateDetails(candidates).orElse(null));

	}

}
