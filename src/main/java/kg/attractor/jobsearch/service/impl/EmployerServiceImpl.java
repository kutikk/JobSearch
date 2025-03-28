package kg.attractor.jobsearch.service.impl;

import kg.attractor.jobsearch.dao.UserDao;
import kg.attractor.jobsearch.dto.EmployerDto;
import kg.attractor.jobsearch.exceptions.UserNotFoundException;
import kg.attractor.jobsearch.models.Users;
import kg.attractor.jobsearch.service.EmployerService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployerServiceImpl implements EmployerService {
    private final UserDao userDao;

    @Override
    public List<EmployerDto> getEmployers(){
     List<Users> list = userDao.getUsers();
     return list.stream()
             .map(e -> EmployerDto.builder()
                     .id(e.getId())
                     .user_name(e.getName())
                     .email(e.getEmail())
                     .password(e.getPassword())
                     .phone_number(e.getPhone_number())
                     .avatar(e.getAvatar())
                     .age(e.getAge())
                     .account_type(e.getAccount_type())
                     .resumesID(e.getResumesID())
                     .build())
             .toList();

    }
@SneakyThrows
@Override
public EmployerDto getEmployerByName(String name){
      Users user = userDao.getUsersByName(name)
              .orElseThrow(UserNotFoundException::new);
      return EmployerDto.builder()
              .id(user.getId())
              .user_name(user.getName())
              .email(user.getEmail())
              .password(user.getPassword())
              .phone_number(user.getPhone_number())
              .avatar(user.getAvatar())
              .age(user.getAge())
              .account_type(user.getAccount_type())
              .resumesID(user.getResumesID())
              .build();
    }
@SneakyThrows
@Override
public EmployerDto getEmployerByPhoneNumber(String phoneNumber){
        Users user = userDao.getUsersByPhoneNumber(phoneNumber)
                .orElseThrow(UserNotFoundException::new);
        return EmployerDto.builder()
                .id(user.getId())
                .user_name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .phone_number(user.getPhone_number())
                .avatar(user.getAvatar())
                .age(user.getAge())
                .account_type(user.getAccount_type())
                .resumesID(user.getResumesID())
                .build();
    }
    @SneakyThrows
    @Override
    public EmployerDto getEmployerByEmail(String email){
        Users user = userDao.getUsersByEmail(email)
                .orElseThrow(UserNotFoundException::new);
        return EmployerDto.builder()
                .id(user.getId())
                .user_name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .phone_number(user.getPhone_number())
                .avatar(user.getAvatar())
                .age(user.getAge())
                .account_type(user.getAccount_type())
                .resumesID(user.getResumesID())
                .build();
    }


}
