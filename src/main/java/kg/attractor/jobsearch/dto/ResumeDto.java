package kg.attractor.jobsearch.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Builder
public class ResumeDto {
    private Integer id;
    private String name;
    private Integer categoryId;
    private Float salary;
    private boolean is_active;
    private LocalDateTime update_time;
    private LocalDateTime created_date;
    private Integer applicant_id;
}
