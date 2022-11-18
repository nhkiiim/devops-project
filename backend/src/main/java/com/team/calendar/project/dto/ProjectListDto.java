package com.team.calendar.project.dto;

import com.team.calendar.project.domain.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ProjectListDto {
    private List<Project> projectList;
}
