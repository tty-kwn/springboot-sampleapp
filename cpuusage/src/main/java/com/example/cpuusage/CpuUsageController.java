package com.example.cpuusage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cpu")
public class CpuUsageController {

    private final CpuUsageTask cpuUsageTask;

    public CpuUsageController(CpuUsageTask cpuUsageTask) {
        this.cpuUsageTask = cpuUsageTask;
    }

    @GetMapping("/load")
    public String createLoad() {
        cpuUsageTask.createCpuLoad();
        return "CPU Load Task Executed";
    }
}

