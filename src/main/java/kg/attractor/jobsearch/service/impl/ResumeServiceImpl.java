package kg.attractor.jobsearch.service.impl;


import kg.attractor.jobsearch.dao.Education_Info_dao;
import kg.attractor.jobsearch.dao.ResumeDao;
import kg.attractor.jobsearch.dao.Work_Experience_Info_Dao;
import kg.attractor.jobsearch.dto.Education_InfoDto;
import kg.attractor.jobsearch.dto.ResumeDto;
import kg.attractor.jobsearch.dto.Work_Experience_Info_Dto;
import kg.attractor.jobsearch.exceptions.ResumeNotFoundException;
import kg.attractor.jobsearch.models.Resumes;
import kg.attractor.jobsearch.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ResumeServiceImpl implements ResumeService {
 private final ResumeDao resumeDao;
 private final Education_Info_dao  education_Info_dao;
 private final Work_Experience_Info_Dao work_experience_Info_Dao;

    @Override
    public ResumeDto getResumeByCategory(int categoryID){
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
    public ResumeDto getResumeByApplicant(int applicant_id){
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
    public List<ResumeDto> getResumesApplicant(int applicant_id){
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
    public ResumeDto getResumesById(int resume_id){
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
    public ResumeDto updateResume(int id, ResumeDto resumeDto) {
        Resumes resumes = resumeDao.getResumeById(id)
                .orElseThrow(ResumeNotFoundException::new);
        resumes.setName(resumeDto.getName());
        resumes.setCategoryId(resumeDto.getCategoryId());
        resumes.setSalary(resumeDto.getSalary());
        resumes.set_active(resumeDto.is_active());
        resumes.setUpdate_time(LocalDateTime.now());
        resumes.setApplicant_id(resumeDto.getApplicant_id());

        resumeDao.updateResume(resumes);

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
    public ResumeDto createResume(Resumes resumeDto) {
        Resumes newResume = new Resumes();
        newResume.setName(resumeDto.getName());
        newResume.setCategoryId(resumeDto.getCategoryId());
        newResume.setSalary(resumeDto.getSalary());
        newResume.set_active(resumeDto.is_active());
        newResume.setCreated_date(LocalDateTime.now());
        newResume.setUpdate_time(LocalDateTime.now());
        newResume.setApplicant_id(resumeDto.getApplicant_id());

        List<Education_InfoDto> educationInfos = resumeDto.getEducation_info();
        newResume.setEducation_info(educationInfos);

        List<Work_Experience_Info_Dto> workExperience = resumeDto.getWork_experience_info();
        newResume.setEducation_info(educationInfos);
        newResume.setWork_experience_info(workExperience);

        resumeDao.save(newResume);
        education_Info_dao.saveEducation_Info(educationInfos);
        work_experience_Info_Dao.saveWorkExperienceInfo(workExperience);



        return ResumeDto.builder()
                .id(newResume.getId())
                .name(newResume.getName())
                .categoryId(newResume.getCategoryId())
                .salary(newResume.getSalary())
                .is_active(newResume.is_active())
                .update_time(newResume.getUpdate_time())
                .created_date(newResume.getCreated_date())
                .applicant_id(newResume.getApplicant_id())
                .education_info(newResume.getEducation_info())
                .work_experience_info(newResume.getWork_experience_info())
                .build();
    }

    @Override
    public boolean deleteResumeById(int resume_id) {
        Resumes resumes = resumeDao.getResumeById(resume_id)
                .orElseThrow(() -> new IllegalArgumentException("Resume not found"));
        if (resumes == null) {
            return false;
        } else {
            resumeDao.deleteResumeById(resume_id);
            return true;
        }
    }


}
