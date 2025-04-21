package kg.attractor.jobsearch.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Builder
public class ResumeDto {
    private Long id;
    @NotBlank
    private String name;
    private String categoryId;
    private Float salary;
    private boolean is_active;
    private LocalDateTime update_time;
    private LocalDateTime created_date;
    private String applicant_id;
    private List<Education_InfoDto> education_info;
    private List<Work_Experience_Info_Dto> work_experience_info;
}
