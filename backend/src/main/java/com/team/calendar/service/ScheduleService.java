package com.team.calendar.service;

import com.team.calendar.domain.Schedule;
import com.team.calendar.dto.ScheduleListResDto;

import java.util.List;

public interface ScheduleService {
    List<Schedule> getScheduleList();
    ScheduleListResDto getScheduleListByProjectName(String projectName);
    List<Schedule> getScheduleListByMemberName(String memberName);
}
