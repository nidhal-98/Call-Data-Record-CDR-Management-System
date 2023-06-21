package com.example.Call.Data.Record.CDR.Management.System.Requests;

import com.example.Call.Data.Record.CDR.Management.System.Models.CDR;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class cdrRequest {

    private Long cdrId;

    private String callerNumber;
    private String receiverNumber;
    private Integer duration;
    private LocalDateTime timestamp;


    public CDR ConvertToCDR(){
        CDR cdr = new CDR();

        cdr.setCdrId(this.getCdrId());
        cdr.setCallerNumber(this.getCallerNumber());
        cdr.setReceiverNumber(this.getReceiverNumber());
        cdr.setDuration(this.getDuration());
        cdr.setTimestamp(this.getTimestamp());
        return cdr;
    }
}
