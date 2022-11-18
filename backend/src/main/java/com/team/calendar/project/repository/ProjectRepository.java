package com.team.calendar.project.repository;

import com.team.calendar.project.domain.Project;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository {
    List<Project> findProject();
}
