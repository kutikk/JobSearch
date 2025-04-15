package kg.attractor.jobsearch.models;

import kg.attractor.jobsearch.dto.Education_InfoDto;
import kg.attractor.jobsearch.dto.Work_Experience_Info_Dto;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Resumes {
    private Integer id;
    private String name;
    private Integer categoryId;
    private Float salary;
    private boolean is_active;
    private LocalDateTime update_time;
    private LocalDateTime created_date;
    private Integer applicant_id;
    private List<Education_InfoDto> education_info;
    private  List<Work_Experience_Info_Dto> work_experience_info;



    public Resumes(Integer applicant_id, String name, Integer categoryId,
                   Float salary, boolean is_active, LocalDateTime update_time, LocalDateTime created_date, Integer id) {
        this.applicant_id = applicant_id;
        this.name = name;
        this.categoryId = categoryId;
        this.salary = salary;
        this.is_active = is_active;
        this.update_time = update_time;
        this.created_date = created_date;
        this.id = id;
    }
    public Resumes() {
    }


}
