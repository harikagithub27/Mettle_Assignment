package com.demo.configs;

import java.io.File;

import org.togglz.core.Feature;
import org.togglz.core.manager.TogglzConfig;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.repository.file.FileBasedStateRepository;
import org.togglz.core.user.FeatureUser;
import org.togglz.core.user.SimpleFeatureUser;
import org.togglz.core.user.UserProvider;

import com.demo.enums.AdminFeatures;

public class ToggleConfig implements TogglzConfig{

	@Override
	public Class<? extends Feature> getFeatureClass() {
		// TODO Auto-generated method stub
		return AdminFeatures.class;
	}

	@Override
	public StateRepository getStateRepository() {
		// TODO Auto-generated method stub
		return  new FileBasedStateRepository(new File("/application.properties"));
	}

	@Override
		  public UserProvider getUserProvider() {
	            return new UserProvider() {
	                @Override
	                public FeatureUser getCurrentUser() {
	                    return new SimpleFeatureUser("admin", true);
	                }
	            };
	        }
	}


