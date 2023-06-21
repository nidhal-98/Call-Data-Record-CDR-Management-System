package com.example.Call.Data.Record.CDR.Management.System.Models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdrId;

    private String username;
    private Integer totalCalls;
    private Integer totalDuration;
    private Integer averageDuration;
}
