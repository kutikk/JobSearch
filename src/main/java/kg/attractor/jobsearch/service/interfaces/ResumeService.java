package kg.attractor.jobsearch.service.interfaces;

import kg.attractor.jobsearch.dto.ResumeDto;

import java.util.List;

public interface ResumeService {
    ResumeDto getResumeByCategory(Long categoryID);

    ResumeDto getResumeByApplicant(Long applicant_id);

    List<ResumeDto> getResumesApplicant(Long applicant_id);

    ResumeDto getResumesById(Long resume_id);

    String updateResume(Long resume_id, ResumeDto resumeDto);

    String createResume(ResumeDto resumeDto);

    boolean deleteResumeById(Long resume_id);

    List<ResumeDto> getResumes();

    ResumeDto getResumeDtoById(Long resume_id);
}
