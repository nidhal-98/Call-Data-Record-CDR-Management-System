package com.example.Call.Data.Record.CDR.Management.System.Models;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity {

    private Date createdDate;
    private Boolean isActive;
    private Date updatedDate;
}
