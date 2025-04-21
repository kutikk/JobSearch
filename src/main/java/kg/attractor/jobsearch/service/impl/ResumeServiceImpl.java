package kg.attractor.jobsearch.service.impl;
import kg.attractor.jobsearch.dto.Education_InfoDto;
import kg.attractor.jobsearch.dto.ResumeDto;
import kg.attractor.jobsearch.dto.Work_Experience_Info_Dto;
import kg.attractor.jobsearch.exceptions.ResumeNotFoundException;
import kg.attractor.jobsearch.models.Education_Info;
import kg.attractor.jobsearch.models.Resumes;
import kg.attractor.jobsearch.models.Users;
import kg.attractor.jobsearch.models.Work_Experience_Info;
import kg.attractor.jobsearch.repository.EducationInfoRepository;
import kg.attractor.jobsearch.repository.ResumeRepository;
import kg.attractor.jobsearch.repository.WorkExperienceInfoRepository;
import kg.attractor.jobsearch.service.interfaces.EducationInfoService;
import kg.attractor.jobsearch.service.interfaces.ResumeService;
import kg.attractor.jobsearch.service.interfaces.Work_Experience_InfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResumeServiceImpl implements ResumeService {
 private final ResumeRepository resumeRepository;
 private final EducationInfoRepository  educationInfoRepository;
 private final WorkExperienceInfoRepository  workExperienceInfoRepository;
 private final Work_Experience_InfoService workExperienceInfoService;
 private final EducationInfoService educationInfoService;



    @Override
    public ResumeDto getResumeByCategory(String categoryID){
        Resumes resumes = resumeRepository.getResumeByCategoryId(categoryID);

        return ResumeDto.builder()
                .id(resumes.getId())
                .name(resumes.getName())
                .categoryId(resumes.getCategoryId())
                .salary(resumes.getSalary())
                .is_active(resumes.is_active())
                .update_time(resumes.getUpdate_time())
                .created_date(resumes.getCreated_date())
                .applicant_id(resumes.getApplicant().getEmail())
                .build();
    }
    @Override
    public ResumeDto getResumeByApplicant(String applicant_id){
        Resumes resumes = resumeRepository.getResumeByApplicantEmail(applicant_id);
        return ResumeDto.builder()
                .id(resumes.getId())
                .name(resumes.getName())
                .categoryId(resumes.getCategoryId())
                .salary(resumes.getSalary())
                .is_active(resumes.is_active())
                .update_time(resumes.getUpdate_time())
                .created_date(resumes.getCreated_date())
                .applicant_id(resumes.getApplicant().getEmail())
                .build();
    }
    @Override
    public List<ResumeDto> getResumesApplicant(String applicant_id){
       /* List<Resumes> list = resumeRepository.findByApplicantEmail(applicant_id);
        return list.stream()
                .map(resumes -> ResumeDto.builder()
                        .id(resumes.getId())
                        .name(resumes.getName())
                        .categoryId(resumes.getCategoryId())
                        .salary(resumes.getSalary())
                        .is_active(resumes.is_active())
                        .update_time(resumes.getUpdate_time())
                        .created_date(resumes.getCreated_date())
                        .applicant_id(resumes.getApplicant().getEmail())
                        .build())
                .toList();
*/
        return new ArrayList<>();
    }
    @Override
    public ResumeDto getResumesById(Long resume_id){
        Resumes resumes = resumeRepository.findById(resume_id)
                .orElseThrow(ResumeNotFoundException::new);
       List<Education_InfoDto> list4 = educationInfoService.getEducationInfoListByResumeId(resume_id);
       List<Work_Experience_Info_Dto> list1= workExperienceInfoService.getWorkExperienceInfoListByResumeId(resume_id);
        return ResumeDto.builder()
                .id(resumes.getId())
                .name(resumes.getName())
                .categoryId(resumes.getCategoryId())
                .salary(resumes.getSalary())
                .is_active(resumes.is_active())
                .update_time(resumes.getUpdate_time())
                .created_date(resumes.getCreated_date())
                .applicant_id(resumes.getApplicant().getEmail())
                .education_info(list4)
                .work_experience_info(list1)
                .build();
    }
    @Override
    public String updateResume(Long id, ResumeDto resumeDto) {
        Users user = new Users();
        user.setEmail(resumeDto.getApplicant_id());
        Resumes resumes = resumeRepository.findById(id)
                .orElseThrow(ResumeNotFoundException::new);
        resumes.setName(resumeDto.getName());
        resumes.setCategoryId(resumeDto.getCategoryId());
        resumes.setSalary(resumeDto.getSalary());
        resumes.set_active(resumeDto.is_active());
        resumes.setUpdate_time(LocalDateTime.now());
        resumes.setApplicant(user);

        List<Education_InfoDto> educationInfos = Optional.ofNullable(resumeDto.getEducation_info())
                .orElse(Collections.emptyList());
        List<Work_Experience_Info_Dto> workExperience = Optional.ofNullable(resumeDto.getWork_experience_info())
                .orElse(Collections.emptyList());

        resumeRepository.save(resumes);

        return "/successUpdateResume";
    }



    @Override
    public String createResume(ResumeDto resumeDto) {
        Users user = new Users();
        user.setEmail(resumeDto.getApplicant_id());
        Resumes resume = new Resumes();
        resume.setName(resumeDto.getName());
        resume.setCategoryId(resumeDto.getCategoryId());
        resume.setSalary(resumeDto.getSalary());
        resume.set_active(resumeDto.is_active());
        resume.setUpdate_time(LocalDateTime.now());
        resume.setApplicant(user);
        resume.setCreated_date(LocalDateTime.now());
       resumeRepository.save(resume);
        List<Education_Info> educationList = resumeDto.getEducation_info().stream()
                .map(edu->Education_Info.builder()
                        .institution(edu.getInstitution())
                        .program(edu.getProgram())
                                .degree(edu.getDegree())
                                .start_date(edu.getStart_date())
                                .end_date(edu.getEnd_date())
                                .degree(edu.getDegree())
                                .resume(resume)
                        .build())
                .collect(Collectors.toList());
        educationInfoRepository.saveAll(educationList);
        List<Work_Experience_Info> workInfo = resumeDto.getWork_experience_info().stream()
                .map(wInfo->Work_Experience_Info.builder()
                        .years(wInfo.getYears())
                        .company_name(wInfo.getCompany_name())
                        .position(wInfo.getPosition())
                        .responsibilities(wInfo.getResponsibilities())
                        .resume(resume)
                        .build())
                .collect(Collectors.toList());
        workExperienceInfoRepository.saveAll(workInfo);
        return "/success";
    }

    private void checked(List<Education_InfoDto> educationInfos,
                         List<Work_Experience_Info_Dto> workExperience, Resumes resumes) {
        List<Education_InfoDto> filteredEducation = educationInfos.stream()
                .filter(Objects::nonNull)
                .filter(e -> e.getInstitution() != null && !e.getInstitution().isBlank())
                .collect(Collectors.toList());
        if (!filteredEducation.isEmpty()) {
            educationInfoService.saveEdu(filteredEducation, resumes);
        }
        List<Work_Experience_Info_Dto> filteredExperience = workExperience.stream()
                .filter(Objects::nonNull)
                .filter(e -> e.getCompany_name() != null && !e.getCompany_name().isBlank())
                .collect(Collectors.toList());
        if (!filteredExperience.isEmpty()) {
            workExperienceInfoService.saveWorkInfo(filteredExperience, resumes);
        }
    }

    @Override
    public boolean deleteResumeById(Long resume_id) {
        return false;
    }
@Override
public Page<ResumeDto> getResumesPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Resumes> resumes = resumeRepository.findAll(pageable);

        return resumes.map(resume -> ResumeDto.builder()
                .id(resume.getId())
                .name(resume.getName())
                .categoryId(resume.getCategoryId())
                .salary(resume.getSalary())
                .is_active(resume.is_active())
                .update_time(resume.getUpdate_time())
                .created_date(resume.getCreated_date())
                .applicant_id(resume.getApplicant() != null ? resume.getApplicant().getEmail() : null)
                .build()
        );
    }



@Override
public ResumeDto getResumeDtoById(Long resume_id) {
        Resumes resumes = resumeRepository.findById(resume_id).orElseThrow(() ->
                new RuntimeException("Resume not found"));
        List<Education_Info> eduList = educationInfoRepository.findAllByResumeId(resume_id);
        List<Education_InfoDto> dtoList = eduList.stream()
                .map(edu -> {
                    Education_InfoDto dto = new Education_InfoDto();
                    dto.setInstitution(edu.getInstitution());
                    dto.setDegree(edu.getDegree());
                    dto.setStart_date(edu.getStart_date());
                    dto.setEnd_date(edu.getEnd_date());
                    return dto;
                })
                .collect(Collectors.toList());
        List<Work_Experience_Info> workExperience = workExperienceInfoRepository.findAllByResumeId(resume_id);
        List<Work_Experience_Info_Dto> workList = workExperience.stream()
                        .map(workEx ->{
                            Work_Experience_Info_Dto dto = new Work_Experience_Info_Dto();
                            dto.setYears(workEx.getYears());
                            dto.setCompany_name(workEx.getCompany_name());
                            dto.setPosition(workEx.getPosition());
                            dto.setResponsibilities(workEx.getResponsibilities());
                     return dto;   })
                                .collect(Collectors.toList());

       return ResumeDto.builder()
                .id(resumes.getId())
                .name(resumes.getName())
                .categoryId(resumes.getCategoryId())
                .salary(resumes.getSalary())
                .is_active(resumes.is_active())
                .education_info(dtoList)
                .work_experience_info(workList)
                .is_active(resumes.is_active())
                .update_time(resumes.getUpdate_time())
                .created_date(resumes.getCreated_date())
                .applicant_id(resumes.getApplicant() != null ? resumes.getApplicant().getEmail() : null)
                .build();
    }


}
