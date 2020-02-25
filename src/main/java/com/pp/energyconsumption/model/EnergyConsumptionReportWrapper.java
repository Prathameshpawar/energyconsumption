package com.pp.energyconsumption.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author prathameshpawar
 *
 */
public class EnergyConsumptionReportWrapper {

	public EnergyConsumptionReportWrapper(List<EnergyConsumptionReport> energyConsumptionReport) {
		super();
		this.energyConsumptionReport = energyConsumptionReport;
	}

	@JsonProperty("village")
	private List<EnergyConsumptionReport> energyConsumptionReport;

	public List<EnergyConsumptionReport> getEnergyConsumptionReport() {
		return energyConsumptionReport;
	}

	public void setEnergyConsumptionReport(List<EnergyConsumptionReport> energyConsumptionReport) {
		this.energyConsumptionReport = energyConsumptionReport;
	}

}
