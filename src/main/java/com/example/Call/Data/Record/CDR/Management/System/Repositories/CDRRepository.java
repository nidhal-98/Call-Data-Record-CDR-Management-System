package com.example.Call.Data.Record.CDR.Management.System.Repositories;

import com.example.Call.Data.Record.CDR.Management.System.Models.CDR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CDRRepository extends JpaRepository<CDR, Long> {
}
