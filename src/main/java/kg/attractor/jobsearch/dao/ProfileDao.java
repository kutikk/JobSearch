package kg.attractor.jobsearch.dao;

import kg.attractor.jobsearch.dto.ProfileDto;
import kg.attractor.jobsearch.exceptions.UserNotFoundException;
import kg.attractor.jobsearch.models.Resumes;
import kg.attractor.jobsearch.models.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProfileDao {
    private final JdbcTemplate jdbcTemplate;


    public Optional<Users> getProfileById(long profile_id){
        String sql = "select * from users where id like ? LIMIT 1";
        Users user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Users.class),profile_id);
        return Optional.ofNullable(user);

    }
    public Users getProfileByIdc(long profile_id){
        String sql = "select * from users where id like ? LIMIT 1";
       return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Users.class),profile_id);

    }


    public void  updateProfile(Users users){
        String sql ="UPDATE users SET user_name = ?, phone_number = ?, avatar = ?, age = ? WHERE id = ?; ";
        jdbcTemplate.update(sql,
                users.getUser_name(),
                users.getPhone_number(),
                users.getAvatar(),
                users.getAge(),
                users.getId());
    }

    public Long getIdByUsername(String username) {
        try {
            String sql = "SELECT id FROM users WHERE user_name = ? LIMIT 1";
            return jdbcTemplate.queryForObject(sql, Long.class, username);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public void saveProfile(Users users){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(users.getPassword());
        String sql1 = "insert into authorities(user_id,authority) values (?,?);";
        String sql = "insert into users (user_name, email, password, phone_number, avatar, age, account_type, enabled) " +
                "values (?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,
                users.getUser_name(),
                users.getEmail(),
                hashedPassword,
                users.getPhone_number(),
                users.getAvatar(),
                users.getAge(),
                users.getAccount_type(),
                true);
          Long id =  getIdByUsername(users.getUser_name());
          jdbcTemplate.update(sql1,id,"ROLE_USER");

    }

}
