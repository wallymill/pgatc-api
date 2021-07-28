package com.pgatc.api.data.mapped.superclasses;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import com.pgatc.api.data.entities.ModelPriority;
import com.pgatc.api.data.entities.SizePriority;

@MappedSuperclass
public class Aircraft extends BaseMappedSuperclass{
	
	@Column(name=AC_ID, nullable = false)
	protected Integer aircraftId;
	
	@OneToOne()
	@JoinColumn(name=MODEL, nullable = false)
	protected ModelPriority modelPriority;
	
	@OneToOne()
	@JoinColumn(name=SIZE, nullable = false)
	protected SizePriority sizePriority;

	public Integer getAircraftId() {
		return aircraftId;
	}

	public ModelPriority getModelPriority() {
		return modelPriority;
	}

	public SizePriority getSizePriority() {
		return sizePriority;
	}

	@Override
	public String toString() {
		return "Aircraft [aircraftId=" + aircraftId + ", modelPriority=" + modelPriority + ", sizePriority=" + sizePriority + ", toString()="
				+ super.toString() + "]";
	}
	
}
