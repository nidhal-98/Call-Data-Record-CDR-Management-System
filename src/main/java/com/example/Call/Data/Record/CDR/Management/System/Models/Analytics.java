package com.example.Call.Data.Record.CDR.Management.System.Models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "analytics")
public class Analytics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int averageDuration;
    private int totalCalls;
}
