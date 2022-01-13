package com.demo.flags;

import org.springframework.stereotype.Component;

@Component
public class Featureflags {
	
	public static final String flagStatusEnabled = "ENABLED";
	public static final String flagStatusDisabled = "DISABLED";
	
	
	private String flagName;
	private String flagStatus;
	
	public String getFlagName() {
		return flagName;
	}
	public void setFlagName(String fgName) {
		flagName = fgName;
	}
	public String getFLagStatus() {
		return flagStatus;
	}
	public void setFLagStatus(String fLagStatus) {
		flagStatus = fLagStatus;
	}
	
	

}
