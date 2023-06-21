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
    AnalyticsService analyticsService;


    @GetMapping("/call_durations")
    public ResponseEntity<Analytics> getCallDurationsAnalytics() {
        return analyticsService.getCallDurationsAnalytics();
    }
}
