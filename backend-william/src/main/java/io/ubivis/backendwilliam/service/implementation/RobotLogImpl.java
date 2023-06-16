package io.ubivis.backendwilliam.service.implementation;

import io.ubivis.backendwilliam.entity.RobotLog;
import io.ubivis.backendwilliam.repository.RobotLogRepository;
import io.ubivis.backendwilliam.service.RobotLogService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class RobotLogImpl implements RobotLogService {

    private final RobotLogRepository robotLogRepository;

    public RobotLogImpl(RobotLogRepository robotLogRepository) {

        this.robotLogRepository = robotLogRepository;
    }

    @Override
    public List<RobotLog> buscarTodos() {
        return robotLogRepository.findAll();
    }

    @Override
    public List<RobotLog> findByTimestampBetweenAndSoftwareInAndSeverityIn(Timestamp start, Timestamp end, List<String> software, List<String> severity) {
        return robotLogRepository.findByTimestampBetweenAndSoftwareInAndSeverityIn(start, end, software, severity);
    }

   @Override
    public List<RobotLog> findByTimestampBetweenAndSoftwareIn(Timestamp start, Timestamp end, List<String> software) {
        return robotLogRepository.findByTimestampBetweenAndSoftwareIn(start, end, software);
    }

    @Override
    public List<RobotLog> findByTimestampBetweenAndSeverityIn(Timestamp start, Timestamp end, List<String> severity) {
        return robotLogRepository.findByTimestampBetweenAndSeverityIn(start, end, severity);
    }
    @Override
    public List<RobotLog> findBySoftwareInAndSeverityIn(List<String> software, List<String> severity) {
        return robotLogRepository.findBySoftwareInAndSeverityIn(software, severity);
    }
    @Override
    public List<RobotLog> findByTimestampBetween(Timestamp start, Timestamp end) {
        return robotLogRepository.findByTimestampBetween(start, end);
    }
    @Override
    public RobotLog salvar(RobotLog robotLog) {
        return robotLogRepository.save(robotLog);
    }
    @Override
    public void delete(Long id) {
        try {
            robotLogRepository.deleteById(id);
        }   catch ( Exception e) {
            throw new RuntimeException("Ocorreu um erro ao excluir o Log");
        }
    }
}
