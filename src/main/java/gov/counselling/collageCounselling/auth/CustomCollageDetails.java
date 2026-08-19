package gov.counselling.collagecounselling.auth;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import gov.counselling.collagecounselling.entity.Collage;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


public class CustomCollageDetails implements UserDetails {

    private Collage collage;

    public CustomCollageDetails(Collage collage){
        this.collage=collage;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public @Nullable String getPassword() {
        return collage.getPassword();
    }

    @Override
    public String getUsername() {
        return collage.getCode();
    }
}
