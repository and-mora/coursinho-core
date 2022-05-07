package it.amorabito.coursinho.model.dtos;

import it.amorabito.coursinho.model.entities.DayWeek;

public class WeeklySessionDto {
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
