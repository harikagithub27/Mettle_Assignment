package com.demo.feature.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.feature.Services.AdminCreateFeatureService;
import com.demo.flags.Featureflags;



@RestController
public class FeatureFlagsController {
	
	public static final String errorMessageCreate = "Not a Valid User to create Flags";
	public static final String errorMessageSwitch = "Not a Valid User to switch Flags for a User";
	public static final String errorMessageFeatures = "No Enabled Features found";
		
	@Autowired
	AdminCreateFeatureService adminCreateFeatureService;
	
	
	  @GetMapping("/createFeature/{userRole}") 
	  public ResponseEntity<?> createFeature(@PathVariable(value = "userRole") String userRole) {
		  if(userRole.equalsIgnoreCase("ADMIN")) {
		  Map<String,Featureflags> flagsCreated = adminCreateFeatureService.createFeature(); 
		  return ResponseEntity.ok(flagsCreated);
		  }else {
			  return ResponseEntity.ok(errorMessageCreate);  
		  }		  
	  }
	 
	
	@GetMapping("/switchFeature/{userRole}/{user}/{feature}")	
	public ResponseEntity<?> switchFeature(@PathVariable(value = "userRole") String userRole, @PathVariable(value = "user") String user,
			@PathVariable(value = "feature") String feature){
		String response = adminCreateFeatureService.switchFeature(userRole,user,feature);
		if(response.isEmpty()) {
			return ResponseEntity.ok(errorMessageSwitch);
		}
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/getEnabledFeatures/{user}")
	public ResponseEntity<?> getEnabledFeaturesforaUser(@PathVariable(value = "user") String userRole){
		List<String> enabledFeatures = adminCreateFeatureService.getEnabledFeaturesforaUser(userRole);
		if(!enabledFeatures.isEmpty()) {
		return ResponseEntity.ok(enabledFeatures);
		}
		return ResponseEntity.ok(errorMessageFeatures);		
		
	}

}
