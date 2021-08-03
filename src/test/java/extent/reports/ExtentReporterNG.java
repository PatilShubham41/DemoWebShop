package extent.reports;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.asserts.SoftAssert;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG implements IReporter {
	private ExtentReports extent;
	ExtentTest test;
	ExtentSparkReporter spark;

	SoftAssert sAssert;

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

		extent = new ExtentReports();
		spark = new ExtentSparkReporter(outputDirectory + "extent.html");
		extent.attachReporter(spark);

		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();

			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();

				buildTestNodes(context.getPassedTests(), Status.PASS, MyAssertion.assertionList);
				buildTestNodes(context.getFailedTests(), Status.FAIL, MyAssertion.assertionFailList);
				buildTestNodes(context.getSkippedTests(), Status.SKIP, null);

			}
		}
		
		System.out.println("Passed List: "+MyAssertion.assertionList);
		System.out.println("Failed List: "+MyAssertion.assertionFailList);
		
		extent.flush();

	}

	private void buildTestNodes(IResultMap tests, Status status, List<HashMap<String, Status>> assertions) {

		if (tests.size() > 0) {
			int counter = 0;
			for (ITestResult result : tests.getAllResults()) {
				test = extent.createTest(result.getMethod().getMethodName());
				result.getStatus();
				if (assertions != null && assertions.size() > 0)
					logAssertion(assertions.get(counter), test);

				counter++;
				
				for (String group : result.getMethod().getGroups())
					test.assignCategory(group);

				if (result.getThrowable() != null) {
					test.log(status, result.getThrowable());
				} else {
					test.log(status, "Test " + status.toString().toLowerCase() + "ed");
				}
			}

		}
	}

	private void logAssertion(HashMap<String, Status> assertionList, ExtentTest test) {
		if (assertionList.size() > 0) {

			ExtentTest testChild;
			System.out.println(assertionList);
			for (Map.Entry<String, Status> m : assertionList.entrySet()) {
				testChild = test.createNode((String) m.getKey());
				testChild.log((Status) m.getValue(), (String) m.getKey());
				System.out.println("list: "+(Status) m.getValue()+" "+ (String) m.getKey());

			}

		}

	}

}