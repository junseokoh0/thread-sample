package junseok.snr.task.controller;

import junseok.snr.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/task")
    public void task() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            taskService.task();
            Thread.sleep(50);
        }
    }
}
