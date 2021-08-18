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
        taskExecutor.setCorePoolSize(16);
        taskExecutor.setMaxPoolSize(34);
        taskExecutor.setQueueCapacity(80);
        taskExecutor.setRejectedExecutionHandler((r, executor) -> {
            System.out.println("REJECT???:");
//            executor.execute(r);
        });
        taskExecutor.initialize();
        return taskExecutor;
    }
}
