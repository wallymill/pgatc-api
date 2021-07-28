package com.pgatc.api.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.pgatc.api.rest.exception.AppNotBootedException;

@org.springframework.web.bind.annotation.RestController

@RequestMapping(value = "/pgatc-rest-api")
public class BaseRestController {
	private static boolean isBooted;
	private Object lock1 = new Object(), lock2 = new Object();
	
	protected boolean isAppBooted() {
		synchronized(lock1) {
			if (isBooted) {
				return true;
			} else {
				throw new AppNotBootedException("PG ACT application NOT booted - try again later");
			}
		}
	}
	
	protected void setIsBooted() {
		synchronized(lock2) {
			isBooted = true;
		}
	}
	
}
