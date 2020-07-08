package com.sync.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sync.dto.JoinEntityDto;
import com.sync.dto.StudentDto;
import com.sync.model.Student;
import com.sync.repository.LaptopRepository;
import com.sync.repository.StudentRepository;

@RestController
@RequestMapping("/api")
public class Controller {
	Logger logger = LoggerFactory.getLogger(Controller.class);

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private LaptopRepository laptopRepository;

	@PostMapping("/post")
	public Student save(@RequestBody StudentDto studentDto) {
		return studentRepository.save(studentDto.getStudent());
	}

	@GetMapping("/get")
	public ResponseEntity<List<Student>> get() {
		List<Student> students = studentRepository.findAll();
		return new ResponseEntity<>(students, HttpStatus.OK);
	}

	@GetMapping("/getJoinedData")
	public ResponseEntity<List<JoinEntityDto>> getJoin() {
		List<JoinEntityDto> students = studentRepository.getJoinedData();
		return new ResponseEntity<>(students, HttpStatus.OK);
	}

	@GetMapping("/getByRollNo/{rollNo}")
	public Student get(@PathVariable("rollNo") int rollNo) throws Exception {

		return studentRepository.findById(rollNo).orElseThrow(() -> new Exception("Roll doesnot exists"));
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Void> delete(@PathParam(value = "rollNo") int rollNo) {
		studentRepository.deleteById(rollNo);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/update/{rollNo}")
	public ResponseEntity<Void> update(@PathVariable("rollNo") int rollNo, @RequestBody StudentDto studentDto)
			throws Exception {
		logger.info("updating information");
		// studentRepository.findById(rollNo);
		// .orElseThrow(() -> new Exception("rollNo doesnt exist"));
		studentDto.getStudent().setRollNo(rollNo);
		studentRepository.save(studentDto.getStudent());
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
