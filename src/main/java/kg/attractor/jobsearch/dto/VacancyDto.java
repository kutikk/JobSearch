package kg.attractor.jobsearch.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Builder
public class VacancyDto {
    private Integer id;
    private String name;
    private String description;
    private Integer category_id;
    private Float salary;
    private Integer exp_from;
    private Integer exp_to;
    private Boolean is_active;
    private Integer author_id;
    private LocalDateTime created_date;
    private LocalDateTime update_time;
}
