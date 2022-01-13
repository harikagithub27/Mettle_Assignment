package com.demo.feature.Services;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.demo.flags.Featureflags;
import com.demo.models.Users;

@Service
public class AdminCreateFeatureService {
	
	public static int counter = 0;
	public static Map<String,Featureflags> featuresFLags = new HashMap<String,Featureflags>();	
	public static List<Users> usersList = new ArrayList<>();
	
	// creating dummy data of users 
	static {
		Users user1 = new Users();
		user1.setUsername("user1");
		Featureflags featureflagsUser1 = new Featureflags();
		featureflagsUser1.setFlagName("Flag1");
		featureflagsUser1.setFLagStatus(Featureflags.flagStatusDisabled);
		List<Featureflags> userOneFF = new ArrayList<>();
		userOneFF.add(featureflagsUser1);
		user1.setFeatureflags(userOneFF);
		
		Users user2 = new Users();
		user2.setUsername("user2");
		Featureflags featureflagsUser2 = new Featureflags();
		featureflagsUser2.setFlagName("Flag2");
		featureflagsUser2.setFLagStatus(Featureflags.flagStatusEnabled);
		List<Featureflags> userTwoFF = new ArrayList<>();
		userTwoFF.add(featureflagsUser2);
		user2.setFeatureflags(userTwoFF);
		
		Users user3 = new Users();
		user3.setUsername("user3");
		Featureflags featureflagsUser3 = new Featureflags();
		featureflagsUser3.setFlagName("Flag1");
		featureflagsUser3.setFLagStatus(Featureflags.flagStatusDisabled);
		List<Featureflags> userThreeFF = new ArrayList<>();
		userThreeFF.add(featureflagsUser3);
		
		Featureflags featureflagsUser31 = new Featureflags();
		featureflagsUser31.setFlagName("Flag2");
		featureflagsUser31.setFLagStatus(Featureflags.flagStatusEnabled);
		userThreeFF.add(featureflagsUser31);
		user3.setFeatureflags(userThreeFF);
			
		usersList.add(user1);
		usersList.add(user2);
		usersList.add(user3);
	
	}

	//currently switching only for static set of users defined above
	public String switchFeature(String userRole, String username, String feature) {
		String message = "";
		boolean userNameFound = false;
		boolean flagFound = false;
		if(userRole.equalsIgnoreCase("ADMIN")) {
		for(Users user : usersList) {
			if(user.getUsername().equalsIgnoreCase(username)) {
				userNameFound = true;
				if(null != user.getFeatureflags()) {
					List<Featureflags> ffList = user.getFeatureflags();
					for(Featureflags ffg : ffList) {
						if(ffg.getFlagName().equalsIgnoreCase(feature)) {
							flagFound = true;
							ffg.setFLagStatus(Featureflags.flagStatusEnabled);
							message = "Successfully switched on for a User "+ username+ " with status "+ ffg.getFLagStatus()+ " for flag Name " + ffg.getFlagName();
						}					
					}	
					if(!flagFound) {
						message = "Given Flag not found for the user " + username;
					}
								
				}else {
					message = "No Flags found for the user " + username;
				}
			}
		}
		if(!userNameFound) {
			message = username + " not Found !";
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
		//fetching user specific enabled flags
		for(Users user : usersList) {
		if(userRole.equalsIgnoreCase(user.getUsername())) {
			List<Featureflags> ff = user.getFeatureflags();
			for(Featureflags ffg : ff) {
			if(ffg.getFLagStatus().equalsIgnoreCase(Featureflags.flagStatusEnabled)) {
				enabledFeatures.add(ffg.getFlagName());
			}
			}
		}
	}
		//fetching globally enabled flags
		for(String featureflag : featuresFLags.keySet()) {	
			Featureflags ff = featuresFLags.get(featureflag);
			if(null != ff && ff.getFLagStatus().equalsIgnoreCase(Featureflags.flagStatusEnabled)) {			
				enabledFeatures.add(ff.getFlagName());				
			}				
			}
				
		return enabledFeatures;
	}
	 

}
