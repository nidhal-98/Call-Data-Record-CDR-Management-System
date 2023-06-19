package com.example.Call.Data.Record.CDR.Management.System.Models;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "/cdrs")
public class CDR {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long callerNumber;
    private String receiverNumber;
    private Integer duration;
    private LocalDateTime timestamp;
}
