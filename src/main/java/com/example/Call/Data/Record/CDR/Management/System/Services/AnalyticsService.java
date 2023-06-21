package com.example.Call.Data.Record.CDR.Management.System.Services;

import com.example.Call.Data.Record.CDR.Management.System.Models.Analytics;
import com.example.Call.Data.Record.CDR.Management.System.Models.CDR;
import com.example.Call.Data.Record.CDR.Management.System.Repositories.CDRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalyticsService {

    @Autowired
    CDRService cdrService;

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