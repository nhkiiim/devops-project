package com.team.calendar.domain;

import com.team.calendar.common.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectMember extends BaseEntity{
    int memberSeq;
    int projectSeq;
}