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
@Table(name = "cdr")
public class CDR {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdrId;

    private String callerNumber;
    private String receiverNumber;
    private Integer duration;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "username")
    User user;
}
