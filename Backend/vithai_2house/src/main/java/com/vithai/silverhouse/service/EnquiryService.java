package com.vithai.silverhouse.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.vithai.silverhouse.entity.Enquiry;
import com.vithai.silverhouse.repository.EnquiryRepository;

@Service
public class EnquiryService
{
    private final EnquiryRepository repo;
    public EnquiryService(EnquiryRepository repo) 
    {
    	this.repo = repo; 
    }
    public Enquiry submit(Enquiry e)
    {
    	return repo.save(e); 
    }
    public List<Enquiry> all()
    {
    	return repo.findAll(); 
    }
}
