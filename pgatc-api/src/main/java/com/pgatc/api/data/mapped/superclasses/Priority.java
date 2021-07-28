package com.pgatc.api.data.mapped.superclasses;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Priority extends BaseMappedSuperclass{
	
	@Column(name=PRIORITY, nullable=false)
	protected Integer priority;

	public Integer getPriority() {
		return priority;
	}

	@Override
	public String toString() {
		return "Priority [priority=" + priority + ", toString()=" + super.toString() + "]";
	}
	
}
