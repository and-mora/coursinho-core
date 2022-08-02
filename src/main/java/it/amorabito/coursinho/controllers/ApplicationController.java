package it.amorabito.coursinho.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/application")
public interface ApplicationController {

//    private final ApplicationService applicationService;
//
//    @GetMapping("/{select}/{id}")
//    public ResponseEntity<Collection<ApplicationDto>> getBySelect(@PathVariable String select, @PathVariable long id) {
//        Collection<ApplicationDto> applications;
//
//        try {
//            switch (select) {
//                case "student":
//                    applications = applicationService.getByStudent(id);
//                    break;
//                case "edition":
//                    applications = applicationService.getByEdition(id);
//                    break;
//                default:
//                    return ResponseEntity.badRequest().build();
//
//            }
//        } catch (EntityNotFoundException e) {
//            return ResponseEntity.notFound().build();
//        }
//
//        return ResponseEntity.ok(applications);
//    }
//
//    @PostMapping("/")
//    public ResponseEntity<ApplicationDto> saveApplication(@RequestBody ApplicationDto applicationDto) {
//        ApplicationDto applicationSaved;
//
//        try {
//            applicationSaved = applicationService.save(applicationDto);
//        } catch (EntityNotFoundException e) {
//            return ResponseEntity.notFound().build();
//        }
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(applicationSaved);
//    }

}
