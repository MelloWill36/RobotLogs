package io.ubivis.backendwilliam.service;


import io.ubivis.backendwilliam.entity.RobotLog;

import java.sql.Timestamp;
import java.util.List;
public interface RobotLogService {

    List<RobotLog> buscarTodos();

    List<RobotLog> findByTimestampBetweenAndSoftwareInAndSeverityIn(Timestamp start, Timestamp end, List<String> software, List<String> severity);
    List<RobotLog> findByTimestampBetweenAndSoftwareIn(Timestamp start, Timestamp end, List<String> software);
    List<RobotLog> findByTimestampBetweenAndSeverityIn(Timestamp start, Timestamp end, List<String> severity);
    List<RobotLog> findByTimestampBetween(Timestamp start, Timestamp end);
    
    RobotLog salvar (RobotLog robotLog);
    void delete (Long id);
}
