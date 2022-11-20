package com.team.calendar.service;

import com.team.calendar.domain.Schedule;

import java.util.List;

public interface ScheduleService {
    List<Schedule> getScheduleList();
    List<Schedule> getScheduleListByProjectSeq(int projectSeq);
    List<Schedule> getScheduleListByMemberName(String memberName);
}
