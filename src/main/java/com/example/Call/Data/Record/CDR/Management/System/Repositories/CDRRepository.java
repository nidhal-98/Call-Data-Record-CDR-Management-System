package com.example.Call.Data.Record.CDR.Management.System.Repositories;

import com.example.Call.Data.Record.CDR.Management.System.Models.CDR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CDRRepository extends JpaRepository<CDR, Long> {
    List<CDR> findByCallerNumberAndTimestampBetween(String callerNumber, LocalDateTime timestampFrom, LocalDateTime timestampTo);

    List<CDR> findByUserUsername(String username);
}
