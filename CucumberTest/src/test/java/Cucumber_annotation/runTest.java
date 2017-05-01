package Cucumber_annotation; 

import org.junit.runner.RunWith;
//import cucumber.junit.Feature;
import cucumber.junit.Cucumber; 

@RunWith(Cucumber.class) 
//@Feature("outline.feature")
@Cucumber.Options(format = {"pretty", "html:target/cucumber"}) 

public class runTest { }
