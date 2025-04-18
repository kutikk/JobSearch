package kg.attractor.jobsearch.controller.norm;

import kg.attractor.jobsearch.dto.ResumeDto;
import kg.attractor.jobsearch.exceptions.UserNotFoundException;
import kg.attractor.jobsearch.service.interfaces.ProfileService;
import kg.attractor.jobsearch.service.interfaces.ResumeService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("resumes")
public class ResumesController {
    private final ResumeService resumeService;
    private final ProfileService profileService;

    public ResumesController(ResumeService resumeService, ProfileService profileService) {
        this.resumeService = resumeService;
        this.profileService = profileService;
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
    @PostMapping("create")
    public String createResume(ResumeDto resumeDto, Model model) throws UserNotFoundException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        Long userId = profileService.getIdByUsername(username);
          resumeDto.setApplicant_id(userId);
           return  resumeService.createResume(resumeDto);
    }

    @GetMapping("edit/{id}")
    public String updateResume(@PathVariable Long id, Model model) {
            ResumeDto resume = resumeService.getResumesById(id);
            model.addAttribute("resume", resume);
            return "resumeUpdate";
        }

        @PostMapping("edit/{id}")
    public String updateResume(@PathVariable Long id, ResumeDto resumeDto, Model model) throws UserNotFoundException {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String username = auth.getName();
            Long userId = profileService.getIdByUsername(username);
            resumeDto.setApplicant_id(userId);
        resumeService.updateResume(id, resumeDto);
         return resumeService.updateResume(id, resumeDto);
        }
    @GetMapping("details/{id}")
    public String showResumeDetails(@PathVariable Long id, Model model) {
        ResumeDto resume = resumeService.getResumeDtoById(id);
        model.addAttribute("resume", resume);
        return "resumeDetails";
    }




}
