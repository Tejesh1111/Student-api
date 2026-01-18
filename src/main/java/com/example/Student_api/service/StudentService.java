package com.example.Student_api.service;

import java.util.List;

import com.example.Student_api.dto.StudentRequestDto;
import com.example.Student_api.dto.StudentResponseDto;

public interface StudentService {
	StudentResponseDto createStudent(StudentRequestDto request);
	List<StudentResponseDto> getAllStudents();
	StudentResponseDto getStudentById(Long id);
	StudentResponseDto updateStudent(Long id,StudentRequestDto request);
	void deleteStudent(Long id);
}
