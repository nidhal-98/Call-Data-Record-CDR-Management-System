package com.example.Call.Data.Record.CDR.Management.System.Controllers;

import com.example.Call.Data.Record.CDR.Management.System.Models.CDR;
import com.example.Call.Data.Record.CDR.Management.System.Repositories.CDRRepository;
import com.example.Call.Data.Record.CDR.Management.System.Responses.CdrResponse;
import com.example.Call.Data.Record.CDR.Management.System.Services.CDRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/cdr")
public class CDRController {

    @Autowired
    CDRService cdrService;

    @PostMapping("/upload")
    public String registerCDR(@RequestBody CDR cdr){
        cdrService.registerCDR(cdr);
        return "User Added Successfully";
    }

    @GetMapping("/get/{id}")
    public CDR getByID(@PathVariable("id") Long id){
        return cdrService.getCDRByID(id);
    }


    @GetMapping("/search")
    public ResponseEntity<List<CdrResponse>> searchCDRs(
            @RequestParam("caller_number") String callerNumber,
            @RequestParam("timestamp_from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime timestampFrom,
            @RequestParam("timestamp_to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime timestampTo) {
        List<CDR> cdrs = cdrService.searchCDRs(callerNumber, timestampFrom, timestampTo);
        List<CdrResponse> cdrResponses = convertToCdrResponses(cdrs);
        return ResponseEntity.ok(cdrResponses);
    }

    private List<CdrResponse> convertToCdrResponses(List<CDR> cdrs) {
        List<CdrResponse> cdrResponses = new ArrayList<>();
        for (CDR cdr : cdrs) {
            cdrResponses.add(new CdrResponse(
                    cdr.getCdrId(),
                    cdr.getCallerNumber(),
                    cdr.getReceiverNumber(),
                    cdr.getDuration(),
                    cdr.getTimestamp()
            ));
        }
        return cdrResponses;
    }

    @PutMapping("/update/{id}")
    public String updateCDR(@PathVariable Long id, @RequestBody CDR updatedCdr){

        CDR cdr = cdrService.getByID(id);

        cdr.setCallerNumber(updatedCdr.getCallerNumber());
        cdr.setReceiverNumber(updatedCdr.getReceiverNumber());
        cdr.setDuration(updatedCdr.getDuration());
        cdr.setTimestamp(updatedCdr.getTimestamp());

        cdrService.save(cdr);

        return "Updated Successfully";
    }
}