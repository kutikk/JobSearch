package kg.attractor.jobsearch.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" )
    private Long  id;
    private String user_name;
    private String email;
    private String password;
    private String phone_number;
    private String avatar;
    private Integer age;
    private String account_type;
    private Boolean enabled;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "applicant")
    private List<Resumes> resumes;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "author")
    private List<Vacancies> vacancies;




}
