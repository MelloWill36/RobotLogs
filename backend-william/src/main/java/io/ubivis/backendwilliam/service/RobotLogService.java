package io.ubivis.backendwilliam.service;


import io.ubivis.backendwilliam.entity.RobotLog;

import java.sql.Timestamp;
import java.util.List;
public interface RobotLogService {

    List<RobotLog> buscarTodos();

   List<RobotLog> findByTimestampAndSoftwareAndMessageAndSeverity(Timestamp timestamp, String software, String message, String severity);

    RobotLog salvar (RobotLog robotLog);
    void delete (Long id);
}
