package kg.attractor.jobsearch.service;

import kg.attractor.jobsearch.dto.ProfileDto;
import kg.attractor.jobsearch.exceptions.UserNotFoundException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProfileService {
    ProfileDto getProfileById(long profile_id) throws UserNotFoundException;

    long getIdByUsername(String username) ;

    void updateProfileWithFile(Long userId, String name, String phone, int age, MultipartFile avatarFile) throws IOException;

    String createProfile(ProfileDto profileDto, MultipartFile avatarFile) throws IOException;
}
