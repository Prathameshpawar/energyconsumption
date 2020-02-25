package com.pp.energyconsumption.dao;

import java.util.Date;
import java.util.List;

import com.pp.energyconsumption.model.EnergyConsumption;

/**
 * 
 * @author prathameshpawar
 *
 */
public interface ConsumptionDao {
	public boolean saveEnergyConsumption(EnergyConsumption consumption);
	public List<EnergyConsumption> getConsumptionReport(Date fromDate,Date toDate);
}
