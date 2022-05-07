package it.amorabito.coursinho.model.dtos;

import it.amorabito.coursinho.model.entities.Classroom;
import it.amorabito.coursinho.model.entities.Lesson;
import it.amorabito.coursinho.model.entities.Module;
import it.amorabito.coursinho.model.entities.RealClassroom;
import it.amorabito.coursinho.model.entities.Teacher;

import java.time.LocalDateTime;

public class LessonDto {

    public LessonDto() {
    }

    public LessonDto(Lesson l) {
        this.id = l.getId();
        this.subject = l.getSubject();
        this.start = l.getStart();
        this.end = l.getEnd();
        this.teacherId = l.getTeacher().getId();
        this.teacherName = l.getTeacher().getFirstName() + "," + l.getTeacher().getLastName();
        this.classroomId = l.getClassroom().getId();
        this.classroomName = l.getClassroom().getName();
        this.moduleId = l.getModule().getId();
    }

    public Lesson toLesson() {
        Lesson lesson = new Lesson();

        lesson.setId(this.getId());
        lesson.setSubject(this.getSubject());
        lesson.setStart(this.getStart());
        lesson.setEnd(this.getEnd());

        Teacher teacher = new Teacher();
        teacher.setId(this.getTeacherId());
        teacher.setFirstName(this.getTeacherName());

        Classroom classroom = new RealClassroom();
        classroom.setId(this.getClassroomId());
        lesson.setClassroom(classroom);

        Module module = new Module();
        module.setId(this.getId());
        lesson.setModule(module);

        return lesson;
    }

    private long id;
    private String subject;
    private LocalDateTime start;
    private LocalDateTime end;
    private long teacherId;
    private String teacherName;
    private long classroomId;
    private String classroomName;
    private long moduleId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public long getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(long classroomId) {
        this.classroomId = classroomId;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public long getModuleId() {
        return moduleId;
    }

    public void setModuleId(long moduleId) {
        this.moduleId = moduleId;
    }
}
