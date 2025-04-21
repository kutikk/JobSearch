package kg.attractor.jobsearch.service.interfaces;

import kg.attractor.jobsearch.dto.UserDto;
import kg.attractor.jobsearch.exceptions.UserNotFoundException;
import org.springframework.security.core.parameters.P;
import org.springframework.web.multipart.MultipartFile;

import java.awt.print.Pageable;
import java.io.IOException;

public interface ProfileService {
    UserDto getProfileById(String profile_id,int page,int size) throws UserNotFoundException;


    void updateProfileWithFile( String name,String email, String phone, int age, MultipartFile avatarFile) throws IOException;

    String createProfile(UserDto userDto, MultipartFile avatarFile);

    UserDto getPublicProfileById(String email);
}
