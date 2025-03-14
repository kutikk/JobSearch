package kg.attractor.jobsearch.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Vacancies {
    private Integer id;
    private String name;
    private String description;
    private Integer category_id;
    private Float salary;
    private Integer exp_from;
    private Integer exp_to;
    private Boolean is_active;
    private Integer author_id;
    private LocalDateTime created_date;
    private LocalDateTime update_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Integer getExp_from() {
        return exp_from;
    }

    public void setExp_from(Integer exp_from) {
        this.exp_from = exp_from;
    }

    public Integer getExp_to() {
        return exp_to;
    }

    public void setExp_to(Integer exp_to) {
        this.exp_to = exp_to;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public LocalDateTime getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(LocalDateTime update_time) {
        this.update_time = update_time;
    }

    public LocalDateTime getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDateTime created_date) {
        this.created_date = created_date;
    }
}
