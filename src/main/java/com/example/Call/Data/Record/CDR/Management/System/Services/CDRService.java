package com.example.Call.Data.Record.CDR.Management.System.Services;

import com.example.Call.Data.Record.CDR.Management.System.Models.CDR;
import com.example.Call.Data.Record.CDR.Management.System.Repositories.CDRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CDRService {

    @Autowired
    CDRRepository cdrRepository;

    public CDR registerCDR(CDR cdr){
        return cdrRepository.save(cdr);
    }

    public List<CDR> getAllCDRs() {
        return cdrRepository.findAll();
    }

    public CDR getCDRByID(Long id){
        return cdrRepository.findById(id).get();
    }

    public List<CDR> searchCDRs(String callerNumber, LocalDateTime timestampFrom, LocalDateTime timestampTo) {
        return cdrRepository.findByCallerNumberAndTimestampBetween(callerNumber, timestampFrom, timestampTo);
    }

    public CDR save(CDR cdr){
        return cdrRepository.save(cdr);
    }

    public int getTotalDuration(String username, int month, int year) {
        // Retrieve the CDRs for the specified user, month, and year
        List<CDR> cdrs = cdrRepository.findByUserUsernameAndTimestampBetween(username, month, year);

        // Calculate the total duration
        int totalDuration = cdrs.stream().mapToInt(CDR::getDuration).sum();

        // Return the total duration
        return totalDuration;
    }

}
