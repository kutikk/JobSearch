package kg.attractor.jobsearch.controller;


import kg.attractor.jobsearch.dto.ResumeDto;
import kg.attractor.jobsearch.models.Resumes;
import kg.attractor.jobsearch.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resumes")
@RequiredArgsConstructor
public class ResumeController {
    private final ResumeService resumeService;

    @GetMapping("category/{category_id}")
    public ResumeDto getEmployerByCategory(@PathVariable String category_id) {
        return resumeService.getResumeByCategory(Integer.parseInt(category_id));
    }
    @GetMapping("applicant/{applicant_id}")
    public List<ResumeDto> getEmployerByApplicant(@PathVariable String applicant_id) {
        return  resumeService.getResumesApplicant(Integer.parseInt(applicant_id));
    }
    @GetMapping("{resume_id}")
    public ResumeDto getResumeById(@PathVariable String resume_id) {
        return resumeService.getResumesById(Integer.parseInt(resume_id));
    }
    @PutMapping("{id}")
    public ResumeDto updateResume(@PathVariable String id, @RequestBody ResumeDto resumeDto) {
        return resumeService.updateResume(Integer.parseInt(id), resumeDto);
    }

    @PostMapping("new")
    public ResponseEntity<ResumeDto> createResume(@RequestBody Resumes resume) {
        resumeService.createResume(resume);
        return ResponseEntity.status(201).body(ResumeDto.builder()
                .id(resume.getId())
                .name(resume.getName())
                .categoryId(resume.getCategoryId())
                .salary(resume.getSalary())
                .is_active(resume.isIs_active())
                .created_date(resume.getCreated_date())
                .update_time(resume.getUpdate_time())
                .applicant_id(resume.getApplicant_id())
                .build());
    }




}
