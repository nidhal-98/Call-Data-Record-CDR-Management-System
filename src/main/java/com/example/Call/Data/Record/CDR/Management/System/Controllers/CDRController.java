package com.example.Call.Data.Record.CDR.Management.System.Controllers;

import com.example.Call.Data.Record.CDR.Management.System.Models.CDR;
import com.example.Call.Data.Record.CDR.Management.System.Repositories.CDRRepository;
import com.example.Call.Data.Record.CDR.Management.System.Services.CDRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/api/cdr")
public class CDRController {

    @Autowired
    CDRService cdrService;

    @PostMapping("/upload")
    public String registerCDR(@RequestBody CDR cdr){
        cdrService.registerCDR(cdr);
        return "User Added Successfully";
    }

    @GetMapping("{id}")
    public CDR getByID(@PathVariable("id") Long id){
        return cdrService.getCDRByID(id);
    }

}
