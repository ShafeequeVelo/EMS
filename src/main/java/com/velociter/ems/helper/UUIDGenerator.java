package com.velociter.ems.helper;

import java.util.UUID;

public class UUIDGenerator {
	private String id;
	
	public String getID() {
		this.id = UUID.randomUUID().toString().replace("-", "").substring(0,15);
		return id;
	}

}
