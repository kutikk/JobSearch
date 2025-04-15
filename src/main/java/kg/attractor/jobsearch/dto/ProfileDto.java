package kg.attractor.jobsearch.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import kg.attractor.jobsearch.models.Resumes;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@Builder
public class ProfileDto
{

    private Integer id;
    private String user_name;
    private String email;
    @Size(min = 1, max =50)
    @NonNull
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).+$",
            message = "Should contain at least one uppercase letter, one number")
    private String password;
    private String phone_number;
    private String avatar;
    private Integer age;
    private String account_type;
    private List<Resumes> resumes;
}
