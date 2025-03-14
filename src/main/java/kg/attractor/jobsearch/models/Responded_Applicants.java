package kg.attractor.jobsearch.models;

public class Responded_Applicants {
    private Integer id;
    private Integer resume_id;
    private Integer vacation_id;
    private Boolean confirmation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getResume_id() {
        return resume_id;
    }

    public void setResume_id(Integer resume_id) {
        this.resume_id = resume_id;
    }

    public Integer getVacation_id() {
        return vacation_id;
    }

    public void setVacation_id(Integer vacation_id) {
        this.vacation_id = vacation_id;
    }

    public Boolean getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(Boolean confirmation) {
        this.confirmation = confirmation;
    }
}
