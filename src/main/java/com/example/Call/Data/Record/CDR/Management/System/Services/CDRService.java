package com.example.Call.Data.Record.CDR.Management.System.Services;

import com.example.Call.Data.Record.CDR.Management.System.Models.CDR;
import com.example.Call.Data.Record.CDR.Management.System.Repositories.CDRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CDRService {

    @Autowired
    CDRRepository cdrRepository;

    public void registerCDR(CDR cdr){
        cdrRepository.save(cdr);
    }

    public CDR getCDRByID(Long id){
        return cdrRepository.findById(id).get();
    }

}
