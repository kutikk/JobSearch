package kg.attractor.jobsearch.service.impl;

import kg.attractor.jobsearch.dao.ProfileDao;
import kg.attractor.jobsearch.dto.ProfileDto;
import kg.attractor.jobsearch.exceptions.UserNotFoundException;
import kg.attractor.jobsearch.models.Users;
import kg.attractor.jobsearch.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ProfileDao profileDao;

   @Override
   public ProfileDto getProfileById(int profile_id) throws UserNotFoundException {
        Users users =  profileDao.getProfileById(profile_id)
                .orElseThrow(UserNotFoundException::new);
        return ProfileDto.builder()
                .id(users.getId())
                .user_name(users.getUser_name())
                .email(users.getEmail())
                .password(users.getPassword())
                .phone_number(users.getPhone_number())
                .avatar(users.getAvatar())
                .age(users.getAge())
                .account_type(users.getAccount_type())
                .build();
    }

    @Override
    public ProfileDto updateProfile(int id, ProfileDto profileDto) throws UserNotFoundException {
       Users users = profileDao.getProfileById(id)
               .orElseThrow(UserNotFoundException::new);
       users.setUser_name(profileDto.getUser_name());
       users.setEmail(profileDto.getEmail());
       users.setPassword(profileDto.getPassword());
       users.setPhone_number(profileDto.getPhone_number());
       users.setAvatar(profileDto.getAvatar());
       users.setAge(profileDto.getAge());
       users.setAccount_type(profileDto.getAccount_type());
       users.setPassword(profileDto.getPassword());

       profileDao.updateProfile(users);

       return ProfileDto.builder()
               .id(users.getId())
               .user_name(users.getUser_name())
               .email(users.getEmail())
               .password(users.getPassword())
               .phone_number(users.getPhone_number())
               .avatar(users.getAvatar())
               .age(users.getAge())
               .account_type(users.getAccount_type())

               .build();
    }


}
