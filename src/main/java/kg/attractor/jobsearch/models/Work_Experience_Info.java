package kg.attractor.jobsearch.models;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "work_experience_info")
public class Work_Experience_Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer years;
    private String company_name;
    private String position;
    private String responsibilities;
    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resumes resume;

}
