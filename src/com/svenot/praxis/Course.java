package com.svenot.praxis;


/**********************************************************************************************************************
We have an interview question today:

Input comes from a file containing pipe-delimited records with three fields: student id (a positive integer), 
course title (a string), and score (a positive integer). You may assume that any combination of student id and course 
is unique. Here’s an example input file:

22|Math|45
23|English|52
22|English|51
26|Math|72
23|Math|61
21|English|81

The file may have any number of records, and there is no limit on the number of unique courses. 
You should write a program to read the file and write a list of all courses in the file, combined with the score of the
 lowest-numbered student in the course. Thus, the correct output for the input shown above is:

Math 45
English 81
**********************************************************************************************************************/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Course {

	public static void main(String[] args) {

		HashMap<String, ArrayList<Student>> courseMap = new HashMap<>();
		FileInputStream fstream = null;
		BufferedReader br = null;
		String strLine = null;

		try {

			fstream = new FileInputStream("input.txt");
			br = new BufferedReader(new InputStreamReader(fstream));

			// let sort per courses
			while ((strLine = br.readLine()) != null) {
				String[] values = strLine.trim().split("\\|");
				if (values.length != 3) {
					System.out.println("invalid row " + strLine + " skipping...");
					continue;
				}

				String studentId = values[0].trim();
				String course = values[1].trim();
				String ranking = values[2].trim();

				if (!courseMap.containsKey(course))
					courseMap.put(course, new ArrayList<Student>());

				courseMap.get(course).add(new Student(studentId, Integer.parseInt(ranking)));
			}

		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException ie) {
					System.out.println("Error:" + ie.getMessage());
				}
			}

		}

		for (String course : courseMap.keySet()) {
			ArrayList<Student> students = courseMap.get(course);
			Student selected = students.get(0);
			for (Student s : students) {
				int currentId = Integer.parseInt(s.getId());
				int selectedId = Integer.parseInt(selected.getId());
				if (currentId < selectedId) {
					selected = s;
				}
			}

			System.out.println(course + ":" + selected.getRanking());
		}

	}

}

class Student {

	private String id;
	private int ranking;

	public Student(String id, int ranking) {
		this.id = id;
		this.ranking = ranking;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

}
