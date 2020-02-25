package com.pp.energyconsumption.model;

/**
 * 
 * @author prathameshpawar
 *
 */
public class Village {
	private Long id;
	private String name;

	public Long getId() {
		return id;
	}

	public Village(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
