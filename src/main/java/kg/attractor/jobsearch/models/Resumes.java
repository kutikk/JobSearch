package kg.attractor.jobsearch.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Resumes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer categoryId;
    private Float salary;
    private boolean is_active;
    private LocalDateTime update_time;
    private LocalDateTime created_date;
    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private Users applicant;

}
