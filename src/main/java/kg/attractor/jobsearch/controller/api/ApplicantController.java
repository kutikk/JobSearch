package kg.attractor.jobsearch.controller.api;

import kg.attractor.jobsearch.models.Resumes;
import kg.attractor.jobsearch.models.Users;
import kg.attractor.jobsearch.models.Vacancies;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/applicants")
public class ApplicantController {
    @PostMapping("/resumes")
    public ResponseEntity<String> createResume(@RequestBody Resumes resume) {
        // TODO вызов метода из класса сервиса
        return ResponseEntity.ok("Резюме создано!");
    }

    @PutMapping("/resumes/{id}")
    public ResponseEntity<String> editResume(@PathVariable Long id, @RequestBody Resumes resume) {
        // TODO вызов метода из класса сервиса

        return ResponseEntity.ok("Резюме обновлена!");
    }

    @DeleteMapping("/resumes/{id}")
    public ResponseEntity<String> deleteResume(@PathVariable Long id) {
        // TODO вызов метода из класса сервиса
        return ResponseEntity.ok("Резюме удалена!");
    }

    @GetMapping("/vacancies")
    public ResponseEntity<List<Vacancies>> getAllVacancies() {
        // TODO вызов метода для получения всех вакансий из класса сервиса
        return ResponseEntity.ok(Collections.emptyList());
    }

    @GetMapping("/vacancies/category/{category}")
    public ResponseEntity<List<Vacancies>> getVacanciesByCategory(@PathVariable String category) {
        // TODO вызов метода из класса сервиса для вывода вакансий по категориям
        return ResponseEntity.ok(Collections.emptyList());
    }

    @PostMapping("/vacancies/{id}/apply")
    public ResponseEntity<String> applyForVacancy(@PathVariable Long id) {
        // TODO вызов метода из класса сервиса для оставления отклика на вакансию
        return ResponseEntity.ok("Отклик успешно принят!");
    }

    @GetMapping("/employers/{id}")
    public ResponseEntity<Users> getEmployer(@PathVariable Long id) {
        // TODO  вывов метода для поиска работодателя
        return ResponseEntity.ok(new Users());
    }
}