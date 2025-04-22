package kg.attractor.jobsearch.service.interfaces;

import kg.attractor.jobsearch.dto.Work_Experience_Info_Dto;
import kg.attractor.jobsearch.models.Resumes;

import java.util.List;

public interface Work_Experience_InfoService {
    List<Work_Experience_Info_Dto> getWorkExperienceInfoListByResumeId(Long resume_id);

    void saveWorkInfo(List<Work_Experience_Info_Dto> workExpInfoDto, Resumes resumes);
}
