package kg.attractor.jobsearch.models;

import java.time.LocalDateTime;

public class Resumes {
    private Integer id;
    private String name;
    private Integer categoryId;
    private Float salary;
    private boolean is_active;
    private LocalDateTime update_time;
    private LocalDateTime created_date;
    private Integer applicant_id;


    public Integer getApplicant_id() {
        return applicant_id;
    }

    public void setApplicant_id(Integer applicant_id) {
        this.applicant_id = applicant_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public LocalDateTime getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(LocalDateTime update_time) {
        this.update_time = update_time;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public LocalDateTime getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDateTime created_date) {
        this.created_date = created_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
}
