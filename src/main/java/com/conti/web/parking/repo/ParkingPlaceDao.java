package com.conti.web.parking.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.conti.web.parking.model.ParkingPlace;

@Transactional
@EnableTransactionManagement
public interface ParkingPlaceDao extends CrudRepository<ParkingPlace, Long> {

}
