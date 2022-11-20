package com.team.calendar.repository;

import com.team.calendar.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    List<Schedule> findAll();
    List<Schedule> findAllByProjectName(String projectName);
    List<Schedule> findAllByMemberName(String memberName);
}
