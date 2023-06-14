package io.ubivis.backendwilliam.service;


import io.ubivis.backendwilliam.entity.RobotLog;

import java.sql.Timestamp;
import java.util.List;
public interface RobotLogService {

    List<RobotLog> buscarTodos();

   List<RobotLog> findByTimestampBetweenAndSoftwareInAndSeverityIn(Timestamp start, Timestamp end,  List<String> software, List<String> severity);

    RobotLog salvar (RobotLog robotLog);
    void delete (Long id);
}
