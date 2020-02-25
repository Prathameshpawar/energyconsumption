package com.pp.energyconsumption.service;

import java.util.List;

import com.pp.energyconsumption.model.EnergyConsumption;
import com.pp.energyconsumption.model.EnergyConsumptionReport;

/**
 * 
 * @author prathameshpawar
 *
 */
public interface ConsumptionService {

	public boolean saveEnergyConsumption(EnergyConsumption consumption);
	public List<EnergyConsumptionReport> getConsumptionReport(String duration);
}
