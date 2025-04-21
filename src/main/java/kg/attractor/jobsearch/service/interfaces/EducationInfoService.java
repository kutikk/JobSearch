package kg.attractor.jobsearch.service.interfaces;

import kg.attractor.jobsearch.dto.Education_InfoDto;
import kg.attractor.jobsearch.models.Education_Info;
import kg.attractor.jobsearch.models.Resumes;

import java.util.List;

public interface EducationInfoService {

    List<Education_InfoDto> getEducationInfoListByResumeId(Long resume_id);

    void saveEdu(List<Education_InfoDto> educationInfoList,Resumes resumes);
}
