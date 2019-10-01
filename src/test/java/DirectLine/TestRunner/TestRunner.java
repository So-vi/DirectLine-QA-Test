package DirectLine.TestRunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features="/Users/sonalikarde/eclipse-workspace/DirectLine/src/main/java/DirectLine/qa/Features/DirectLineTest.feature",// path of feature file
glue= {"DirectLine.StepDefinitions"}, // path of step definition files
//cucumber extend report
plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"})

public class TestRunner {
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("/Users/sonalikarde/eclipse-workspace/DirectLine/src/main/java/DirectLine/qa/Config/extent-config.xml"));
	}
}
