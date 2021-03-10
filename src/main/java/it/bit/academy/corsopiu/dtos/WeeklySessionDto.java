package it.bit.academy.corsopiu.dtos;

import it.bit.academy.corsopiu.entities.CourseEdition;
import it.bit.academy.corsopiu.entities.DayWeek;
import it.bit.academy.corsopiu.entities.WeeklySession;

import java.time.LocalTime;

public class WeeklySessionDto {

    public WeeklySessionDto(WeeklySession session){
        this.id = session.getId();
        this.day = session.getDay();
        this.start = session.getStart();
        this.end = session.getEnd();
        this.editionId = session.getEdition().getId();
    }

    public WeeklySession toWeeklySession(){
        WeeklySession session = new WeeklySession();
        session.setId(this.getId());
        session.setDay(this.getDay());
        session.setStart(this.getStart());
        session.setEnd(this.getEnd());

        CourseEdition ce = new CourseEdition();
        ce.setId(this.getEditionId());
        session.setEdition(ce);

        return  session;
    }

    private long id;
    private DayWeek day;
    private LocalTime start;
    private LocalTime end;
    private long editionId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DayWeek getDay() {
        return day;
    }

    public void setDay(DayWeek day) {
        this.day = day;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    public long getEditionId() {
        return editionId;
    }

    public void setEditionId(long editionId) {
        this.editionId = editionId;
    }
}
