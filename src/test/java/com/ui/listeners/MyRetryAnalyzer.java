package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.JSONUtility;

public class MyRetryAnalyzer implements IRetryAnalyzer{
	private static final int MAX_NO_OF_ATTEMPS=JSONUtility.readJSON(Env.QA).getMAX_NO_OF_ATTEMPS();
	int currentAttemp=1;
	public boolean retry(ITestResult result) {
		if(currentAttemp<=MAX_NO_OF_ATTEMPS) {
			currentAttemp++;
			return true;
		}
		return false;
	}

}
