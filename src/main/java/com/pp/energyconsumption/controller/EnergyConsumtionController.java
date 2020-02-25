package com.pp.energyconsumption.controller;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pp.energyconsumption.exception.MissingHeaderInfoException;
import com.pp.energyconsumption.model.EnergyConsumption;
import com.pp.energyconsumption.model.EnergyConsumptionReport;
import com.pp.energyconsumption.model.EnergyConsumptionReportWrapper;
import com.pp.energyconsumption.service.ConsumptionService;
import com.pp.energyconsumption.util.ConsumptionUtil;

/**
 * 
 * @author prathameshpawar
 *
 */
@RestController
public class EnergyConsumtionController {
	private static Logger LOGGER = LoggerFactory.getLogger(EnergyConsumtionController.class);
	@Autowired
	private ConsumptionService consumptionService;

	@PostMapping(value = "/counter_callback")
	public ResponseEntity<String> consumeEnergyData(@Valid EnergyConsumption consumption) {
		if (consumption == null || consumption.getCounterId() == null || consumption.getAmount() == null) {
			throw new MissingHeaderInfoException("Missing param.");
		}
		LOGGER.info("EnergyConsumtionController.consumeEnergyData().");
		
		consumptionService.saveEnergyConsumption(consumption);
		
		LOGGER.info("energy resource created.");
		
		return new ResponseEntity<String>("Resource created.", HttpStatus.CREATED);
	}

	@GetMapping(value = "/consumption_report")
	public ResponseEntity<EnergyConsumptionReportWrapper> getConsumptionReport(@RequestParam(required = true) String duration) {
		LOGGER.info("EnergyConsumtionController.getConsumptionReport().");
		
		List<EnergyConsumptionReport> consumptionReport = Collections.emptyList();
		if (ConsumptionUtil.validateDuration(duration)) {
			throw new MissingHeaderInfoException("Improper duration param.");
		} else {
			consumptionReport = consumptionService.getConsumptionReport(duration);
		}
		
		return new ResponseEntity<EnergyConsumptionReportWrapper>(new EnergyConsumptionReportWrapper(consumptionReport),
				HttpStatus.OK);
	}
}
