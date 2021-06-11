package me.gu.springcloud.controller;

import me.gu.springcloud.entity.SysDept;
import me.gu.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    final DeptService deptService;

    @Autowired
    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }

    @Autowired
    private DiscoveryClient client;

    @PostMapping("/dept/add")
    public boolean addDept(@RequestBody SysDept sysDept) {
        return deptService.addDept(sysDept);
    }

    @GetMapping("/dept/get/{id}")
    public SysDept get(@PathVariable("id") Long id) {
        return deptService.queryById(id);
    }

    @GetMapping("/dept/list")
    public List<SysDept> queryAll() {
        return deptService.queryAll();
    }

    // 注册进来的微服务，获取一些信息
    @GetMapping("/dept/discovery")
    public Object discovery() {
        List services = client.getServices();
        System.out.println("discovery services: " + services );
        List<ServiceInstance> instances= client.getInstances("springcloud-provider-dept");
        for(ServiceInstance instance : instances) {
            System.out.println("info: " + instance.getHost() + "\t" +
                    instance.getPort() + "\t" +
                    instance.getUri() + "\t" +
                    instance.getServiceId());
        }
        return this.client;
    }
}
