package com.shastra.shastra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shastra.shastra.model.Batch;
import com.shastra.shastra.service.Batchservice;

@Controller
public class Batchcontroller {
	
	@Autowired
	Batchservice batchservice;
	
	@GetMapping("/addBatchStudent")
	public String addBatchToStudent(Model model) {
		Batch batch=new Batch();
		model.addAttribute("batch",batch);
		return "add_batch";
		
	}
	@PostMapping("/addBatch")
	public String addBatch(@ModelAttribute("batch") Batch batch) {
		batchservice.addBatch(batch);
		return "redirect:/batches";	
	}
	
	@GetMapping("/batches")
	public String listbatch(Model model) {
		  model.addAttribute("batches", batchservice.getAllbatches());
		return "batch_details";	
	}


}
