package com.pp.energyconsumption.service.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pp.energyconsumption.model.VillageDetailsWrapper;
/**
 * 
 * @author prathameshpawar
 *
 */
@FeignClient(name = "counters", url = "https://europe-west2-zenhomes-development-project.cloudfunctions.net/counters")
public interface EnergyConsumptionProxy {

	@GetMapping("/{id}")
	public VillageDetailsWrapper getVillageDetails(@PathVariable String id);
}
