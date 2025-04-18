package kg.attractor.jobsearch.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "education_info")
public class Education_Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String institution;
    private String program;
    private LocalDate start_date;
    private LocalDate end_date;
    private String degree;
    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resumes resume;

}
