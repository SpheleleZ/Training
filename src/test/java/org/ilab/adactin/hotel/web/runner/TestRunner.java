package org.ilab.adactin.hotel.web.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/features"
        ,glue = {"org/ilab/adactin/hotel/web/steps"}
        ,monochrome = true
        ,dryRun = false
        ,tags = "@login"
        ,plugin = {
                "pretty"
        ,"junit:src/reports/JUnitReports/JUnitReport.xml"
        ,"json:src/reports/JsonReports/JasonReport.json"
        ,"html:src/reports/HTMLReports/HTMLReport.html"
})
public class TestRunner {
    //empty class
}
