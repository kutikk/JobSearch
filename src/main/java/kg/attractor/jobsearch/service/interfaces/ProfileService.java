package kg.attractor.jobsearch.service.interfaces;

import kg.attractor.jobsearch.dto.UserDto;
import kg.attractor.jobsearch.exceptions.UserNotFoundException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProfileService {
    UserDto getProfileById(long profile_id) throws UserNotFoundException;

    long getIdByUsername(String username) ;

    void updateProfileWithFile(Long userId, String name, String phone, int age, MultipartFile avatarFile) throws IOException;

    String createProfile(UserDto userDto, MultipartFile avatarFile);
}
