package it.amorabito.coursinho.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/person")
public interface PersonController {

//    private final PersonService personService;
//
//    /**
//     * Gets all persons
//     *
//     * @return
//     */
//    @GetMapping("/")
//    public ResponseEntity<Collection<PersonDto>> getAllPerson() {
//        log.info("getAllPerson");
//        var persons = personService.getPersons();
//
//        return ResponseEntity.ok(persons);
//    }
//
//    @GetMapping("/type/{value}")
//    public ResponseEntity<Collection<PersonDto>> getPersonsByType(@PathVariable String value) {
//        log.info("getPersonsByType");
//
//        switch (value) {
//            case "teachers":
//                return ResponseEntity.ok(personService.getTeachers());
//            case "students":
//                return ResponseEntity.ok(personService.getStudents());
//            case "employees":
//                return ResponseEntity.ok(personService.getEmployees());
//            default:
//                break;
//        }
//
//        return ResponseEntity.badRequest().build();
//    }
//
//    /**
//     * Get all students containing string param in firstName, lastName or fiscalCode.
//     *
//     * @param contains
//     * @return
//     */
//    @GetMapping("/students/search")
//    public ResponseEntity<Collection<PersonDto>> getStudentsContaining(@RequestParam String contains) {
//        log.info("getStudentsContaining");
//
//        if (contains == null) {
//            return ResponseEntity.badRequest().build();
//        }
//
//        var students = personService.getStudentsContaining(contains, contains, contains);
//
//        return ResponseEntity.ok(students);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<PersonDto> findPersonById(@PathVariable long id) {
//        log.info("findPersonById");
//        PersonDto person = personService.getPersonById(id);
//
//        return ResponseEntity.ok(person);
//    }
//
////    /**
////     * Create a new person
////     *
////     * @return
////     */
////    @PostMapping("/")
////    public ResponseEntity<PersonDto> createPerson(@RequestBody PersonDto personDto) {
////        log.info("createPerson");
////        var saved = personService.savePerson(personDto);
////
////        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
////    }
//
//    /**
//     * Delete person
//     *
//     * @param id
//     * @return
//     */
//    @DeleteMapping("/{id}")
//    public ResponseEntity<PersonDto> deletePerson(@PathVariable long id) {
//        personService.getPersonById(id);
//        personService.deletePerson(id);
//        return ResponseEntity.ok().build();
//    }

}
