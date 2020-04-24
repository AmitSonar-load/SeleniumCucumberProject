package testRunner;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
(
	features= {".//Features/"},
	glue="stepsDefinations",
	dryRun=false,
	monochrome=true,
	plugin= {"pretty","html:test-output"},
	tags= {"@Sanity"}
)

public class TestRun
{
	

}
