package kg.attractor.jobsearch.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import kg.attractor.jobsearch.models.Resumes;
import kg.attractor.jobsearch.models.Vacancies;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Long id;

    @NotBlank(message = "Имя обязательно для заполнения")
    private String user_name;

    @NotBlank(message = "Email обязателен для заполнения")
    @Email(message = "Введите корректный email")
    private String email;

    @NotBlank(message = "Пароль обязателен для заполнения")
    @Size(min = 6, message = "Пароль должен содержать минимум 6 символов")
    private String password;
    private String phone_number;
    private String avatar;
    private Integer age;
    private String account_type;
    private List<Resumes> resumes;
    private List<Vacancies> vacancies;
}