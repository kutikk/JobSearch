package kg.attractor.jobsearch.controller;


import kg.attractor.jobsearch.models.Resumes;
import kg.attractor.jobsearch.models.Users;
import kg.attractor.jobsearch.models.Vacancies;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/employers")
public class EmployerController {
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