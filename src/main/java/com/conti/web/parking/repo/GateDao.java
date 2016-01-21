package com.conti.web.parking.repo;

import com.conti.web.parking.model.Gate;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GateDao extends CrudRepository<Gate, Long> {

	public Gate findByName(String name);
}
