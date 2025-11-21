package com.vithai.silverhouse.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.vithai.silverhouse.entity.Enquiry;

public interface EnquiryRepository extends JpaRepository<Enquiry, Long> 
{
	List<Enquiry> findAll();
}

