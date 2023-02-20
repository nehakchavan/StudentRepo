package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.model.Student;
import com.cybage.repo.StudentRepo;

@Service
public class StudentService {
	@Autowired
	StudentRepo sr;
	Student s1;
	
	public Student addStudent(Student s) {
		s1 = sr.save(s);
		return s1;
	}
	
	public Student getStudent(int id) {
		s1 = sr.findById(id).orElse(null);
		return s1;
	}
	
	public List<Student> getAllStudents(){
		List<Student> l = sr.findAll();
		return l;
	}
	
	public Student updateStudent(Student s, int id) {
		s1 = sr.save(s);
		return s1;
	}
	
	public void deleteStudent(int id) {
		sr.deleteById(id);
	}
	
	public Student findByName(String name) {
		s1 = sr.findByName(name);
		return s1;
	}
}
