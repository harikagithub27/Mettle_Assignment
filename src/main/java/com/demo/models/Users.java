package com.demo.models;

import com.demo.flags.Featureflags;

public class Users {
	
	private Featureflags featureflags;
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Featureflags getFeatureflags() {
		return featureflags;
	}

	public void setFeatureflags(Featureflags featureflags) {
		this.featureflags = featureflags;
	}
	

}
