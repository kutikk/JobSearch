package kg.attractor.jobsearch.controller;


import kg.attractor.jobsearch.dto.EmployerDto;
import kg.attractor.jobsearch.models.Resumes;
import kg.attractor.jobsearch.models.Users;
import kg.attractor.jobsearch.models.Vacancies;
import kg.attractor.jobsearch.service.EmployerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/employers")
@RequiredArgsConstructor
public class EmployerController {




    private final EmployerService employerService;

    @GetMapping
    public List<EmployerDto> getEmployers() {
        return employerService.getEmployers();
    }
    @GetMapping("/name/{user_name}")
    public EmployerDto getEmployerByName(@PathVariable String user_name) {
        return employerService.getEmployerByName(user_name);
    }

    @GetMapping("/phone/{phoneNumber}")
    public EmployerDto getEmployerByPhone(@PathVariable String phoneNumber) {
        return employerService.getEmployerByPhoneNumber(phoneNumber);
    }

    @GetMapping("/email/{email}")
    public EmployerDto getEmployerByEmail(@PathVariable String email) {
        return employerService.getEmployerByEmail(email);
    }




    @PostMapping("/vacancies")
    public ResponseEntity<String> createVacancy(@RequestBody Vacancies vacancies) {
        return ResponseEntity.ok("Вакансия создана!");
    }

    @PutMapping("/vacancies/{id}")
    public ResponseEntity<String> editVacancy(@PathVariable Long id, @RequestBody Vacancies vacancies) {
        return ResponseEntity.ok("Вакансия обновлена!");
    }

    @DeleteMapping("/vacancies/{id}")
    public ResponseEntity<String> deleteVacancy(@PathVariable Long id) {
        return ResponseEntity.ok("Вакансия удалена!");
    }

    @GetMapping("/resumes")
    public ResponseEntity<List<Resumes>> getAllResumes() {
        return ResponseEntity.ok(Collections.emptyList());
    }

    @GetMapping("/resumes/category/{category}")
    public ResponseEntity<List<Resumes>> getResumesByCategory(@PathVariable String category) {
        return ResponseEntity.ok(Collections.emptyList());
    }

    @GetMapping("/vacancies/{id}/applicants")
    public ResponseEntity<List<Users>> getApplicants(@PathVariable Long id) {
        return ResponseEntity.ok(Collections.emptyList());
    }

    @GetMapping("/applicants/{id}")
    public ResponseEntity<Users> getApplicant(@PathVariable Long id) {
        return ResponseEntity.ok(new Users());
    }
}