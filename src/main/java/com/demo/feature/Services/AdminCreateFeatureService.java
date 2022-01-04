package com.demo.feature.Services;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.demo.flags.Featureflags;
import com.demo.models.Users;

@Service
public class AdminCreateFeatureService {
	
	public static int counter = 0;
	public static Map<String,Featureflags> featuresFLags = new HashMap<String,Featureflags>();	
	public static List<Users> usersList = new ArrayList<>();
	
	static {
		Users user1 = new Users();
		user1.setUsername("user1");
		Featureflags featureflagsUser = new Featureflags();
		featureflagsUser.setFlagName("Flag1");
		featureflagsUser.setFLagStatus(Featureflags.flagStatusDisabled);
		user1.setFeatureflags(featureflagsUser);
		usersList.add(user1);
	}

	//currently switching only for static set of users defined above
	public String switchFeature(String userRole, String username, String feature) {
		String message = "";
		if(userRole.equalsIgnoreCase("ADMIN")) {
		for(Users user : usersList) {
			if(null != user.getFeatureflags() && user.getUsername().equalsIgnoreCase(username)) {
				if(null != user.getFeatureflags()) {
				user.getFeatureflags().setFLagStatus(Featureflags.flagStatusEnabled);
				message = "Successfully switched on for a User "+ username+ " with status "+ user.getFeatureflags().getFLagStatus();
				for(String featureflag : featuresFLags.keySet()) {	
					Featureflags ff = featuresFLags.get(featureflag);
					if(ff.getFlagName().equalsIgnoreCase(user.getFeatureflags().getFlagName()))
					ff.setFLagStatus(Featureflags.flagStatusEnabled);			
					}
				}else {
					message = "No Flags found for the user " + username;
				}
			}else {
				message = username + " Not Found";
			}
		}
		}
		return message;	
	}

	public Map<String,Featureflags> createFeature() {
		Featureflags ff = new Featureflags();
		ff.setFlagName("Flag" + ++counter);
		ff.setFLagStatus(Featureflags.flagStatusDisabled);
		featuresFLags.put("FeatureFlag"+counter, ff);
		return featuresFLags;
		
		
	}

	public List<String> getEnabledFeaturesforaUser(String userRole) {
		List<String> enabledFeatures = new ArrayList<>();
		if(userRole.equalsIgnoreCase("user1")) {
		for(String featureflag : featuresFLags.keySet()) {	
			Featureflags ff = featuresFLags.get(featureflag);
			if(null != ff && ff.getFLagStatus().equalsIgnoreCase(Featureflags.flagStatusEnabled)) {			
				enabledFeatures.add(ff.getFlagName());				
			}				
			}
		}
				
		return enabledFeatures;
	}
	 

}
