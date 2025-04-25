    package kg.attractor.jobsearch.service.impl;
    import kg.attractor.jobsearch.models.Authority;
    import kg.attractor.jobsearch.models.Role;
    import kg.attractor.jobsearch.models.Users;
    import kg.attractor.jobsearch.repository.UserRepository;
    import lombok.RequiredArgsConstructor;
    import org.springframework.security.core.GrantedAuthority;
    import org.springframework.security.core.authority.SimpleGrantedAuthority;
    import org.springframework.security.core.userdetails.UserDetails;
    import org.springframework.security.core.userdetails.UserDetailsService;
    import org.springframework.security.core.userdetails.UsernameNotFoundException;
    import org.springframework.stereotype.Service;

    import java.util.ArrayList;
    import java.util.Collection;
    import java.util.List;

    @Service
    @RequiredArgsConstructor
    public class AuthUserDetailsService implements UserDetailsService {

        private final UserRepository userRepository;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Users user = userRepository.findByEmail(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));

            return new org.springframework.security.core.userdetails.User(
                    user.getEmail(),
                    user.getPassword(),
                    user.getEnabled(),
                    true,
                    true,
                    true,
                    getAuthorities(user.getRoles())
            );

        }

        private Collection<GrantedAuthority> getAuthorities(Collection<Role> roles) {
            return getGrantedAuthorities(getPrivileges(roles));
        }

        private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            for (String privilege : privileges) {
                authorities.add(new SimpleGrantedAuthority(privilege));
            }
            return authorities;
        }

        private List<String> getPrivileges(Collection<Role> roles) {
            List<String> privileges = new ArrayList<>();
            List<Authority> collection = new ArrayList<>();

            for (Role role : roles) {
                privileges.add(role.getRoleName());
                collection.addAll(role.getAuthorities());
            }
            for (Authority authority : collection) {
                privileges.add(authority.getAuthorityName());
            }
            return privileges;
        }
    }