package com.junit.testSuite;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
@RunWith(JUnitPlatform.class)
@SelectPackages({"com.junit.assertions",
	"com.junit.assumptions",
	"com.junit.nestedTestCase",
	"com.junit.parallelExecution",
	"com.junit.displayName",
	"com.junit.testAssertions",
	"com.junit.testAssumptions",
	"com.junit.testDisabledTestCase",
	"com.junit.testDisplayName",
	"com.junit.testNestedTestCase",
	"com.junit.testParallelExecutionTestCases",
	"com.junit.testParameterizedTestCase",
	"com.junit.testRepeatedTestCase",
	"com.junit.testAssertions",
	"com.junit.testParallelExecution"})

public class TestSuite {

}
