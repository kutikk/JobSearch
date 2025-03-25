package kg.attractor.jobsearch.service;


import kg.attractor.jobsearch.dao.ResumeDao;
import kg.attractor.jobsearch.dto.ResumeDto;
import kg.attractor.jobsearch.exceptions.UserNotFoundException;
import kg.attractor.jobsearch.models.Resumes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ResumeServiceImpl implements ResumeService {
 private final ResumeDao resumeDao;

    @Override
    public ResumeDto getResumeByCategory(int categoryID){
        Resumes resumes = resumeDao.getResumeByCategory(categoryID)
                .orElseThrow(UserNotFoundException::new);
        return ResumeDto.builder()
                .id(resumes.getId())
                .name(resumes.getName())
                .categoryId(resumes.getCategoryId())
                .salary(resumes.getSalary())
                .is_active(resumes.isIs_active())
                .update_time(resumes.getUpdate_time())
                .created_date(resumes.getCreated_date())
                .applicant_id(resumes.getApplicant_id())
                .build();
    }
    @Override
    public ResumeDto getResumeByApplicant(int applicant_id){
        Resumes resumes = resumeDao.getResumeByApplicant(applicant_id)
                .orElseThrow(UserNotFoundException::new);
        return ResumeDto.builder()
                .id(resumes.getId())
                .name(resumes.getName())
                .categoryId(resumes.getCategoryId())
                .salary(resumes.getSalary())
                .is_active(resumes.isIs_active())
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
                        .is_active(resumes.isIs_active())
                        .update_time(resumes.getUpdate_time())
                        .created_date(resumes.getCreated_date())
                        .applicant_id(resumes.getApplicant_id())
                        .build())
                .toList();

    }
    @Override
    public ResumeDto getResumesById(int resume_id){
        Resumes resumes = resumeDao.getResumeByApplicant(resume_id)
                .orElseThrow(UserNotFoundException::new);
        return ResumeDto.builder()
                .id(resumes.getId())
                .name(resumes.getName())
                .categoryId(resumes.getCategoryId())
                .salary(resumes.getSalary())
                .is_active(resumes.isIs_active())
                .update_time(resumes.getUpdate_time())
                .created_date(resumes.getCreated_date())
                .applicant_id(resumes.getApplicant_id())
                .build();

    }
    @Override
    public ResumeDto updateResume(int id, ResumeDto resumeDto) {
        Resumes resumes = resumeDao.getResumeById(id)
                .orElseThrow(() -> new IllegalArgumentException("Resume not found"));
        resumes.setName(resumeDto.getName());
        resumes.setCategoryId(resumeDto.getCategoryId());
        resumes.setSalary(resumeDto.getSalary());
        resumes.setIs_active(resumeDto.is_active());
        resumes.setUpdate_time(LocalDateTime.now());
        resumes.setApplicant_id(resumeDto.getApplicant_id());

        resumeDao.updateResume(resumes);

        return ResumeDto.builder()
                .id(resumes.getId())
                .name(resumes.getName())
                .categoryId(resumes.getCategoryId())
                .salary(resumes.getSalary())
                .is_active(resumes.isIs_active())
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
        newResume.setIs_active(resumeDto.is_active());
        newResume.setCreated_date(LocalDateTime.now());
        newResume.setUpdate_time(LocalDateTime.now());
        newResume.setApplicant_id(resumeDto.getApplicant_id());

        resumeDao.save(newResume);

        return ResumeDto.builder()
                .id(newResume.getId())
                .name(newResume.getName())
                .categoryId(newResume.getCategoryId())
                .salary(newResume.getSalary())
                .is_active(newResume.isIs_active())
                .update_time(newResume.getUpdate_time())
                .created_date(newResume.getCreated_date())
                .applicant_id(newResume.getApplicant_id())
                .build();
    }


}
