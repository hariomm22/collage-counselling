package gov.counselling.collagecounselling.auth;

import gov.counselling.collagecounselling.entity.UserAccount;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import gov.counselling.collagecounselling.entity.Collage;

import java.util.Collection;
import java.util.List;


public class CustomUserAccountDetails implements UserDetails {

    private UserAccount userAccount;

    public CustomUserAccountDetails(UserAccount userAccount){
        this.userAccount=userAccount;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return userAccount.getRole()
               .stream()
               .map(role->new SimpleGrantedAuthority("ROLE_"+role))
               .toList();
    }

    @Override
    public @Nullable String getPassword() {
        return userAccount.getPassword();
    }

    @Override
    public String getUsername() {
        return userAccount.getUserName();
    }

    @Override
    public boolean isEnabled(){
        return userAccount.isEnabled();
    }
}
