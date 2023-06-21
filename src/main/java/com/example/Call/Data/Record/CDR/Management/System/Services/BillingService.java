package com.example.Call.Data.Record.CDR.Management.System.Services;

import com.example.Call.Data.Record.CDR.Management.System.Models.Billing;
import com.example.Call.Data.Record.CDR.Management.System.Models.CDR;
import com.example.Call.Data.Record.CDR.Management.System.Repositories.CDRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class BillingService {

    @Autowired
    CDRRepository cdrRepository;

    public Billing generateUserStatement(String username, int month, int year) {
        List<CDR> cdrs = cdrRepository.findByUserUsername(username);
        int totalCalls = 0;
        int totalDuration = 0;

        for (CDR cdr : cdrs) {
            LocalDateTime timestamp = cdr.getTimestamp();
            if (timestamp.getMonthValue() == month && timestamp.getYear() == year) {
                totalCalls++;
                totalDuration += cdr.getDuration();
            }
        }

        double totalCharge = calculateTotalCharge(totalDuration);

        return new Billing(username, month, year, totalCalls, totalDuration, totalCharge);
    }

    private double calculateTotalCharge(int totalDuration) {
        return totalDuration * 0.33;
    }
}
