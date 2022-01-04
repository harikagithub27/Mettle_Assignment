package com.demo.enums;

import org.togglz.core.Feature;
import org.togglz.core.annotation.EnabledByDefault;
import org.togglz.core.annotation.Label;
import org.togglz.core.context.FeatureContext;

public enum AdminFeatures implements Feature{
	
	 @Label("Feature One - Default Disabled Feature")
	 FEATURE_ONE,
	 
	 @Label("Feature Two")
	 @EnabledByDefault
	 FEATURE_TWO,
	 
	 @Label("Feature Three")
	 @EnabledByDefault
	 FEATURE_THREE;
	 
	 
	    	    
	    public boolean isActive() {
	        return FeatureContext.getFeatureManager().isActive(this);
	    }
	    

}
