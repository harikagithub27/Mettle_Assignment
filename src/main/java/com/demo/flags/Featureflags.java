package com.demo.flags;

import org.springframework.stereotype.Component;

@Component
public class Featureflags {
	
	public static final String flagStatusEnabled = "ENABLED";
	public static final String flagStatusDisabled = "DISABLED";
	
	
	private String FlagName;
	private String FLagStatus;
	
	public String getFlagName() {
		return FlagName;
	}
	public void setFlagName(String flagName) {
		FlagName = flagName;
	}
	public String getFLagStatus() {
		return FLagStatus;
	}
	public void setFLagStatus(String fLagStatus) {
		FLagStatus = fLagStatus;
	}
	
	

}
