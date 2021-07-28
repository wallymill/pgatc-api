package com.pgatc.api.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgatc.api.data.entities.EnqueuedAircraft;
import com.pgatc.api.service.ListService;

@RestController
public class ListController extends BaseRestController{
	
	private final Object lock = new Object();
	
	@Autowired
	private ListService listService;
	
	@GetMapping(value="/list", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EnqueuedAircraft>> enqueue(){
		super.isAppBooted();
		List<EnqueuedAircraft> eac =null;
		synchronized(lock) {
			eac = listService.listEnqueuedAircraft();
		}
		return ResponseEntity.ok(eac);
	}
	
}
