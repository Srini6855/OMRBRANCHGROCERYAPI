package com.omrbranch.reporting;

import com.omrbranch.base.BaseClass;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reporting extends BaseClass {

    public static void generateReports (String json) throws IOException, IOException {
        File file = new File ((getProjectPath () + getPropertyValue ("reportPath")));
        Configuration configuration = new Configuration (file, "Omr Grocery API Automation ");
        configuration.addClassifications ("Browser", "Chrome");
        configuration.addClassifications ("OS", "WIN 11");
        configuration.addClassifications ("Name", "Srinivasu A");
        configuration.addClassifications ("Batch", "API 2 Pm");
        configuration.addClassifications ("Trainer", "Velmurugan Sir");
        List <String> jsonFiles = new ArrayList <> ();
        jsonFiles.add (json);
        ReportBuilder builder = new ReportBuilder (jsonFiles, configuration);
        builder.generateReports ();
    }
}