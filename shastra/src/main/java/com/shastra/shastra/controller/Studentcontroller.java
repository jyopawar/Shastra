package com.shastra.shastra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shastra.shastra.model.Student;
import com.shastra.shastra.service.Studentservice;

@Controller
public class Studentcontroller {

	@Autowired
	Studentservice  studentService;
	
//	@RequestMapping("/home")
//	public String registrationForStudent() {
//		return "Reg";
//	}
		
	
	@PostMapping("/addStudent")
	public String addStudent(@ModelAttribute("student")Student student ) {
	  studentService.addStudent(student);
	  return "redirect:/students";
	}

	@GetMapping("/students")
	public String listStudent(Model model) {
		  model.addAttribute("students", studentService.getAllStudents());
		return "students";	
	}
	
	@GetMapping("/addNewStudent")
	public String createStudentForm(Model model) {
		Student student =new Student();
		model.addAttribute("student", student);
		return "create_student";
	}
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id,Model model) {
			model.addAttribute("student", studentService.getStudentById(id));
			return "edit_student";	
		}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,@ModelAttribute("student") Student student,Model model) {	 
		Student existingStudent=studentService.getStudentById(id);
		existingStudent.setId(id);
		 existingStudent.setFirstName(student.getFirstName());
		 existingStudent.setMiddleName(student.getMiddleName());
		 existingStudent.setLastName(student.getLastName());
		 existingStudent.setPhone(student.getPhone());
		 existingStudent.setEmail(student.getEmail());
		 studentService.updateStudent(existingStudent);
		return "redirect:/students";
		
	}
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
			studentService.deleteStudentById(id);
			return "redirect:/students";
	}
	
	@GetMapping("/students/{pageNo}/{pageSize}")
	public @ResponseBody List<Student> getPaginated(@PathVariable int pageNo,@PathVariable int pageSize){
		return studentService.findPaginated(pageNo, pageSize);
		
	}
	
}

