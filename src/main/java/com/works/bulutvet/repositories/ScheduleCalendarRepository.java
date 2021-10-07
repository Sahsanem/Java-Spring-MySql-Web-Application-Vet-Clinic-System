package com.works.bulutvet.repositories;

import com.works.bulutvet.entities.ScheduleCalendar;
import com.works.bulutvet.entities.ScheduleCalendars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ScheduleCalendarRepository extends JpaRepository<ScheduleCalendar,Integer> {

    List<ScheduleCalendar> findByCalendarIdEquals(String calendarId);

    @Query(value = "SELECT * from Schedule_Calendar where id = ?1", nativeQuery = true)
    Optional<ScheduleCalendar> findScheduleId(String id);

    @Query(value = "select COUNT( SCHEDULE_CALENDAR.CALENDAR_ID) as totalSchedule from SCHEDULE_CALENDAR", nativeQuery = true)
    List<ScheduleCalendars> schedules();
}
