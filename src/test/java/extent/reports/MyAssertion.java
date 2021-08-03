package extent.reports;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

public class MyAssertion {

	public static ExtentReporterNG extReport = new ExtentReporterNG();
	public static ArrayList<HashMap<String, Status>> assertionList = new ArrayList<HashMap<String, Status>>();
	public static ArrayList<HashMap<String, Status>> assertionFailList = new ArrayList<HashMap<String, Status>>();
	public static int testManager = 1;
	
	/*
	 * add the reference to failList
	 * delete the list reference
	 * for the deleted reference
	 * 
	 * */
	
	public static void assertionSetup() {
		assertionList.add(new HashMap<String, Status>());
	}


	public static void assertEquals(int actual, int expected, String assertionFor){
		SoftAssert sAssert = new SoftAssert();
			
		try {
			sAssert.assertEquals(actual, expected);
			sAssert.assertAll();
			System.out.println("Assertion PASSED: " + assertionFor + " [Actual] " + actual + " [Expected] " + expected);
			if(testManager==assertionList.size())
				assertionList.get(assertionList.size()-1).put(assertionFor, Status.PASS);
			else
				assertionFailList.get(assertionFailList.size()-1).put(assertionFor, Status.PASS);
		} catch (Throwable t) {
			System.out.println("Assertion FAILED: " + assertionFor + " [Actual] " + actual + " [Expected] " + expected);
			assertionList.get(assertionList.size()-1).put(assertionFor, Status.FAIL);
			assertionFailList.add(assertionList.get(assertionList.size()-1));
			assertionList.remove(assertionList.size()-1);
			t.printStackTrace();
			throw new AssertionError(assertionFor+" failed");
			
		}
	}

	public static void assertEquals(float actual, float expected, String assertionFor) {
		SoftAssert sAssert = new SoftAssert();
		try {
			sAssert.assertEquals(actual, expected);
			sAssert.assertAll();
			System.out.println("Assertion PASSED: " + assertionFor + " [Actual] " + actual + " [Expected] " + expected);
			if(testManager==assertionList.size())
				assertionList.get(assertionList.size()-1).put(assertionFor, Status.PASS);
			else
				assertionFailList.get(assertionFailList.size()-1).put(assertionFor, Status.PASS);
		} catch (Throwable t) {
			System.out.println("Assertion FAILED: " + assertionFor + " [Actual] " + actual + " [Expected] " + expected);
			assertionList.get(assertionList.size()-1).put(assertionFor, Status.FAIL);
			assertionFailList.add(assertionList.get(assertionList.size()-1));
			assertionList.remove(assertionList.size()-1);
			t.printStackTrace();
			throw new AssertionError(assertionFor+" failed");
		
		}
	}

	public static void assertEquals(String actual, String expected, String assertionFor) {
		SoftAssert sAssert = new SoftAssert();
		try {
			sAssert.assertEquals(actual, expected);
			sAssert.assertAll();
			System.out.println("Assertion PASSED: " + assertionFor + " [Actual] " + actual + " [Expected] " + expected);
			if(testManager==assertionList.size())
				assertionList.get(assertionList.size()-1).put(assertionFor, Status.PASS);
			else
				assertionFailList.get(assertionFailList.size()-1).put(assertionFor, Status.PASS);
		} catch (Throwable t) {
			System.out.println("Assertion FAILED: " + assertionFor + " [Actual] " + actual + " [Expected] " + expected);	
			assertionList.get(assertionList.size()-1).put(assertionFor, Status.FAIL);
			assertionFailList.add(assertionList.get(assertionList.size()-1));
			assertionList.remove(assertionList.size()-1);
			t.printStackTrace();
			throw new AssertionError(assertionFor+" failed");
			
		}
	}

	public static void assertTrue(boolean actual, String assertionFor) {
		SoftAssert sAssert = new SoftAssert();
		try {
			sAssert.assertTrue(actual);
			sAssert.assertAll();
			System.out.println("Assertion PASSED: " + assertionFor + " [Actual] " + actual + " [Expected] true");
			if(testManager==assertionList.size())
				assertionList.get(assertionList.size()-1).put(assertionFor, Status.PASS);
			else
				assertionFailList.get(assertionFailList.size()-1).put(assertionFor, Status.PASS);
		} catch (Throwable t) {
			System.out.println("Assertion FAILED: " + assertionFor + " [Actual] " + actual + " [Expected] true");
			assertionList.get(assertionList.size()-1).put(assertionFor, Status.FAIL);
			assertionFailList.add(assertionList.get(assertionList.size()-1));
			assertionList.remove(assertionList.size()-1);
			t.printStackTrace();
			throw new AssertionError(assertionFor+" failed");
			
		}

	}

	public static void changeTest() {
		
		assertionList.add(new HashMap<String, Status>());
		testManager = assertionList.size();
		System.out.println("Changed the Assertion reference and fail list size: "+assertionFailList.size());
		System.out.println("Test Manager's value: "+testManager);
		
	}

}
