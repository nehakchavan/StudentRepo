package com.cybage.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cybage.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {
	public Student findByName(String name);
}
