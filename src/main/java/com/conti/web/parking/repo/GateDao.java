package com.conti.web.parking.repo;

import com.conti.web.parking.model.Gate;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@EnableTransactionManagement
public interface GateDao extends CrudRepository<Gate, Long> {

	public Gate findByName(String name);
}
