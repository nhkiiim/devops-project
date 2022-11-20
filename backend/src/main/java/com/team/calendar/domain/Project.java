package com.team.calendar.domain;

import com.team.calendar.common.BaseEntity;
import lombok.*;

import javax.persistence.Entity;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Project extends BaseEntity {
    String projectName; //프로젝트 이름
}
