package com.pgatc.api.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgatc.api.rest.exception.AppNotBootedException;

@RestController
public class BootController extends BaseRestController{
	
	private static final Logger LOG = LoggerFactory.getLogger(BootController.class);
	private static final String APPLICATION_STARTING_MSG = "PG ATC application has now booted successfully - Let's go!!";
	private static final String APPLICATION_STARTED_MSG = "PG ATC application is already booted - please continue";

	@PostMapping(value="/boot")
	public synchronized String boot() {
		try {
			super.isAppBooted();
			LOG.info(APPLICATION_STARTED_MSG);
			return APPLICATION_STARTED_MSG;
		} catch (AppNotBootedException e) {
			super.setIsBooted();
		}
		LOG.info(APPLICATION_STARTING_MSG);
		return APPLICATION_STARTING_MSG;
	}

}
