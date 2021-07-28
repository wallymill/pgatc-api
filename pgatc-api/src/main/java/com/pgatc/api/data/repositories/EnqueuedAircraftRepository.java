package com.pgatc.api.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgatc.api.data.entities.EnqueuedAircraft;

public interface EnqueuedAircraftRepository extends JpaRepository<EnqueuedAircraft, Long>{

	public EnqueuedAircraft findByAircraftId (Integer aircraftId);
	
	public List<EnqueuedAircraft> findByOrderByModelPriorityAscSizePriorityAscCreateDateTimeAsc();
	
	public EnqueuedAircraft findFirstByOrderByModelPriorityAscSizePriorityAscCreateDateTimeAsc();
	
}