package kg.attractor.jobsearch.service;

import kg.attractor.jobsearch.dto.ProfileDto;
import kg.attractor.jobsearch.exceptions.UserNotFoundException;

public interface ProfileService {
    ProfileDto getProfileById(int profile_id) throws UserNotFoundException;

    ProfileDto updateProfile(int id, ProfileDto profileDto) throws UserNotFoundException;
}
