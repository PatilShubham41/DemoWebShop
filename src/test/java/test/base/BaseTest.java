package test.base;

import org.testng.annotations.BeforeSuite;

import extent.reports.MyAssertion;

public class BaseTest {

@BeforeSuite
public void beforeSuite() {
	MyAssertion.assertionSetup();
}
	



}
