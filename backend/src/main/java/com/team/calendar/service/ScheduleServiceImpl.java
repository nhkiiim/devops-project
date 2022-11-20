package com.team.calendar.service;

import com.team.calendar.domain.Schedule;
import com.team.calendar.dto.ScheduleListResDto;
import com.team.calendar.repository.MemberRepository;
import com.team.calendar.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService{
    private final ScheduleRepository scheduleRepository;
    private final MemberRepository memberRepository;

    @Override
    public List<Schedule> getScheduleList() {
        return scheduleRepository.findAll();
    }

    @Override
    public ScheduleListResDto getScheduleListByProjectName(String projectName) {
        ScheduleListResDto scheduleListResDto = new ScheduleListResDto();
        if(projectName==null || projectName.equals("전체")) scheduleListResDto.setScheduleList(scheduleRepository.findAll());
        else scheduleListResDto.setScheduleList(scheduleRepository.findAllByProjectName(projectName));
        return scheduleListResDto;
    }

    @Override
    public List<Schedule> getScheduleListByMemberName(String memberName) {
        return scheduleRepository.findAllByMemberName(memberName);
    }
}
