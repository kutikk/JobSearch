package kg.attractor.jobsearch.service.impl;


import kg.attractor.jobsearch.dao.Education_Info_dao;
import kg.attractor.jobsearch.dao.ResumeDao;
import kg.attractor.jobsearch.dao.Work_Experience_Info_Dao;
import kg.attractor.jobsearch.dto.Education_InfoDto;
import kg.attractor.jobsearch.dto.ResumeDto;
import kg.attractor.jobsearch.dto.Work_Experience_Info_Dto;
import kg.attractor.jobsearch.exceptions.ResumeNotFoundException;
import kg.attractor.jobsearch.models.Resumes;
import kg.attractor.jobsearch.service.ProfileService;
import kg.attractor.jobsearch.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResumeServiceImpl implements ResumeService {
 private final ResumeDao resumeDao;
 private final Education_Info_dao  education_Info_dao;
 private final Work_Experience_Info_Dao work_experience_Info_Dao;

    @Override
    public ResumeDto getResumeByCategory(Long categoryID){
        Resumes resumes = resumeDao.getResumeByCategory(categoryID)
                .orElseThrow(ResumeNotFoundException::new);
        return ResumeDto.builder()
                .id(resumes.getId())
                .name(resumes.getName())
                .categoryId(resumes.getCategoryId())
                .salary(resumes.getSalary())
                .is_active(resumes.is_active())
                .update_time(resumes.getUpdate_time())
                .created_date(resumes.getCreated_date())
                .applicant_id(resumes.getApplicant_id())
                .build();
    }
    @Override
    public ResumeDto getResumeByApplicant(Long applicant_id){
        Resumes resumes = resumeDao.getResumeByApplicant(applicant_id)
                .orElseThrow(ResumeNotFoundException::new);
        return ResumeDto.builder()
                .id(resumes.getId())
                .name(resumes.getName())
                .categoryId(resumes.getCategoryId())
                .salary(resumes.getSalary())
                .is_active(resumes.is_active())
                .update_time(resumes.getUpdate_time())
                .created_date(resumes.getCreated_date())
                .applicant_id(resumes.getApplicant_id())
                .build();
    }
    @Override
    public List<ResumeDto> getResumesApplicant(Long applicant_id){
        List<Resumes> list = resumeDao.getResumes(applicant_id);
        return list.stream()
                .map(resumes -> ResumeDto.builder()
                        .id(resumes.getId())
                        .name(resumes.getName())
                        .categoryId(resumes.getCategoryId())
                        .salary(resumes.getSalary())
                        .is_active(resumes.is_active())
                        .update_time(resumes.getUpdate_time())
                        .created_date(resumes.getCreated_date())
                        .applicant_id(resumes.getApplicant_id())
                        .build())
                .toList();

    }
    @Override
    public ResumeDto getResumesById(Long resume_id){
        Resumes resumes = resumeDao.getResumeById(resume_id)
                .orElseThrow(ResumeNotFoundException::new);
       List<Education_InfoDto> list = education_Info_dao.getEducation_Info_ByResumeId(resume_id);
       List<Work_Experience_Info_Dto> list1= work_experience_Info_Dao.getWork_Experience_InfoByID(resume_id);
        return ResumeDto.builder()
                .id(resumes.getId())
                .name(resumes.getName())
                .categoryId(resumes.getCategoryId())
                .salary(resumes.getSalary())
                .is_active(resumes.is_active())
                .update_time(resumes.getUpdate_time())
                .created_date(resumes.getCreated_date())
                .applicant_id(resumes.getApplicant_id())
                .education_info(list)
                .work_experience_info(list1)
                .build();
    }
    @Override
    public String updateResume(Long id, ResumeDto resumeDto) {
        Resumes resumes = resumeDao.getResumeById(id)
                .orElseThrow(ResumeNotFoundException::new);
        resumes.setName(resumeDto.getName());
        resumes.setCategoryId(resumeDto.getCategoryId());
        resumes.setSalary(resumeDto.getSalary());
        resumes.set_active(resumeDto.is_active());
        resumes.setUpdate_time(LocalDateTime.now());
        resumes.setApplicant_id(resumeDto.getApplicant_id());

        List<Education_InfoDto> educationInfos = Optional.ofNullable(resumeDto.getEducation_info())
                .orElse(Collections.emptyList());
        List<Work_Experience_Info_Dto> workExperience = Optional.ofNullable(resumeDto.getWork_experience_info())
                .orElse(Collections.emptyList());

        resumeDao.updateResume(resumes);

        checked(educationInfos, workExperience, resumes.getId());

        return "/successUpdateResume";
    }


    private void checked(List<Education_InfoDto> educationInfos, List<Work_Experience_Info_Dto> workExperience, long resumeId) {
        List<Education_InfoDto> filteredEducation = educationInfos.stream()
                .filter(Objects::nonNull)
                .filter(e -> e.getInstitution() != null && !e.getInstitution().isBlank()) // Проверка на пустые данные
                .collect(Collectors.toList());
        if (!filteredEducation.isEmpty()) {
            education_Info_dao.saveEducation_Info(filteredEducation, resumeId);
        }
        List<Work_Experience_Info_Dto> filteredExperience = workExperience.stream()
                .filter(Objects::nonNull)
                .filter(e -> e.getCompany_name() != null && !e.getCompany_name().isBlank()) // Проверка на пустые данные
                .collect(Collectors.toList());
        if (!filteredExperience.isEmpty()) {
            work_experience_Info_Dao.saveWorkExperienceInfo(filteredExperience, resumeId);
        }
    }



    @Override
    public String createResume(ResumeDto resumeDto) {
        Long existingResumeId = resumeDao.getResumeIDByName(resumeDto.getName());
        if (existingResumeId != null) {
            return "errorPage";
        }
        Resumes resume = new Resumes();
        resume.setName(resumeDto.getName());
        resume.setCategoryId(resumeDto.getCategoryId());
        resume.setSalary(resumeDto.getSalary());
        resume.set_active(resumeDto.is_active());
        resume.setUpdate_time(LocalDateTime.now());
        resume.setApplicant_id(resumeDto.getApplicant_id());
        resume.setCreated_date(LocalDateTime.now());
        List<Education_InfoDto> educationInfos = Optional.ofNullable(resumeDto.getEducation_info())
                .orElse(Collections.emptyList());
        List<Work_Experience_Info_Dto> workExperience = Optional.ofNullable(resumeDto.getWork_experience_info())
                .orElse(Collections.emptyList());
        resumeDao.save(resume);
        Long res_id = resumeDao.getResumeIDByName(resumeDto.getName());

        checked(educationInfos, workExperience, res_id);

        return "/success";
    }



    @Override
    public boolean deleteResumeById(Long resume_id) {
        Resumes resumes = resumeDao.getResumeById(resume_id)
                .orElseThrow(() -> new IllegalArgumentException("Resume not found"));
        if (resumes == null) {
            return false;
        } else {
            resumeDao.deleteResumeById(resume_id);
            return true;
        }
    }

    @Override
    public List<ResumeDto> getResumes() {
        List<Resumes>  list= resumeDao.getAllResumes();
        return list.stream()
                .map(
                        resumes -> ResumeDto.builder()
                                .id(resumes.getId())
                                .name(resumes.getName())
                                .categoryId(resumes.getCategoryId())
                                .salary(resumes.getSalary())
                                .is_active(resumes.is_active())
                                .update_time(resumes.getUpdate_time())
                                .created_date(resumes.getCreated_date())
                                .applicant_id(resumes.getApplicant_id())
                                .build())
                .collect(Collectors.toList());

    }
}
