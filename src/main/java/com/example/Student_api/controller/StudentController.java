package com.example.Student_api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Student_api.dto.StudentRequestDto;
import com.example.Student_api.dto.StudentResponseDto;
import com.example.Student_api.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {
	private final StudentService studentService;
	
	public StudentController(StudentService studentService)
	{
		this.studentService = studentService;
	}
	
	@PostMapping
	public ResponseEntity<StudentResponseDto> createStudent(@Valid @RequestBody StudentRequestDto request){
		
		StudentResponseDto response = studentService.createStudent(request);
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<StudentResponseDto>> getAllStudents(){
		return ResponseEntity.ok(studentService.getAllStudents());
	}
}
