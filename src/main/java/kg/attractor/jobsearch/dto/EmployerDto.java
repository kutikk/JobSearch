package kg.attractor.jobsearch.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class EmployerDto {
    private Long id;
    @NotBlank
    private String user_name;
    @NotBlank
    private String email;
    @NotBlank
    @Size(min = 1, max = 50)
    private String password;
    private String phone_number;
    private String avatar;
    private Integer age;
    private String account_type;
    private Long resumesID;
}
