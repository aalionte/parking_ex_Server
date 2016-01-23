package com.conti.web.parking.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.conti.web.parking.model.ChargingStation;

@Transactional
@EnableTransactionManagement
public interface ChargingStationDao extends CrudRepository<ChargingStation, Long>{
	
	@Query("Select  cs from ChargingStation cs  join cs.parkingPlace pp on pp.isFree = true")
	public List<ChargingStation> findAllFreeChargingStations();

	@Query("select pp.isFree from ChargingStation cs join cs.parkingPlace pp on cs.id=?")
	public boolean findByIsFree(Long id);
}
