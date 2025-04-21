package kg.attractor.jobsearch.service.impl;


import kg.attractor.jobsearch.dto.UserDto;
import kg.attractor.jobsearch.exceptions.ProfileAlreadyExistsException;
import kg.attractor.jobsearch.models.Resumes;
import kg.attractor.jobsearch.models.Role;
import kg.attractor.jobsearch.models.Users;
import kg.attractor.jobsearch.models.Vacancies;
import kg.attractor.jobsearch.repository.ResumeRepository;
import kg.attractor.jobsearch.repository.RoleRepository;
import kg.attractor.jobsearch.repository.UserRepository;
import kg.attractor.jobsearch.repository.VacanciesRepository;
import kg.attractor.jobsearch.service.interfaces.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final VacanciesRepository vacanciesRepository;
    private final UserRepository userRepository;
    private final ResumeRepository resumeRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Override
    public UserDto getProfileById(String email, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());

        Users users = userRepository.findById(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (users.getAccount_type().equals("APPLICANT")) {
            Page<Resumes> resumesPage = (Page<Resumes>) resumeRepository.findByApplicantEmail(email, pageable);

            return UserDto.builder()
                    .user_name(users.getUser_name())
                    .email(users.getEmail())
                    .password(users.getPassword())
                    .phone_number(users.getPhone_number())
                    .avatar(users.getAvatar())
                    .age(users.getAge())
                    .account_type(users.getAccount_type())
                    .resumes(resumesPage)
                    .totalPages(resumesPage.getTotalPages())
                    .totalElements(resumesPage.getTotalElements())
                    .build();
        } else {
            Page<Vacancies> vacanciesPage = (Page<Vacancies>) vacanciesRepository.findAllByAuthorEmail(email, pageable);

            return UserDto.builder()
                    .user_name(users.getUser_name())
                    .email(users.getEmail())
                    .password(users.getPassword())
                    .phone_number(users.getPhone_number())
                    .avatar(users.getAvatar())
                    .age(users.getAge())
                    .account_type(users.getAccount_type())
                    .vacancies(vacanciesPage)
                    .totalPages(vacanciesPage.getTotalPages())
                    .totalElements(vacanciesPage.getTotalElements())
                    .build();
        }
    }




    @Override
    public void updateProfileWithFile( String name,String email, String phone, int age, MultipartFile avatarFile) {
        try {
            Users user = userRepository.findById(name).get();
            user.setUser_name(email);
            user.setPhone_number(phone);
            user.setAge(age);
            avatarSave(avatarFile, user);
            userRepository.save(user);
        } catch (Exception e) {
            throw new ProfileAlreadyExistsException("Ошибка при редактировании профиля");
        }
    }

    @Override
    public String createProfile(UserDto userDto, MultipartFile avatarFile) {
        String hashPass = passwordEncoder.encode(userDto.getPassword());
        Users user = new Users();
        user.setUser_name(userDto.getUser_name());
        user.setEmail(userDto.getEmail());
        user.setPassword(hashPass);
        user.setPhone_number(userDto.getPhone_number());
        user.setAge(userDto.getAge());
        user.setAccount_type(userDto.getAccount_type());
        user.setEnabled(true);
        avatarSave(avatarFile, user);
        Role role = roleRepository.findByRoleName(userDto.getAccount_type());
        user.setRoles(List.of(role));
        userRepository.save(user);
        return "/success";
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

    @Override
    public UserDto getPublicProfileById(String email) {
        Optional<Users> optionalUser = userRepository.findById(email);
        if (optionalUser.isEmpty()) {
            return null;
        }
        Users users = optionalUser.get();
            return UserDto.builder()
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
