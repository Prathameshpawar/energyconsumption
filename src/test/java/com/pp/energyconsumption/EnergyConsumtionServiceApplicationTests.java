package com.pp.energyconsumption;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pp.energyconsumption.model.EnergyConsumption;
import com.pp.energyconsumption.model.EnergyConsumptionReport;
import com.pp.energyconsumption.service.ConsumptionService;

/**
 * 
 * @author prathameshpawar
 *
 */
@SpringBootTest
class EnergyConsumtionServiceApplicationTests {

	@Autowired
	private ConsumptionService consumptionService;

	@Test
	public void testSaveConsumption() {
		EnergyConsumption e1 = new EnergyConsumption();
		e1.setAmount(50000d);
		e1.setCounterId(1L);
		boolean isEnergyConsumptionSaved = consumptionService.saveEnergyConsumption(e1);
		assertEquals(true, isEnergyConsumptionSaved);
	}

	@Test
	public void testGetConsumptionReport() {
		List<EnergyConsumptionReport> consumptionReport = consumptionService.getConsumptionReport("24h");
		assertEquals(1, consumptionReport.size());
		assertEquals("Villarriba", consumptionReport.get(0).getVillageName());
		assertEquals(50000.0, consumptionReport.get(0).getConsumption());

	}
}
