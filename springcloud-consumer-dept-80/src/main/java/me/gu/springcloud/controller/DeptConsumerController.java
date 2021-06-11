package me.gu.springcloud.controller;

import me.gu.springcloud.entity.SysDept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://localhost:8001";

    @RequestMapping("/consumer/dept/add")
    public boolean add(SysDept sysDept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add/", sysDept, Boolean.class);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public SysDept get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, SysDept.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<SysDept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }


}
