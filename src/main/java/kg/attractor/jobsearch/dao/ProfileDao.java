package kg.attractor.jobsearch.dao;

import kg.attractor.jobsearch.dto.ProfileDto;
import kg.attractor.jobsearch.models.Resumes;
import kg.attractor.jobsearch.models.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProfileDao {
    private final JdbcTemplate jdbcTemplate;


    public Optional<Users> getProfileById(int  profile_id){
        String sql = "select * from users where id like ? LIMIT 1";
        Users user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Users.class),profile_id);
        return Optional.ofNullable(user);
    }


    public void  updateProfile(Users users){
        String sql ="UPDATE users SET user_name = ?, email = ?,password = ?, phone_number = ?, avatar = ?,age = ?, account_type = ? WHERE id = ?; ";
        jdbcTemplate.update(sql,
                users.getUser_name(),
                users.getEmail(),
                users.getPassword(),
                users.getPhone_number(),
                users.getAvatar(),
                users.getAge(),
                users.getAccount_type(),
                users.getId());
    }
}
