package com.example.Call.Data.Record.CDR.Management.System.Responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class userResponse {

    String name;
    String email;
    Boolean isActive;
}
