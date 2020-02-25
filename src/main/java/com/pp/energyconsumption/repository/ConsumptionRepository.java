package com.pp.energyconsumption.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pp.energyconsumption.model.EnergyConsumption;
/**
 * 
 * @author prathameshpawar
 *
 */
public interface ConsumptionRepository extends JpaRepository<EnergyConsumption, Long> {
	
	public List<EnergyConsumption> findAllByConsumptionDateBetween(Date start, Date end);

}
