package kg.attractor.jobsearch.service.impl;

import kg.attractor.jobsearch.dao.ProfileDao;
import kg.attractor.jobsearch.dao.ResumeDao;
import kg.attractor.jobsearch.dto.UserDto;
import kg.attractor.jobsearch.exceptions.ProfileAlreadyExistsException;
import kg.attractor.jobsearch.models.Resumes;
import kg.attractor.jobsearch.models.Users;
import kg.attractor.jobsearch.models.Vacancies;
import kg.attractor.jobsearch.repository.VacanciesRepository;
import kg.attractor.jobsearch.service.interfaces.ProfileService;
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
    private final VacanciesRepository vacanciesRepository;

    @Override
    public UserDto getProfileById(long profile_id) {
        Optional<Users> optionalUser = profileDao.getProfileById(profile_id);
        if (optionalUser.isEmpty()) {
            return null;
        }

        Users users = optionalUser.get();
        if(users.getAccount_type().equals("applicant")) {
            List<Resumes> resumes;
            try {
                resumes = resumeDao.getAllResumesByApplicantId(profile_id);

            } catch (Exception e) {
                resumes = Collections.emptyList();
            }
            return UserDto.builder()
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
        else {
            List<Vacancies> vacancies;
            try {
                vacancies = vacanciesRepository.findAllByAuthor_Id(profile_id);
            } catch (Exception e) {
                vacancies = Collections.emptyList();
            }
            return UserDto.builder()
                    .id(users.getId())
                    .user_name(users.getUser_name())
                    .email(users.getEmail())
                    .password(users.getPassword())
                    .phone_number(users.getPhone_number())
                    .avatar(users.getAvatar())
                    .age(users.getAge())
                    .account_type(users.getAccount_type())
                    .vacancies(vacancies)
                    .build();
        }

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
    public void updateProfileWithFile(Long userId, String email, String phone, int age, MultipartFile avatarFile) {
        try {
            Users user = profileDao.getProfileByIdc(userId);
            if (user == null) return;

            user.setEmail(email);
            user.setPhone_number(phone);
            user.setAge(age);
            avatarSave(avatarFile, user);
            profileDao.updateProfile(user);
        } catch (Exception e) {
            throw new ProfileAlreadyExistsException("Ошибка при редактировании профиля");
        }
    }

    @Override
    public String createProfile(UserDto userDto, MultipartFile avatarFile) {
        if (profileDao.getIdByUsername(userDto.getUser_name()) != null) {
            throw new ProfileAlreadyExistsException("Профиль с таким именем уже существует.");
        }
        try {
            Users user = new Users();
            user.setUser_name(userDto.getUser_name());
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
            user.setPhone_number(userDto.getPhone_number());
            user.setAge(userDto.getAge());
            user.setAccount_type(userDto.getAccount_type());

            avatarSave(avatarFile, user);
            profileDao.saveProfile(user);

            return "/success";
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при создании профиля", e);
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
