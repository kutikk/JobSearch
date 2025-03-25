package kg.attractor.jobsearch.dao;

import kg.attractor.jobsearch.models.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.awt.desktop.OpenFilesEvent;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    public List<Users> getUsers(){
        String sql = "select * from users";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Users.class));
    };
    public Optional<Users> getUsersByPhoneNumber(String phoneNumber){
        String sql = "select * from users where phoneNumber like ?  LIMIT 1";
            Users user = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Users.class),phoneNumber);
        return Optional.ofNullable(user);
    }
    public Optional<Users> getUsersByName(String name){
        String sql = "select * from users where user_name like ? ";
        Users user = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Users.class),name);
        return Optional.ofNullable(user);
    }
    public Optional<Users> getUsersByEmail(String email){
        String sql = "select * from users where email like ?  LIMIT 1";
        Users user = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Users.class),email);
        return Optional.ofNullable(user);
    }


}
