package kg.attractor.jobsearch.models;

import lombok.Data;

@Data
public class Responded_Applicants {
    private Integer id;
    private Integer resume_id;
    private Integer vacancy_id;
    private Boolean confirmation;

}
