package com.Agiliux.Genericutility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementation implements ITestListener
{

	private ExtentReports rep;
	private ExtentTest test;
	public static ExtentTest stest;
	
	@Override
	public void onTestStart(ITestResult result)
	{
		test=rep.createTest(result.getMethod().getMethodName()+"testcaseStarted");
		stest = test;
		
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		test.pass(result.getMethod().getMethodName()+"pass");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriverUtility driver1= new WebDriverUtility();
		test.fail(result.getMethod().getMethodName()+"failed");
		test.fail(result.getThrowable());
		System.out.println(Thread.currentThread().getId());
		String path = driver1.takeScreenShot(BaseClass.sdriver);
		test.addScreenCaptureFromBase64String(path);	
		//trial method
	//	driver1.Screenshot(Base_class.java,Base_class.Sdriver,result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		test.skip("Test1 skip");
		test.fail(result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context)
	{
		ExtentSparkReporter sp = new ExtentSparkReporter("./extentReport/extentreport.html");
		sp.config().setDocumentTitle("Document Title- Life_insurance_management");
		sp.config().setReportName("Search module part");
		sp.config().setTheme(Theme.DARK);
		rep=new ExtentReports();
		rep.attachReporter(sp);
		rep.setSystemInfo("author","MAITHRI SHETTY");
		rep.setSystemInfo("OS","win 10");
		rep.setSystemInfo("browser","chrome");
	}

	@Override
	public void onFinish(ITestContext context) {
		rep.flush();
		
	}

	
	}

	
	

	
	
	
	

