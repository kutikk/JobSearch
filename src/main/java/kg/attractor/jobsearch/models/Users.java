package kg.attractor.jobsearch.models;

import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

@Data
public class Users {
    private Integer id;
    private String user_name;
    private String email;
    private String password;
    private String phone_number;
    private String avatar;
    private Integer age;
    private String account_type;
    private Integer resumesID;

    public Users() {
    }

    public Users(Integer id, String user_name, String email, String password, String phone_number,
                 String avatar, Integer age, String account_type, Integer resumesID) {
        this.id = id;
        this.user_name = user_name;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.avatar = avatar;
        this.age = age;
        this.account_type = account_type;
        this.resumesID = resumesID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return user_name;
    }

    public void setName(String name) {
        this.user_name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public Integer getResumesID() {
        return resumesID;
    }

    public void setResumesID(Integer resumesID) {
        this.resumesID = resumesID;
    }

}
