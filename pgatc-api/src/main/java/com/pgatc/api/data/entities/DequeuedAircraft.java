package com.pgatc.api.data.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.pgatc.api.data.mapped.superclasses.Aircraft;

@Entity
@Table(name="DEQUEUED_AIRCRAFT")
public class DequeuedAircraft extends Aircraft{
	
	DequeuedAircraft(){}
	
	public DequeuedAircraft(Aircraft aircraft) {
		this.aircraftId = aircraft.getAircraftId();
		this.modelPriority = aircraft.getModelPriority();
		this.sizePriority = aircraft.getSizePriority();
	}

	@Override
	public String toString() {
		return "DequeuedAircraft [aircraftId=" + aircraftId + ", modelPriority=" + modelPriority + ", sizePriority=" + sizePriority + ", toString()="
				+ super.toString() + "]";
	}

}
