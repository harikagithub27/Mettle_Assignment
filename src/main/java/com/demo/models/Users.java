package com.demo.models;

import java.util.List;

import com.demo.flags.Featureflags;

public class Users {
	
	private List<Featureflags> featureflags;
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Featureflags> getFeatureflags() {
		return featureflags;
	}

	public void setFeatureflags(List<Featureflags> featureflags) {
		this.featureflags = featureflags;
	}
	

}
