package com.team.calendar.controller;

import com.team.calendar.dto.ScheduleListResDto;
import com.team.calendar.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/schedule")
@RequiredArgsConstructor
public class ScheduleRestController {
    private final ScheduleService scheduleService;

    @GetMapping
    public ScheduleListResDto getScheduleList(){
        return new ScheduleListResDto(
                scheduleService.getScheduleList()
        );
    }

    @GetMapping("{projectSeq}")
    public ScheduleListResDto getScheduleListByProject(@PathVariable int projectSeq){
        return new ScheduleListResDto(
                scheduleService.getScheduleListByProjectSeq(projectSeq)
        );
    }

    @GetMapping("{memberName}")
    public ScheduleListResDto getScheduleListByMember(@PathVariable String memberName){
        return new ScheduleListResDto(
                scheduleService.getScheduleListByMemberName(memberName)
        );
    }

}
