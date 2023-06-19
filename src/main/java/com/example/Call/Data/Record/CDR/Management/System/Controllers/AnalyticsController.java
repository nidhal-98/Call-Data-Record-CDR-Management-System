package com.example.Call.Data.Record.CDR.Management.System.Controllers;

import com.example.Call.Data.Record.CDR.Management.System.Models.Analytics;
import com.example.Call.Data.Record.CDR.Management.System.Models.CDR;
import com.example.Call.Data.Record.CDR.Management.System.Services.AnalyticsService;
import com.example.Call.Data.Record.CDR.Management.System.Services.CDRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/analytics")
public class AnalyticsController {

    @Autowired
    CDRService cdrService;
    @GetMapping("/call_durations")
    public ResponseEntity<Analytics> getCallDurationsAnalytics() {
        List<CDR> cdrss = cdrService.getAllCDRs(); // Retrieve all CDRs from the service
        int totalCalls = cdrss.size(); // Calculate the total number of calls
        int totalDuration = cdrss.stream().mapToInt(CDR::getDuration).sum(); // Calculate the total duration

        int averageDuration = 0;
        if (totalCalls > 0) {
            averageDuration = totalDuration / totalCalls; // Calculate the average duration
        }

        Analytics response = new Analytics(1L, averageDuration, totalCalls);
        return ResponseEntity.ok(response);
    }
}
