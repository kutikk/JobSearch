package kg.attractor.jobsearch.service.interfaces;

import kg.attractor.jobsearch.dto.EmployerDto;

import java.util.List;

public interface EmployerService {
    List<EmployerDto> getEmployers();

    EmployerDto getEmployerByName(String name);

    EmployerDto getEmployerByPhoneNumber(String phoneNumber);

    EmployerDto getEmployerByEmail(String email);
}
