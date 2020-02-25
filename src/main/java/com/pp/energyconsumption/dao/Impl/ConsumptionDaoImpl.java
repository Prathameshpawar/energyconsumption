package com.pp.energyconsumption.dao.Impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pp.energyconsumption.dao.ConsumptionDao;
import com.pp.energyconsumption.model.EnergyConsumption;
import com.pp.energyconsumption.repository.ConsumptionRepository;

/**
 * 
 * @author prathameshpawar
 *
 */
@Repository
public class ConsumptionDaoImpl implements ConsumptionDao {
	private static Logger LOGGER = LoggerFactory.getLogger(ConsumptionDaoImpl.class);
	@Autowired
	private ConsumptionRepository consumptionRepository;

	@Override
	public boolean saveEnergyConsumption(EnergyConsumption consumption) {
		return consumptionRepository.save(consumption) != null;
	}

	@Override
	public List<EnergyConsumption> getConsumptionReport(Date fromDate, Date toDate) {
		List<EnergyConsumption> lsEnergyConsumption = null;
		try {
			lsEnergyConsumption = consumptionRepository.findAllByConsumptionDateBetween(fromDate, toDate);
		} catch (Exception e) {
			LOGGER.error("error in ConsumptionDaoImpl.getConsumptionReport() : " + e.getMessage());
		}
		return lsEnergyConsumption;
	}
}
