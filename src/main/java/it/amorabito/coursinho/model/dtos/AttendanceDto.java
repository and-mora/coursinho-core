package it.amorabito.coursinho.model.dtos;

import it.amorabito.coursinho.model.entities.Attendance;
import it.amorabito.coursinho.model.entities.Lesson;
import it.amorabito.coursinho.model.entities.Student;

import java.time.LocalDateTime;

public class AttendanceDto {

    public AttendanceDto(Attendance attendance){
        this.id = attendance.getId();
        this.startTime = attendance.getStartTime();
        this.endTime = attendance.getEndTime();
        this.studentId = attendance.getStudent().getId();
        this.lessonId = attendance.getLesson().getId();
    }

    public Attendance toAttendance(){
        Attendance att = new Attendance();
        att.setId(this.getId());
        att.setStartTime(this.getStartTime());
        att.setEndTime(this.getEndTime());

        Student st = new Student();
        st.setId(this.getStudentId());
        att.setStudent(st);

        Lesson less = new Lesson();
        less.setId(this.getLessonId());
        att.setLesson(less);

        return att;
    }

    private long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private long studentId;
    private long lessonId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getLessonId() {
        return lessonId;
    }

    public void setLessonId(long lessonId) {
        this.lessonId = lessonId;
    }
}
