package com.team.calendar.dto;

import com.team.calendar.domain.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ScheduleListResDto {
    List<Schedule> scheduleList;
}
