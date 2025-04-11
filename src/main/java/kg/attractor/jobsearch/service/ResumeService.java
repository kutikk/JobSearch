package kg.attractor.jobsearch.service;

import kg.attractor.jobsearch.dto.Education_InfoDto;
import kg.attractor.jobsearch.dto.ResumeDto;
import kg.attractor.jobsearch.models.Resumes;

import java.util.List;

public interface ResumeService {
    ResumeDto getResumeByCategory(int categoryID);

    ResumeDto getResumeByApplicant(int applicant_id);

    List<ResumeDto> getResumesApplicant(int applicant_id);

    ResumeDto getResumesById(int resume_id);

    ResumeDto updateResume(int resume_id, ResumeDto resumeDto);

    ResumeDto createResume(Resumes resumeDto);

    boolean deleteResumeById(int resume_id);

    List<ResumeDto> getResumes();
}
