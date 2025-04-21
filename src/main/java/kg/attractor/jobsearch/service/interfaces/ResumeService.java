package kg.attractor.jobsearch.service.interfaces;

import kg.attractor.jobsearch.dto.ResumeDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ResumeService {



    ResumeDto getResumeByCategory(String categoryID);

    ResumeDto getResumeByApplicant(String applicant_id);

    List<ResumeDto> getResumesApplicant(String applicant_id);

    ResumeDto getResumesById(Long resume_id);

    String updateResume(Long resume_id, ResumeDto resumeDto);

    String createResume(ResumeDto resumeDto);

    boolean deleteResumeById(Long resume_id);

    Page<ResumeDto> getResumesPage(int page, int size);


    ResumeDto getResumeDtoById(Long resume_id);
}
