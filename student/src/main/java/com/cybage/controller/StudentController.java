package com.cybage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.exception.StudentNotFound;
import com.cybage.model.Student;
import com.cybage.service.StudentService;

@CrossOrigin(origins = "*")
@RestController
public class StudentController {
	
	@Autowired
	StudentService ser;
	Student s;
	
	@PostMapping("/addStudent")
	ResponseEntity<Student> addStudent(@RequestBody Student s1){
		s = ser.addStudent(s1);
		return new ResponseEntity<>(s, HttpStatus.OK);
	}
	
	@GetMapping("/getStudent/{id}")
	ResponseEntity<Student> getStudent(@PathVariable int id) throws StudentNotFound{
		s = ser.getStudent(id);
		if(s == null) {
			throw new StudentNotFound("Student entry not found");
		}
		System.out.println(s);
		return new ResponseEntity<>(s, HttpStatus.OK);
	}
	
	@GetMapping("/getStudentByName/{name}")
	ResponseEntity<Student> getStudentByName(@PathVariable String name) throws StudentNotFound{
		s = ser.findByName(name);
		if(s == null) {
			throw new StudentNotFound("Student entry not found");
		}
		System.out.println(s);
		return new ResponseEntity<>(s, HttpStatus.OK);
	}

	@GetMapping("/getAllStudents")
	ResponseEntity<List<Student>> getAllStudent() throws StudentNotFound{
		List<Student> l = ser.getAllStudents();
		if(l == null) {
			throw new StudentNotFound("Student list not available");
		}
		System.out.println(l);
		return new ResponseEntity<>(l, HttpStatus.OK);
	}
	
	@PutMapping("/updateStudent/{id}")
	ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student s1) throws StudentNotFound{
		if(ser.getStudent(id) == null) {
			throw new StudentNotFound("No student with given id present");
		}
		s = ser.updateStudent(s1, id);
		System.out.println(s);
		return new ResponseEntity<>(s, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public void deleteStudent(@PathVariable int id) throws StudentNotFound{
		if(ser.getStudent(id) == null) {
			throw new StudentNotFound("No student with given id present to delete the entry");
		}
		ser.deleteStudent(id);
	}
}
