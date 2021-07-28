package com.pgatc.api.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import com.pgatc.api.data.mapped.superclasses.BaseMappedSuperclass;
import com.pgatc.api.data.mapped.superclasses.Priority;

@Entity
@Table(name="SIZE_PRIORITY", indexes = @Index(columnList = BaseMappedSuperclass.SIZE))
public class SizePriority extends Priority{
	
	SizePriority(){}
	
	public SizePriority(String size, Integer priority) {
		this.size = size;
		this.priority = priority;
	}
	
	@Column(name=SIZE, nullable=false)
	private String size;

	public String getSize() {
		return size;
	}

	@Override
	public String toString() {
		return "SizePriority [size=" + size + ", toString()=" + super.toString() + "]";
	}

}
