package com.team.calendar.project.domain;

import com.team.calendar.common.domain.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Project extends BaseEntity {
    String projectName; //프로젝트 이름
}
