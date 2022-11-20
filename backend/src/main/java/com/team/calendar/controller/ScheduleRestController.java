package com.team.calendar.controller;

import com.team.calendar.dto.ScheduleListReqDto;
import com.team.calendar.dto.ScheduleListResDto;
import com.team.calendar.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("project")
    public ScheduleListResDto getScheduleListByProject(@RequestBody ScheduleListReqDto scheduleListReqDto){
        return new ScheduleListResDto(
                scheduleService.getScheduleListByProjectSeq(scheduleListReqDto.getProjectSeq())
        );
    }

    @PostMapping("member")
    public ScheduleListResDto getScheduleListByMember(@RequestBody ScheduleListReqDto scheduleListReqDto){
        return new ScheduleListResDto(
                scheduleService.getScheduleListByMemberName(scheduleListReqDto.getMemberName())
        );
    }

}
