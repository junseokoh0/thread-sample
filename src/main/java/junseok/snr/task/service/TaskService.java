package junseok.snr.task.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadPoolExecutor;

@Service
@AllArgsConstructor
public class TaskService {

    private final ThreadPoolTaskExecutor task;

    @Async
    public void task() throws InterruptedException {
        StringBuffer sb = new StringBuffer();
        Thread.sleep(1);
        sb.append(Thread.currentThread().getName()).append("\t")
                .append("CorePoolSize : ").append(task.getCorePoolSize()).append("\t")
                .append("PoolSize : ").append(task.getPoolSize()).append("\t")
                .append("ActiveCount : ").append(task.getActiveCount()).append("\t")
                .append("QueueSize : ").append(task.getThreadPoolExecutor().getQueue().size());
        System.out.println(sb.toString());
    }
}
