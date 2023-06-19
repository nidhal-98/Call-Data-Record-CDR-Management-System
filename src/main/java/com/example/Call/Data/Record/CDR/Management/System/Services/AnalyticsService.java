package com.example.Call.Data.Record.CDR.Management.System.Services;

import com.example.Call.Data.Record.CDR.Management.System.Models.Analytics;
import com.example.Call.Data.Record.CDR.Management.System.Models.CDR;
import com.example.Call.Data.Record.CDR.Management.System.Repositories.CDRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalyticsService {

    @Autowired
    CDRRepository cdrRepository;

    public Analytics getCallDurationsAnalytics() {
        List<CDR> cdrss = cdrRepository.findAll(); // Retrieve all CDRs from the repository
        int totalCalls = cdrss.size(); // Calculate the total number of calls
        int totalDuration = cdrss.stream().mapToInt(CDR::getDuration).sum(); // Calculate the total duration

        int averageDuration = 0;
        if (totalCalls > 0) {
            averageDuration = totalDuration / totalCalls; // Calculate the average duration
        }

        return new Analytics(1L, averageDuration, totalCalls);
    }

}