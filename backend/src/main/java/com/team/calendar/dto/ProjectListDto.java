package com.team.calendar.dto;

import com.team.calendar.domain.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ProjectListDto {
    private List<Project> projectList;
}
