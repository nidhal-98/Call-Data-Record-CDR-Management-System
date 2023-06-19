package com.example.Call.Data.Record.CDR.Management.System.Models;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cdrs")
public class CDR {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdrId;

    private String callerNumber;
    private String receiverNumber;
    private Integer duration;
    private LocalDateTime timestamp;
}
