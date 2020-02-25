package com.pp.energyconsumption.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.NumberFormat;

/**
 * 
 * @author prathameshpawar
 *
 */
@Entity
@Table(name = "energy_consumption")
public class EnergyConsumption {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "counter_id")
	@Positive(message = "Please enter id")
	private Long counterId;

	@Column(name = "amount")
	@Positive(message = "Please enter amount")
	private Double amount;

	@Column(name = "consumption_date")
	@Temporal(TemporalType.DATE)
	private Date consumptionDate;

	public void setConsumptionDate(Date consumptionDate) {
		this.consumptionDate = consumptionDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCounterId() {
		return counterId;
	}

	public void setCounterId(Long counterId) {
		this.counterId = counterId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
