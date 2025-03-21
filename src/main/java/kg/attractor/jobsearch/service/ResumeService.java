package kg.attractor.jobsearch.service;

import kg.attractor.jobsearch.dto.ResumeDto;

import java.util.List;

public interface ResumeService {
    ResumeDto getResumeByCategory(int categoryID);

    ResumeDto getResumeByApplicant(int applicant_id);

    List<ResumeDto> getResumesApplicant(int applicant_id);
}
