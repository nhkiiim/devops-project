package com.team.calendar.service;

import com.team.calendar.domain.Project;
import com.team.calendar.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService{

    private final ProjectRepository projectRepository;

    @Override
    public List<Project> getProjectList() {
        return projectRepository.findAll();
    }
}
