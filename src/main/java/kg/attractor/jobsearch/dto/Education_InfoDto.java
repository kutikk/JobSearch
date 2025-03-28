package kg.attractor.jobsearch.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Education_InfoDto {
    private Integer id;
    private String institution;
    private String program;
    private LocalDate start_date;
    private LocalDate end_date;
    private String degree;
    private Integer resume_id ;
}
