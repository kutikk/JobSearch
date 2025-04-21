package kg.attractor.jobsearch.service.impl;

import kg.attractor.jobsearch.dto.Education_InfoDto;
import kg.attractor.jobsearch.models.Education_Info;
import kg.attractor.jobsearch.models.Resumes;
import kg.attractor.jobsearch.repository.EducationInfoRepository;
import kg.attractor.jobsearch.service.interfaces.EducationInfoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EducationInfoServiceImpl implements EducationInfoService {
    private final EducationInfoRepository educationInfoRepository;
    public EducationInfoServiceImpl(EducationInfoRepository educationInfoRepository) {
        this.educationInfoRepository = educationInfoRepository;
    }

    @Override
    public List<Education_InfoDto> getEducationInfoListByResumeId(Long resume_id){
        List<Education_Info> eduList = educationInfoRepository.findAllByResumeId(resume_id);

        return eduList.stream()
                .map(eduInfo ->Education_InfoDto.builder()
                        .institution(eduInfo.getInstitution())
                        .program(eduInfo.getProgram())
                        .start_date(eduInfo.getStart_date())
                        .end_date(eduInfo.getEnd_date())
                        .degree(eduInfo.getDegree())
                        .resume_id(eduInfo.getResume().getId())
                        .build()
                 )
                .collect(Collectors.toList());
    }
   @Override
   public void saveEdu(List<Education_InfoDto> educationInfoList, Resumes resumes){
      List<Education_Info> list = educationInfoList.stream()
                .map(eduInfo->Education_Info.builder()
                        .institution(eduInfo.getInstitution())
                        .program(eduInfo.getProgram())
                        .start_date(eduInfo.getStart_date())
                        .end_date(eduInfo.getEnd_date())
                        .degree(eduInfo.getDegree())
                        .resume(resumes)
                        .build())
                .collect(Collectors.toList());
      educationInfoRepository.saveAll(list);
    }
}
