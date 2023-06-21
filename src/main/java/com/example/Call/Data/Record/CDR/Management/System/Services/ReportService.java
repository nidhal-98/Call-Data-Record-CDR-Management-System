package com.example.Call.Data.Record.CDR.Management.System.Services;

import com.example.Call.Data.Record.CDR.Management.System.Models.CDR;
import com.example.Call.Data.Record.CDR.Management.System.Models.Report;
import com.example.Call.Data.Record.CDR.Management.System.Repositories.CDRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    CDRRepository cdrRepository;

    public Report getCDRSummaryByUsername(String username) {
        List<CDR> cdrs = cdrRepository.findByUserUsername(username);
        int totalCalls = cdrs.size();
        int totalDuration = cdrs.stream().mapToInt(CDR::getDuration).sum();

        int averageDuration = 0;
        if (totalCalls > 0) {
            averageDuration = totalDuration / totalCalls;
        }

        return new Report(username, totalCalls, totalDuration, averageDuration);
    }
}