package kg.attractor.jobsearch.dto;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VacancyDto {
    private Integer id;
    private String name;
    private String description;
    private Long category_id;
    private Float salary;
    private Integer exp_from;
    private Integer exp_to;
    private Boolean is_active;
    private Long author_id;
    private LocalDateTime created_date;
    private LocalDateTime update_time;
}
