package com.wavelabs.spelexpressions;

import org.springframework.beans.factory.annotation.Value;

public class SpelExpWithDefaultValue {
	@Value("${APP_NAME_NOT_FOUND}")
	private String defaultAppName;

	public String getDefaultAppName() {
		return defaultAppName;
	}

	public void setDefaultAppName(String defaultAppName) {
		this.defaultAppName = defaultAppName;
	}

	@Override
	public String toString() {
		return "SpelExpWithDefaultValue [defaultAppName=" + defaultAppName + "]";
	}
	
	
}
