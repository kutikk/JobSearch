package kg.attractor.jobsearch.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDto {
    private Long id;
    @NotBlank(message = "Название резюме не должно быть пустым")
    private String name;
    @NotNull(message = "Выберите сферу работы")
    private Long categoryId;
    @NotNull(message = "Добавьте желаемую заработную плату")
    private Float salary;
    @NotNull(message = "Выберите один из вариантов")
    private boolean is_active;
    private LocalDateTime update_time;
    private LocalDateTime created_date;
    private String applicant_id;
    private List<Education_InfoDto> education_info;
    private List<Work_Experience_Info_Dto> work_experience_info;
}
