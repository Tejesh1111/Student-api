package com.example.Student_api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Student_api.dto.StudentRequestDto;
import com.example.Student_api.dto.StudentResponseDto;
import com.example.Student_api.entity.Student;
import com.example.Student_api.repository.StudentRepository;
import com.example.Student_api.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	private final StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public StudentResponseDto createStudent(StudentRequestDto request) {
		// TODO Auto-generated method stub
		Student student = new Student();
		student.setName(request.getName());
		student.setEmail(request.getEmail());
		student.setAge(request.getAge());
		
		Student savedStudent = studentRepository.save(student);
		
		StudentResponseDto response = new StudentResponseDto();
		
		response.setId(savedStudent.getId());
		response.setName(savedStudent.getName());
		response.setEmail(savedStudent.getEmail());
		response.setAge(savedStudent.getAge());
		
		return response;
	}

	@Override
	public List<StudentResponseDto> getAllStudents() {
		// TODO Auto-generated method stub
		List<Student> students = studentRepository.findAll();
		List<StudentResponseDto> responseList = new ArrayList<>();
		
		for(Student student : students)
		{
			StudentResponseDto dto = new StudentResponseDto();
			dto.setId(student.getId());
			dto.setName(student.getName());
			dto.setEmail(student.getEmail());
			dto.setAge(student.getAge());
			responseList.add(dto);
		}
		return responseList;
	}

	@Override
	public StudentResponseDto getStudentById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentResponseDto updateStudent(Long id, StudentRequestDto request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteStudent(Long id) {
		// TODO Auto-generated method stub
		
	}
}
