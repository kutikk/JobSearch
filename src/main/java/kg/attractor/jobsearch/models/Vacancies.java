package kg.attractor.jobsearch.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "vacancies", schema = "public")
public class Vacancies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String name;
    @Lob
    @Column
    private String description;
    private Integer category_id;
    private Float salary;
    private Integer exp_from;
    private Integer exp_to;
    private Boolean is_active;
    @ManyToOne()
    @JoinColumn(name = "author_id")
    private Users author;
    private LocalDateTime created_date;
    private LocalDateTime update_time;

}
