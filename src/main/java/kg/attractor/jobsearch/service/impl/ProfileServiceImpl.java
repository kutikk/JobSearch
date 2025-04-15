package kg.attractor.jobsearch.service.impl;

import kg.attractor.jobsearch.dao.ProfileDao;
import kg.attractor.jobsearch.dao.ResumeDao;
import kg.attractor.jobsearch.dto.ProfileDto;
import kg.attractor.jobsearch.exceptions.UserNotFoundException;
import kg.attractor.jobsearch.models.Resumes;
import kg.attractor.jobsearch.models.Users;
import kg.attractor.jobsearch.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ProfileDao profileDao;
    private final ResumeDao resumeDao;

    @Override
    public ProfileDto getProfileById(long profile_id) {
        Optional<Users> optionalUser = profileDao.getProfileById(profile_id);
        if (optionalUser.isEmpty()) {
            return null;
        }
        Users users = optionalUser.get();
        List<Resumes> resumes;
        try {
            resumes = resumeDao.getAllResumesByApplicantId(profile_id);
        } catch (Exception e) {
            resumes = Collections.emptyList();
        }
        return ProfileDto.builder()
                .id(users.getId())
                .user_name(users.getUser_name())
                .email(users.getEmail())
                .password(users.getPassword())
                .phone_number(users.getPhone_number())
                .avatar(users.getAvatar())
                .age(users.getAge())
                .account_type(users.getAccount_type())
                .resumes(resumes)
                .build();
    }

    @Override
    public long getIdByUsername(String username) {
        try {
            return profileDao.getIdByUsername(username);
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public void updateProfileWithFile(Long userId, String name, String phone, int age, MultipartFile avatarFile) {
        try {
            Users user = profileDao.getProfileByIdc(userId);
            if (user == null) return;

            user.setUser_name(name);
            user.setPhone_number(phone);
            user.setAge(age);

            avatarSave(avatarFile, user);
            profileDao.updateProfile(user);
        } catch (Exception e) {
        }
    }

    @Override
    public String createProfile(ProfileDto profileDto, MultipartFile avatarFile) {
        try {
            if (profileDto == null || profileDto.getUser_name() == null) {
                return null;
            }
            if (profileDao.getIdByUsername(profileDto.getUser_name()) != null) {
                return null;
            }
            Users user = new Users();
            user.setUser_name(profileDto.getUser_name());
            user.setEmail(profileDto.getEmail());
            user.setPassword(profileDto.getPassword());
            user.setPhone_number(profileDto.getPhone_number());
            user.setAge(profileDto.getAge());
            user.setAccount_type(profileDto.getAccount_type());

            avatarSave(avatarFile, user);
            profileDao.saveProfile(user);

            return "/success";
        } catch (Exception e) {
            return null;
        }
    }

    private void avatarSave(MultipartFile avatarFile, Users user) {
        if (avatarFile != null && !avatarFile.isEmpty() && user != null) {
            try {
                String filename = avatarFile.getOriginalFilename();
                String uploadDir = System.getProperty("user.dir") + "/uploads/";
                File uploadPath = new File(uploadDir);
                if (!uploadPath.exists()) {
                    uploadPath.mkdirs();
                }
                File dest = new File(uploadDir + filename);
                avatarFile.transferTo(dest);
                user.setAvatar(filename);
            } catch (IOException e) {
            }
        }
    }
}
