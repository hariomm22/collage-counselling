package gov.counselling.collagecounselling.auth;

import gov.counselling.collagecounselling.reposistory.CollageReposistory;
import gov.counselling.collagecounselling.entity.Collage;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomCollageDetailsService implements UserDetailsService {

    private CollageReposistory collageReposistory;

    public CustomCollageDetailsService(CollageReposistory collageReposistory){
        this.collageReposistory = collageReposistory;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        Collage collage = collageReposistory.findByCode(username);

        if (collage == null) {
            throw new UsernameNotFoundException(
                    "Collage not found with code: " + username
            );
        }

        return new CustomCollageDetails(collage);
    }
}
