package com.pgatc.api.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgatc.api.data.entities.EnqueuedAircraft;
import com.pgatc.api.data.entities.ModelPriority;
import com.pgatc.api.data.entities.SizePriority;
import com.pgatc.api.service.EnqueuedAircraftService;

@RestController
public class EnqueueController extends BaseRestController{
	
	private static final Logger log = LoggerFactory.getLogger(EnqueueController.class);
	
	private Object lock = new Object();
	
	@Autowired
	EnqueuedAircraftService enqueuedAircraftService;
	
	@PostMapping(value="/enqueue/{id}/{model}/{size}")
	public ResponseEntity<String> enqueue
				(@PathVariable Integer id, 
	             @PathVariable String model, 
	             @PathVariable String size){
		super.isAppBooted();
		log.info("attempting to enqueue - id:  {}  model:  {}  size:  {}", id, model, size);
		synchronized(lock) {
			enqueuedAircraftService.findEnqueuedAircraft(id);
			ModelPriority mp = enqueuedAircraftService.findModelPriority(model);
			SizePriority  sp = enqueuedAircraftService.findSizePriority(size);
			enqueuedAircraftService.enqueueAircraft(new EnqueuedAircraft(id, mp, sp));
		}
		return ResponseEntity.ok("flight " + id + " enqueued");
	}

}
