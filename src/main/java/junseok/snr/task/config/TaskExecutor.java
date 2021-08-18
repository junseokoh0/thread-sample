package junseok.snr.task.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class TaskExecutor {

    @Bean("task")
    public ThreadPoolTaskExecutor task() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(3);
        taskExecutor.setMaxPoolSize(16);
        taskExecutor.setQueueCapacity(20);
        taskExecutor.setRejectedExecutionHandler((r, executor) -> {
            System.out.println("REJECT???:");
        });
        taskExecutor.initialize();
        return taskExecutor;
    }
}
