package kg.attractor.jobsearch.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Work_Experience_Info_Dto {
    private Long id;
    private Integer years;
    private String company_name;
    private String position;
    private String responsibilities;
    private Long resume_id;
}
