package restaurant.restaurant.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import restaurant.restaurant.dto.CustomUserDetails;
import restaurant.restaurant.entity.UserEntity;
import restaurant.restaurant.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserEntity userData = userRepository.findByEmail(email);

        if (userData != null) {
            return new CustomUserDetails(userData);
        }

        return null;
    }
}
