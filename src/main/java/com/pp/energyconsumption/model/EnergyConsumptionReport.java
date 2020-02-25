package com.pp.energyconsumption.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author prathameshpawar
 *
 */
public class EnergyConsumptionReport {

	@JsonIgnore
	private Long villageId;
	@JsonProperty("village_name")
	private String villageName;
	private Double consumption;

	public EnergyConsumptionReport(Long villageId, String villageName, Double consumption) {
		super();
		this.villageId = villageId;
		this.villageName = villageName;
		this.consumption = consumption;
	}

	public Long getVillageId() {
		return villageId;
	}

	public void setVillageId(Long villageId) {
		this.villageId = villageId;
	}

	public String getVillageName() {
		return villageName;
	}

	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}

	public Double getConsumption() {
		return consumption;
	}

	public void setConsumption(Double consumption) {
		this.consumption = consumption;
	}

}
