package com.team.calendar.project.controller;

import com.team.calendar.project.dto.ProjectListDto;
import com.team.calendar.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/project")
public class ProjectRestController {
    private final ProjectService projectService;

    @Autowired
    public ProjectRestController(ProjectService projectService){
        this.projectService = projectService;
    }

    @GetMapping
    public ProjectListDto getProjectList(){
        return new ProjectListDto(
          projectService.getProjectList()
        );
    }
}
