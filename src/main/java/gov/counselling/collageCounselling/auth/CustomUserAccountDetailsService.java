package gov.counselling.collagecounselling.auth;

import gov.counselling.collagecounselling.entity.UserAccount;
import gov.counselling.collagecounselling.reposistory.UserAccountReposistory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserAccountDetailsService implements UserDetailsService {

    private final UserAccountReposistory userAccountReposistory;

    public CustomUserAccountDetailsService(UserAccountReposistory userAccountReposistory){
        this.userAccountReposistory = userAccountReposistory;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        UserAccount userAccount = userAccountReposistory.findByUserName(username);

        if (userAccount == null) {
            throw new UsernameNotFoundException(
                    "User/Account not found with code: " + username
            );
        }
        return new CustomUserAccountDetails(userAccount);
    }
}
