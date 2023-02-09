package kg.edu.alatoo.trackerdb.controller;

import kg.edu.alatoo.trackerdb.entity.Task;
import kg.edu.alatoo.trackerdb.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    TaskRepository taskRepository;

    @GetMapping(value = "/")
    public String main(Model model) {
        model.addAttribute("tasks", taskRepository.findAll());
        return "main";
    }

    @PostMapping("/")
    public String taskSubmit(@RequestParam String description,
                             @RequestParam String issuer,
                             @RequestParam String executor,
                             @RequestParam int status, Model model) {
        Task task = new Task();
        task.setDescription(description);
        task.setExecutor(executor);
        task.setIssuer(issuer);
        task.setStatus(status);
        taskRepository.save(task);
        model.addAttribute("tasks", taskRepository.findAll());
        return "main";
    }
}
