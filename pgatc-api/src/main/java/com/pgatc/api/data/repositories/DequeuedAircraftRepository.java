package com.pgatc.api.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgatc.api.data.entities.DequeuedAircraft;

public interface DequeuedAircraftRepository extends JpaRepository<DequeuedAircraft, Long>{

}
