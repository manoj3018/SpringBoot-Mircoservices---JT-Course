package com.javatechie.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.dto.Course;
import com.javatechie.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	private CourseService courseService;

	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}
	
	
	// 1. Write a REST API to create/ADD a Course
	
	@PostMapping
	public ResponseEntity<?> addCourse(@RequestBody Course course) {
		Course newCourse = courseService.onboardNewCourse(course);
		return new ResponseEntity<>(newCourse, HttpStatus.CREATED); // 201
	}
	
	// 2. Another Controller method to view all the course
	
	@GetMapping
	public ResponseEntity<?> findAllCourse(){ // Don't want to mention any input just want to fetch the info from DB
		return new ResponseEntity<>(courseService.viewAllCourses(), HttpStatus.OK);
	}
	
	
	// 3. Find course by ID using PathVariable
	
	@GetMapping("/search/path/{courseId}")
	public ResponseEntity<?> findCourse(@PathVariable Integer courseId) {
		return new ResponseEntity<>(courseService.findByCourseId(courseId), HttpStatus.OK);
	}
	
	// 3.1 Find course using RequestParam 
	
	@GetMapping("/search/request")
	public ResponseEntity<?> findCourseUsingRequestParam(@RequestParam(required = false) Integer courseId) {
		return new ResponseEntity<>(courseService.findByCourseId(courseId), HttpStatus.OK);
	}
	
	// 4. Delete course
	@DeleteMapping("/{courseId}")
	public ResponseEntity<?> deleteCourse(@PathVariable int courseId){
		courseService.deleteCourse(courseId);
		return new ResponseEntity<>("", HttpStatus.OK); // Since there is no body in the delete method, we mentioned as null
	}
	
	
	//5. Update: For updating we need 2 input [CourseID get it from DB- existing object]
	
	@PutMapping("/{courseId}")
	public ResponseEntity<?> updateCourse(@PathVariable int courseId,@RequestBody Course course) {
		return new ResponseEntity<>(courseService.updateCourse(courseId, course), HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
