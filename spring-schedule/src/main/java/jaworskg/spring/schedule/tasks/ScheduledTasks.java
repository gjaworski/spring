package jaworskg.spring.schedule.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class ScheduledTasks {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final long WORK_TIME = 2000;

    @Scheduled(initialDelay = 10000, fixedRate = 5000)
    public void logInfoAtFixedTime() {
        LOGGER.info(String.format("FIXED RATE, start time: %s", LocalTime.now()));
        doTask();
        LOGGER.info(String.format("FIXED RATE, end time: %s", LocalTime.now()));

    }

    @Scheduled(initialDelay = 50000, fixedDelay = 5000)
    public void logInfoAtFixedDelay() {
        LOGGER.info(String.format("FIXED DELAY, time: %s", LocalTime.now()));
        doTask();
        LOGGER.info(String.format("FIXED DELAY, end: %s", LocalTime.now()));
    }

    @Scheduled(cron = "*/5 * * * * *")
    public void logInfoAtCron() {
        LOGGER.info(String.format("CRON, time: %s", LocalTime.now()));
        doTask();
        LOGGER.info(String.format("CRON, end: %s", LocalTime.now()));
    }

    private void doTask() {
        try {
            Thread.sleep(WORK_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
