package com.pgatc.api.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pgatc.api.data.mapped.superclasses.Aircraft;

@Entity
@Table(name="ENQUEUED_AIRCRAFT")
public class EnqueuedAircraft extends Aircraft{

	EnqueuedAircraft(){}
	
	public EnqueuedAircraft(Integer aircraftId, ModelPriority model, SizePriority size) {
		this.aircraftId = aircraftId;
		this.modelPriority = model;
		this.sizePriority = size;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DQ_ID")
	private Long id;

	@Override
	public String toString() {
		return "EnqueuedAircraft [id=" + id + ", toString()=" + super.toString() + "]";
	}	
	
}
