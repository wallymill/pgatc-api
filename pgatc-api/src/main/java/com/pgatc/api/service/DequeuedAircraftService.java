package com.pgatc.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgatc.api.data.entities.DequeuedAircraft;
import com.pgatc.api.data.entities.EnqueuedAircraft;
import com.pgatc.api.data.repositories.DequeuedAircraftRepository;
import com.pgatc.api.data.repositories.EnqueuedAircraftRepository;
import com.pgatc.api.rest.exception.NoAircraftInQueueException;

@Service
public class DequeuedAircraftService {
	
	@Autowired
	DequeuedAircraftRepository dequeuedAircraftRepository;
	@Autowired
	EnqueuedAircraftRepository enqueuedAircraftRepository;
	
	public DequeuedAircraft dequeueAircraft() {
		EnqueuedAircraft ea = enqueuedAircraftRepository.findFirstByOrderByModelPriorityAscSizePriorityAscCreateDateTimeAsc();
		if (ea == null) {
			throw new NoAircraftInQueueException ("No aircraft currently in queue");
		}
		enqueuedAircraftRepository.delete(ea);
		return dequeuedAircraftRepository.save(new DequeuedAircraft(ea));
	}

}