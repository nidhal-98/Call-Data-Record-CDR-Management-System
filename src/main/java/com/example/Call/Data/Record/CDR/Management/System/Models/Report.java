package com.example.Call.Data.Record.CDR.Management.System.Models;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Report {

    private String username;
    private Integer totalCalls;
    private Integer totalDuration;
    private Integer averageDuration;
}
