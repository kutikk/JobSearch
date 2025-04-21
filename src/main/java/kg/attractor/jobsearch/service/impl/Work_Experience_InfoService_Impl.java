package kg.attractor.jobsearch.service.impl;

import kg.attractor.jobsearch.dto.Work_Experience_Info_Dto;
import kg.attractor.jobsearch.models.Resumes;
import kg.attractor.jobsearch.models.Work_Experience_Info;
import kg.attractor.jobsearch.repository.WorkExperienceInfoRepository;
import kg.attractor.jobsearch.service.interfaces.Work_Experience_InfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Work_Experience_InfoService_Impl implements Work_Experience_InfoService {
    private final WorkExperienceInfoRepository workExperienceInfoRepository;
@Override
public List<Work_Experience_Info_Dto> getWorkExperienceInfoListByResumeId(Long resume_id){
        List<Work_Experience_Info> we = workExperienceInfoRepository.findAllByResumeId(resume_id);
       return we.stream().map(
                workInfo -> Work_Experience_Info_Dto.builder()
                        .company_name(workInfo.getCompany_name())
                        .years(workInfo.getYears())
                        .position(workInfo.getPosition())
                        .resume_id(workInfo.getResume().getId())
                        .build())
                .toList();

    }
    @Override
    public void saveWorkInfo(List<Work_Experience_Info_Dto> workExpInfoDto, Resumes resumes){
     List<Work_Experience_Info> we = workExpInfoDto.stream()
             .map(workInfo -> Work_Experience_Info.builder()
                     .years(workInfo.getYears())
                     .company_name(workInfo.getCompany_name())
                     .position(workInfo.getPosition())
                     .responsibilities(workInfo.getResponsibilities())
                     .resume(resumes)
                     .build())
             .toList();
     workExperienceInfoRepository.saveAll(we);
    }
}
