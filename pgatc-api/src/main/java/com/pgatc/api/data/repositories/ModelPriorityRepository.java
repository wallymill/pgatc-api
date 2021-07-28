package com.pgatc.api.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pgatc.api.data.entities.ModelPriority;

@Repository
public interface ModelPriorityRepository extends JpaRepository<ModelPriority, Long>{

	public ModelPriority findByModelIgnoreCase (String model);
	
}