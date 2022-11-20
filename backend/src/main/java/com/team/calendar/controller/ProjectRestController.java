package com.team.calendar.controller;

import com.team.calendar.dto.ProjectListResDto;
import com.team.calendar.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
@RequiredArgsConstructor
public class ProjectRestController {
    private final ProjectService projectService;

    @GetMapping
    public ProjectListResDto getProjectList(){
        return new ProjectListResDto(
          projectService.getProjectList()
        );
    }
}
