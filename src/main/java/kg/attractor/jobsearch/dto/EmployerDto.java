package kg.attractor.jobsearch.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployerDto {
    private Integer id;
    private String user_name;
    private String email;
    private String password;
    private String phone_number;
    private String avatar;
    private Integer age;
    private String account_type;
    private Integer resumesID;
}
