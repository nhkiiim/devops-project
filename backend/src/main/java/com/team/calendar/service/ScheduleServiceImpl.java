package com.team.calendar.service;

import com.team.calendar.domain.Member;
import com.team.calendar.domain.Schedule;
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
    public List<Schedule> getScheduleListByProjectSeq(int projectSeq) {
        return scheduleRepository.findAllByProjectSeq(projectSeq);
    }

    @Override
    public List<Schedule> getScheduleListByMemberName(String memberName) {
        int memberSeq = memberRepository.findByMemberName(memberName).getSeq();
        return scheduleRepository.findAllByMemberSeq(memberName);
    }
}
