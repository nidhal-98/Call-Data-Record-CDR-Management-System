package com.example.Call.Data.Record.CDR.Management.System.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Billing {

    private String username;
    private Integer month;
    private Integer year;
    private Integer totalCalls;
    private Integer totalDuration;
    private Double totalCharge;
}
