package it.amorabito.coursinho.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/course-edition")
public interface CourseEditionController {

//    private final CourseEditionService courseEditionService;
//
//    /**
//     * Get all Course Edition
//     */
//    @GetMapping("/")
//    public ResponseEntity<Collection<CourseEditionDto>> getAllCoursesEditions() {
//        log.info("getAllCoursesEditions");
//        var courseEditions = courseEditionService.getAllCoursesEditions();
//
//        return ResponseEntity.ok(courseEditions);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<CourseEditionDto> getCourseEditionById(@PathVariable(value = "id") long courseEditionId) {
//        log.info("getCourseEditionById");
//        var courseEdition = courseEditionService.getCourseEditionById(courseEditionId);
//
//        return ResponseEntity.ok(courseEdition);
//    }
//
//    @GetMapping("/{id}/modules")
//    public ResponseEntity<Collection<ModuleDto>> getModulesByCourseEditionId(@PathVariable long courseEditionId) {
//        log.info("getModulesByCourseEditionId");
//        var modules = courseEditionService.getModuleByCourseEditionId(courseEditionId);
//
//        return ResponseEntity.ok(modules);
//    }
//
//    /**
//     * Get a list of Course Edition
//     *
//     * @param courseId key of the course
//     * @return List Dto Course Edition
//     */
//    @GetMapping("/byCourseId/{id}")
//    public ResponseEntity<Collection<CourseEditionDto>> getByCourse(@PathVariable long courseId) throws EntityNotFoundException {
//        log.info("getByCourse");
//        var editions = courseEditionService.getByCourse(courseId);
//
//        return ResponseEntity.ok(editions);
//    }
//
//    /**
//     * Create a new Course Edition
//     */
//    @PostMapping("/")
//    public ResponseEntity<CourseEditionDto> createCourseEdition(@RequestBody CourseEditionDto courseEditionDto) throws EntityNotFoundException {
//        log.info("createCourseEdition");
//        var saved = courseEditionService.createCourseEdition(courseEditionDto);
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
//    }
//
//    @PostMapping("/module")
//    public ResponseEntity<ModuleDto> createModule(@RequestBody ModuleDto moduleDto) throws EntityNotFoundException {
//        log.info("createModule");
//        var moduleSaved = courseEditionService.createModule(moduleDto);
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(moduleSaved);
//    }
//
//    @PostMapping("/weekly-session")
//    public ResponseEntity<WeeklySessionDto> createWeeklySession(@RequestBody WeeklySessionDto weeklySessionDto) throws EntityNotFoundException {
//        log.info("createWeeklySession");
//        var weeklySessionSaved = courseEditionService.createWeeklySession(weeklySessionDto);
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(weeklySessionSaved);
//    }
//
//
//    /**
//     * Delete a Course Edition
//     *
//     * @param id key of the course edition
//     * @return HttpStatus
//     */
//    @DeleteMapping("/{id}")
//    public ResponseEntity<CourseEditionDto> deleteCourseById(@PathVariable long id) {
//        log.info("deleteCourseById");
//        courseEditionService.deleteCourseEdition(id);
//
//        return ResponseEntity.ok().build();
//    }
//
//    /**
//     * Update the course edition
//     */
//    @PutMapping("/")
//    public ResponseEntity<CourseEditionDto> updateCourseEdition(@RequestBody CourseEditionDto courseEditionDto) throws EntityNotFoundException {
//        log.info("updateCourseEdition");
//        var saved = courseEditionService.createCourseEdition(courseEditionDto);
//
//        return ResponseEntity.ok(saved);
//    }
}
