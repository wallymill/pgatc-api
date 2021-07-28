package com.pgatc.api.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import com.pgatc.api.data.mapped.superclasses.BaseMappedSuperclass;
import com.pgatc.api.data.mapped.superclasses.Priority;

@Entity
@Table(name="MODEL_PRIORITY", indexes = @Index(columnList = BaseMappedSuperclass.MODEL))
public class ModelPriority extends Priority{

	ModelPriority() {}

	public ModelPriority(String model, Integer priority) {
		this.model = model;
	    super.priority = priority;
	  }
	
	@Column(name=MODEL, nullable=false)
	private String model;

	public String getModel() {
		return model;
	}

	@Override
	public String toString() {
		return "ModelPriority [model=" + model + ", toString()=" + super.toString() + "]";
	}

}
