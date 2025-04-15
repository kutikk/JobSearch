package kg.attractor.jobsearch.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {
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
