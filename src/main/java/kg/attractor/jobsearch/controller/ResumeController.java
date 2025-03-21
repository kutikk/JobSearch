package kg.attractor.jobsearch.controller;


import kg.attractor.jobsearch.dto.ResumeDto;
import kg.attractor.jobsearch.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
