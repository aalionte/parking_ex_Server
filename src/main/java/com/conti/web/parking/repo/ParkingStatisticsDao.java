package com.conti.web.parking.repo;

import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.conti.web.parking.model.ParkingStatistics;

@Transactional
@EnableTransactionManagement
public interface ParkingStatisticsDao extends CrudRepository<ParkingStatistics, Long> {

	@Modifying
	/*
	 * update parking_statistics set exit_time ='2010-02-12' where gate_id =1 and parking_place_id=13 and exit_time is null
	 */
	@Query("update ParkingStatistics ps set exit_time=:now where parking_place_id=:parking_place_id and gate_id=:gate_id and exit_time is null")
	void exit(@Param("parking_place_id") Long parkingPlaceId, @Param("gate_id")Long gateId, @Param("now") DateTime now);

}
