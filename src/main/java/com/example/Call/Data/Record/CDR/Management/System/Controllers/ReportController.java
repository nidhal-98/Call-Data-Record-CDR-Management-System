package com.example.Call.Data.Record.CDR.Management.System.Controllers;

import com.example.Call.Data.Record.CDR.Management.System.Models.Report;
import com.example.Call.Data.Record.CDR.Management.System.Services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/reports")
public class ReportController {

    @Autowired
    ReportService reportService;

    @GetMapping("/user_summary")
    public ResponseEntity<Report> getUserSummary(
            @RequestParam("username") String username
    ) {
        Report cdrSummary = reportService.getCDRSummaryByUsername(username);
        return ResponseEntity.ok(cdrSummary);
    }
}
