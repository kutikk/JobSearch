package kg.attractor.jobsearch.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VacancyDto {
    private Integer id;
    @NotBlank(message = "Название вакансии не должно быть пустым")
    private String name;
    @NotBlank(message = "Добавьте описание")
    private String description;
    @NotNull(message = "Выберите категорию вакансии")
    private String category_id;
    @NotNull(message = "Введите оклад")
    private Float salary;
    @NotNull(message = "Введите требуемый опыт")
    private Integer exp_from;
    @NotNull(message = "Введите требуемый опыт")
    private Integer exp_to;
    @NotNull(message = "Введите активность вакансии")
    private Boolean is_active;
    private String author_id;
    private LocalDateTime created_date;
    private LocalDateTime update_time;
}
