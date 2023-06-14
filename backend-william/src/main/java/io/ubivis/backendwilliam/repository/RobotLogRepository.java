package io.ubivis.backendwilliam.repository;

import io.ubivis.backendwilliam.entity.RobotLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface RobotLogRepository extends JpaRepository<RobotLog, Long> {

    List<RobotLog> findByTimestampBetweenAndSoftwareInAndSeverityIn(Timestamp startTimestamp, Timestamp endTimestamp, List<String> software, List<String> severity);


}


