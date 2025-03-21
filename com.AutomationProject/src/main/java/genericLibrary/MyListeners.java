package genericLibrary;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class MyListeners extends BaseTest implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log("--test-- "+result.getName()+" Started",true);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log("--test-- "+result.getName()+" Succeeded",true);
	}

	public void onTestFailure(ITestResult result) {
		String failedMethod = result.getName();
		String ldt = LocalDateTime.now().toString();
		String timestamp = ldt.replaceAll(":", "-");
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./errorshots/"+failedMethod+timestamp+".png");
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log("--test-- "+result.getName()+" Skiped",true);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log("--test-- "+result.getName()+" failed within success percentage",true);
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log("--test-- "+result.getName()+" Failed with timeouts",true);
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		Reporter.log("--test-- "+context.getName()+" is started",true);
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		Reporter.log("--test-- "+context.getName()+" Finished",true);
	}

	
  
}
