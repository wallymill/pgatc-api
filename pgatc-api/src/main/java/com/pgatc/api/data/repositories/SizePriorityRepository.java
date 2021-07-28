package com.pgatc.api.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgatc.api.data.entities.SizePriority;

public interface SizePriorityRepository extends JpaRepository<SizePriority, Long>{
	
	public SizePriority findBySizeIgnoreCase (String size);

}
