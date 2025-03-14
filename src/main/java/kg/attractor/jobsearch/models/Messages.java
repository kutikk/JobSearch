package kg.attractor.jobsearch.models;

import java.time.LocalDateTime;

public class Messages {
    private Integer id;
    private Integer responded_applicants;
    private String content;
   private LocalDateTime timestamp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getResponded_applicants() {
        return responded_applicants;
    }

    public void setResponded_applicants(Integer responded_applicants) {
        this.responded_applicants = responded_applicants;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
