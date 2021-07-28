package com.pgatc.api.data.mapped.superclasses;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public class BaseMappedSuperclass {
	
	//setting duplicate column names as constants
	public static final String SIZE = "SZ";
	public static final String PRIORITY = "PRTY";
	public static final String MODEL = "MDL";
	public static final String AC_ID = "AC_ID";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
    @CreationTimestamp
    @Column(name="CRT_TS")
    private LocalDateTime createDateTime;
 
    @Column(name="UPD_TS")
    @UpdateTimestamp
    private LocalDateTime updateDateTime;

	@Override
	public String toString() {
		return "BaseMappedSuperclass [id=" + id + ", createDateTime=" + createDateTime + ", updateDateTime="
				+ updateDateTime + "]";
	}
	
}
