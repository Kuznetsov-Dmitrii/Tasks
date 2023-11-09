package com.example.MeetingSymbols.controllers;

import com.example.MeetingSymbols.Dto.StringTaskDto;
import com.example.MeetingSymbols.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/api/task")
    public String meetingSymbol(@RequestBody(required = false) StringTaskDto stringTaskDto){
        if (stringTaskDto==null || stringTaskDto.getString()==null || stringTaskDto.getString().replaceAll(" ","").length() == 0){
            return new Exception("String is null").getMessage();
        }

        return taskService.meetingSymbol(stringTaskDto.getString().replaceAll(" ",""));
    }
}
