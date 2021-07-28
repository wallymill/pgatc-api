package com.pgatc.api.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgatc.api.data.entities.DequeuedAircraft;
import com.pgatc.api.service.DequeuedAircraftService;

@RestController
public class DequeueController extends BaseRestController{
	
	private Object lock = new Object();
	
	@Autowired
	DequeuedAircraftService dequeuedAircraftService;
	
	@PostMapping(value="/dequeue")
	public ResponseEntity<DequeuedAircraft> enqueue() {
		super.isAppBooted();
		DequeuedAircraft da = null;
		synchronized(lock) {
			da = dequeuedAircraftService.dequeueAircraft();
		}
		return ResponseEntity.ok(da);
	}
}
