package com.example.Call.Data.Record.CDR.Management.System.Controllers;

import com.example.Call.Data.Record.CDR.Management.System.Models.Billing;
import com.example.Call.Data.Record.CDR.Management.System.Services.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/billing")
public class BillingController {

    @Autowired
    BillingService billingService;


    @GetMapping("/user_statement")
    public ResponseEntity<Billing> getUserStatement(
            @RequestParam("username") String username,
            @RequestParam("month") int month,
            @RequestParam("year") int year) {

        Billing billingStatement = billingService.generateUserStatement(username, month, year);
        return ResponseEntity.ok(billingStatement);
    }
}
