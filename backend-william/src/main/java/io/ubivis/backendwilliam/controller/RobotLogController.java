package io.ubivis.backendwilliam.controller;


import io.ubivis.backendwilliam.entity.RobotLog;
import io.ubivis.backendwilliam.service.RobotLogService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping ("/api/robotLog")
public class RobotLogController {

    private final RobotLogService robotLogService;

    public RobotLogController(RobotLogService robotLogService) {
        this.robotLogService = robotLogService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RobotLog> buscarTodos(){
        return robotLogService.buscarTodos();
    }

    @GetMapping(value = "/filtro")
    public ResponseEntity<List<RobotLog>> findByFilter(
        @RequestParam( "start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
        @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end,
        @RequestParam (required = false) List<String> software,
        @RequestParam (required = false) List<String> severity)  {

        Timestamp startTimestamp = Timestamp.valueOf(start);
        Timestamp endTimestamp = Timestamp.valueOf(end);

        List<RobotLog> result = robotLogService.findByTimestampBetweenAndSoftwareInAndSeverityIn(startTimestamp, endTimestamp, software, severity);

        return ResponseEntity.ok(result);
    }
    @PostMapping
    public ResponseEntity <RobotLog> salvar (@RequestBody  RobotLog robotLog) {
       var newLog = robotLogService.salvar(robotLog);
        return new ResponseEntity(robotLog, HttpStatus.CREATED);
    }

    @DeleteMapping ("{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        robotLogService.delete(id);
        return ResponseEntity.ok().build();
    }
}
