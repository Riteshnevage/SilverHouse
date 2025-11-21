package com.vithai.silverhouse.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.vithai.silverhouse.entity.Enquiry;
import com.vithai.silverhouse.service.EnquiryService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/enquiries")
public class EnquiryController {
    private final EnquiryService service;
    public EnquiryController(EnquiryService service) 
    {
    	this.service = service; 
    }

    @PostMapping
    public Enquiry create(@RequestBody Enquiry e) 
    {
    	return service.submit(e); 
    }

    @GetMapping
    public List<Enquiry> all() 
    {
    	return service.all(); 
   }
}

