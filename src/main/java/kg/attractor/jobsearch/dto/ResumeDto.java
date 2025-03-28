package kg.attractor.jobsearch.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ResumeDto {
    private Integer id;
    @NotBlank
    private String name;
    private Integer categoryId;
    private Float salary;
    private boolean is_active;
    private LocalDateTime update_time;
    private LocalDateTime created_date;
    private Integer applicant_id;
    private List<Education_InfoDto> education_info;
    private List<Work_Experience_Info_Dto> work_experience_info;
}
