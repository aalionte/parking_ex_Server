package com.conti.web.parking.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.conti.web.parking.model.ChargingStation;

@Repository
public interface ChargingStationDao extends CrudRepository<ChargingStation, Long>{
	
	@Query("Select  cs from ChargingStation cs  join cs.parkingPlace pp on pp.isFree = true")
	public List<ChargingStation> findAllFreeChargingStations();
}
