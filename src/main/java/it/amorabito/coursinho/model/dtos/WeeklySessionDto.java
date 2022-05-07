package it.amorabito.coursinho.model.dtos;

import it.amorabito.coursinho.model.entities.CourseEdition;
import it.amorabito.coursinho.model.entities.DayWeek;
import it.amorabito.coursinho.model.entities.WeeklySession;

import java.time.LocalTime;

public class WeeklySessionDto {

    public WeeklySessionDto() {
    }

    public WeeklySessionDto(WeeklySession session) {
        this.id = session.getId();
        this.day = session.getDay();
        this.start = session.getStart().toString();
        this.end = session.getEnd().toString();
        this.editionId = session.getEdition().getId();
    }

    public WeeklySession toWeeklySession() {
        WeeklySession session = new WeeklySession();
        session.setId(this.getId());
        session.setDay(this.getDay());
        // parse da string a localTime
        session.setStart(LocalTime.parse(this.getStart()));
        session.setEnd(LocalTime.parse(this.getEnd()));

        CourseEdition ce = new CourseEdition();
        ce.setId(this.getEditionId());
        session.setEdition(ce);

        return session;
    }

    private long id;
    private DayWeek day;
    private String start;
    private String end;
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

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public long getEditionId() {
        return editionId;
    }

    public void setEditionId(long editionId) {
        this.editionId = editionId;
    }
}
