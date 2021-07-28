package com.pgatc.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgatc.api.data.entities.EnqueuedAircraft;
import com.pgatc.api.data.entities.ModelPriority;
import com.pgatc.api.data.entities.SizePriority;
import com.pgatc.api.data.repositories.EnqueuedAircraftRepository;
import com.pgatc.api.data.repositories.ModelPriorityRepository;
import com.pgatc.api.data.repositories.SizePriorityRepository;
import com.pgatc.api.rest.exception.AircraftAlreadyEnqueuedException;

@Service
public class EnqueuedAircraftService {
	@Autowired
	EnqueuedAircraftRepository enqueuedAircraftRepository;
	
	@Autowired
	ModelPriorityRepository modelPriorityRepository;
	
	@Autowired
	SizePriorityRepository sizePriorityRepository;
	
	public ModelPriority findModelPriority (String model) {
		return modelPriorityRepository.findByModelIgnoreCase(model);
	}
	
	public SizePriority findSizePriority (String size) {
		return sizePriorityRepository.findBySizeIgnoreCase(size);
	}
	
	public EnqueuedAircraft findEnqueuedAircraft (Integer aircraft) {
		EnqueuedAircraft ea = enqueuedAircraftRepository.findByAircraftId(aircraft);
		if (ea != null) {
			throw new AircraftAlreadyEnqueuedException("Flight " + aircraft + " is already enqueued");
		}
		return ea;
	}
	
	public EnqueuedAircraft enqueueAircraft (EnqueuedAircraft enqueuedAircraft) {
		return enqueuedAircraftRepository.save(enqueuedAircraft);
	}

}
