package it.amorabito.coursinho.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/classroom")
public interface ClassroomController {

//    private final ClassroomService classroomService;
//
//    @GetMapping("/")
//    public ResponseEntity<Collection<ClassroomDto>> getAllClassrooms() {
//        log.info("getAllClassrooms");
//        Collection<ClassroomDto> data = classroomService.getAllClassrooms();
//
//        return ResponseEntity.ok(data);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<ClassroomDto> getClassroomById(@PathVariable long id) {
//        log.info("getClassroomById");
//        ClassroomDto classroom = classroomService.getClassroomById(id);
//
//        return ResponseEntity.ok(classroom);
//    }
//
//    @GetMapping("/reals")
//    public ResponseEntity<Collection<ClassroomDto>> getRealClassrooms() {
//        log.info("getRealClassrooms");
//        Collection<ClassroomDto> results = classroomService.getRealClassrooms();
//
//        return ResponseEntity.ok(results);
//    }
//
//    @GetMapping("/virtuals")
//    public ResponseEntity<Collection<ClassroomDto>> getVirtualClassrooms() {
//        log.info("getVirtualClassrooms");
//        Collection<ClassroomDto> results = classroomService.getVirtualClassrooms();
//
//        return ResponseEntity.ok(results);
//    }
}
