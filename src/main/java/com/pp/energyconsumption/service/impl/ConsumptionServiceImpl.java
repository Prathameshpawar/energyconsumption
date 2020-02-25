package com.pp.energyconsumption.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pp.energyconsumption.dao.ConsumptionDao;
import com.pp.energyconsumption.model.EnergyConsumption;
import com.pp.energyconsumption.model.EnergyConsumptionReport;
import com.pp.energyconsumption.model.VillageDetailsWrapper;
import com.pp.energyconsumption.service.ConsumptionService;
import com.pp.energyconsumption.service.proxy.EnergyConsumptionProxy;
import com.pp.energyconsumption.util.ConsumptionUtil;
/**
 * 
 * @author prathameshpawar
 *
 */
@Service
public class ConsumptionServiceImpl implements ConsumptionService {

	private static Logger LOGGER = LoggerFactory.getLogger(ConsumptionServiceImpl.class);

	private static final String dateFormat = "yyyy-MM-dd";
	@Autowired
	private ConsumptionDao consumptionDao;

	@Autowired
	private EnergyConsumptionProxy energyConsumptionProxy;

	@Override
	public boolean saveEnergyConsumption(EnergyConsumption consumption) {
		LOGGER.info("ConsumptionServiceImpl.saveEnergyConsumption()");
		Date date = new Date();
		consumption.setConsumptionDate(date);
		return consumptionDao.saveEnergyConsumption(consumption);
	}

	@Override
	public List<EnergyConsumptionReport> getConsumptionReport(String duration) {
		LOGGER.info("ConsumptionServiceImpl.getConsumptionReport()");
		Instant now = Instant.now();
		String value = ConsumptionUtil.removeNum(duration);
		int day = ConsumptionUtil.extractNumber(duration);
		if (value.equalsIgnoreCase("h") || value.equalsIgnoreCase("H")) {
			day = day / 24 == 0 ? 1 : day;
		}

		Instant yesterday = now.minus(day, ChronoUnit.DAYS);

		List<EnergyConsumption> lsConsumption = null;
		try {
			lsConsumption = consumptionDao.getConsumptionReport(
					new SimpleDateFormat(dateFormat).parse(yesterday.toString()),
					new SimpleDateFormat(dateFormat).parse(now.toString()));
		} catch (ParseException e1) {
			LOGGER.error("error while parsing date: " + e1.getMessage());
		}
		List<EnergyConsumptionReport> lsConsumptionReport = new ArrayList<>();

		lsConsumption.stream().forEach(energyConsumption -> {
			try {
				VillageDetailsWrapper villageDetails = energyConsumptionProxy
						.getVillageDetails(String.valueOf(energyConsumption.getCounterId()));
				EnergyConsumptionReport energyConsumptionReport = new EnergyConsumptionReport(
						villageDetails.getVillage().getId(), villageDetails.getVillage().getName(),
						energyConsumption.getAmount());
				lsConsumptionReport.add(energyConsumptionReport);
			} catch (Exception e) {
				LOGGER.error("error while parsing date: " + e.getMessage());
			}
		});

		LOGGER.info("ConsumptionServiceImpl.getConsumptionReport() : Size of report" + lsConsumptionReport.size());
		return lsConsumptionReport;
	}
}
