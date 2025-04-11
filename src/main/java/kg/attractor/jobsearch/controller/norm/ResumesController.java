package kg.attractor.jobsearch.controller.norm;

import kg.attractor.jobsearch.service.ResumeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("resumes")
public class ResumesController {
    private final ResumeService resumeService;

    public ResumesController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @GetMapping
    public String resumes(Model model) {
        model.addAttribute("resumes",resumeService.getResumes());
        return "resumes";
    }

    @GetMapping("new")
    public String newResume(Model model) {
        return  "newResume";
    }
}
