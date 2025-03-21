package testPackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_LaunchGoogle_001_Test {
  @Test
  public void launchGoogle()
  {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	  driver.get("https://www.google.com/");
  }
}

// To Execute this file on command Prompt

//mvn test -Dtest="package_name.class_name"   ----> 1st Command
//mvn test -Dtest="testPackage.TC_LaunchGoogle_001_Test"

//mvn -Dtest="package_name.class_name" test   ----> 2nd Command
//mvn -Dtest="testPackage.TC_LaunchGoogle_001_Test" test