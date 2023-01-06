package com.javatechie.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.javatechie.dto.Course;

/**
 * 
 * @author 2095111 - Below we have written the core business logic
 *
 */

@Service
public class CourseService {

	// In CourseService will write logic to store in
	// List object since we don’t use DB as of now

	private List<Course> courseDatabase = new ArrayList<>();

	// 1 Logic: create or save object in DB. After saving object give the same as
	// return type

	public Course onboardNewCourse(Course course) {
		course.setCourseId(new Random().nextInt(3756));
		courseDatabase.add(course);
		return course;
	}

	// 2 Logic: User should see all courses available in DB

	public List<Course> viewAllCourses() {
		return courseDatabase;
	}

	// 3 Logic: Writing Method where a user can view the course if they have courseID
	// Filter a course object based on a input. For this usecase we can use Collection Interface in Java
	
	public Course findByCourseId(Integer courseId) {
		return courseDatabase.stream()
							 .filter(course -> course.getCourseId() == courseId)
							 .findFirst()
							 .orElse(null);
		
	// Above case: Iterating object from DB, then filtering input based on courseID otherwise returning null
	}
	
	
	// 4 Logic: Delete course from DB. This feature we need to expose it to end-user as well
	
	public void deleteCourse(int courseId) {
		Course course = findByCourseId(courseId);
		courseDatabase.remove(courseId);
	}
	
	
	// 5 Logic: Update the course. After update return me the updated course
	
	public Course updateCourse(int courseId, Course course) {
		Course existingCourse = findByCourseId(courseId);
		
		courseDatabase.set(courseDatabase.indexOf(existingCourse), course);	
		return course;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
