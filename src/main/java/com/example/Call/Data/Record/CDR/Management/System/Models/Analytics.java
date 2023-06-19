package com.example.Call.Data.Record.CDR.Management.System.Models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "analytics")
public class Analytics {
    private int averageDuration;
    private int totalCalls;
}
