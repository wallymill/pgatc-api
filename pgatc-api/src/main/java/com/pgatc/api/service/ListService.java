package com.pgatc.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgatc.api.data.entities.EnqueuedAircraft;
import com.pgatc.api.data.repositories.EnqueuedAircraftRepository;

@Service
public class ListService {
	
	@Autowired
	private EnqueuedAircraftRepository enqueuedAircraftRepository;
	
	public List<EnqueuedAircraft> listEnqueuedAircraft(){
		return enqueuedAircraftRepository.findByOrderByModelPriorityAscSizePriorityAscCreateDateTimeAsc();
	}
}