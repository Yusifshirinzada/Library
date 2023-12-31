package az.developia.librarysystemyusif.security.auth;

import az.developia.librarysystemyusif.entity.Role;
import az.developia.librarysystemyusif.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class CustomUserDetails implements UserDetails {

    private String username;
    private String password;
    private List<GrantedAuthority> roles;

    public CustomUserDetails(User user) {
            this.username=user.getUsername();
            this.password=user.getPassword();

            List<Role> userRole=new ArrayList<>();
            userRole.add(user.getRole());
            this.roles=userRole.stream().map((role -> new SimpleGrantedAuthority(role.getName()))).collect(Collectors.toList());

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return roles;

    }

    @Override
    public String getPassword() {

        return password;
    }

    @Override
    public String getUsername() {

        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
