package com.sync.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sync.dto.JoinEntityDto;
import com.sync.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	@Query("SELECT new com.sync.dto.JoinEntityDto(s.rollNo,l.name) FROM Student s JOIN s.laptops l")
	public List<JoinEntityDto> getJoinedData();
}

