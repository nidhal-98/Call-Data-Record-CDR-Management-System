package com.example.Call.Data.Record.CDR.Management.System.Responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CdrResponse {

    private Long cdrId;
    private String callerNumber;
    private String receiverNumber;
    private Integer duration;
    private LocalDateTime timestamp;
}
