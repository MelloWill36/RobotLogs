package io.ubivis.backendwilliam.controller;


import io.ubivis.backendwilliam.entity.RobotLog;
import io.ubivis.backendwilliam.service.RobotLogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
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

    @GetMapping (value = "/filtro")
    public ResponseEntity <List<RobotLog>> findByTimestampAndSoftwareAndMessageAndSeverity
            (@RequestParam Timestamp timestamp,
             @RequestParam String software,
             @RequestParam String message,
             @RequestParam String severity){
        return ResponseEntity.ok(robotLogService.findByTimestampAndSoftwareAndMessageAndSeverity(timestamp,software, message, severity));
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
