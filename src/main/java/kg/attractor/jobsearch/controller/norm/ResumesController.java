package kg.attractor.jobsearch.controller.norm;

import jakarta.validation.Valid;
import kg.attractor.jobsearch.dto.ResumeDto;
import kg.attractor.jobsearch.dto.UserDto;
import kg.attractor.jobsearch.exceptions.UserNotFoundException;
import kg.attractor.jobsearch.service.interfaces.ProfileService;
import kg.attractor.jobsearch.service.interfaces.ResumeService;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("resumes")
public class ResumesController {
    private final ResumeService resumeService;

    public ResumesController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @GetMapping
    public String resumes(@RequestParam(defaultValue = "0") int page,
                          @RequestParam(defaultValue = "5") int size,
                          Model model) {
        Page<ResumeDto> resumePage = resumeService.getResumesPage(page, size);
        model.addAttribute("resumes", resumePage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", resumePage.getTotalPages());
        model.addAttribute("totalItems", resumePage.getTotalElements());
        model.addAttribute("pageSize", size);

        return "resumes";
    }


    @GetMapping("new")
    public String newResume(Model model) {
        model.addAttribute("resume", new ResumeDto());
        return  "newResume";
    }
    @PostMapping("create")
    public String createResume(@ModelAttribute("resume")
                                   @Valid ResumeDto resumeDto, BindingResult bindingResult, Model model)
            throws UserNotFoundException { if (bindingResult.hasErrors()) {
        model.addAttribute("bindingResult", bindingResult);
        model.addAttribute("resume", resumeDto);
        return "newResume";
    }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
          resumeDto.setApplicant_id(username);
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
            resumeDto.setApplicant_id(username);
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
