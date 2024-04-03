package restaurant.restaurant.auth.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import restaurant.restaurant.user.dto.CustomUserDetails;
import restaurant.restaurant.user.entity.UserEntity;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.Function;

@Service
public class AuthService {

    public void setUserData(Model model) {
        String username = getUserName();
        String role = getUserRole();
        String nickname = getNickName();
        int id = getUserId();

        model.addAttribute("username", username);
        model.addAttribute("role", role);
        model.addAttribute("nickname", nickname);
        model.addAttribute("id", id);

    }


    private String getUserName() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    private String getUserRole() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Iterator<? extends GrantedAuthority> iter = authorities.iterator();
        GrantedAuthority auth = iter.next();
        return auth.getAuthority();
    }


    private String getNickName() {
        return getUserEntityPropertyAsString(UserEntity::getNickname);
    }

    private int getUserId() {
        String userIdAsString = getUserEntityPropertyAsString(userEntity -> String.valueOf(userEntity.getId()));
        return (userIdAsString != null) ? Integer.parseInt(userIdAsString) : 0;
    }


    private String getUserEntityPropertyAsString(Function<UserEntity, String> propertyExtractor) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof CustomUserDetails) {
                UserEntity userEntity = ((CustomUserDetails) principal).getUserEntity();
                if (userEntity != null) {
                    return propertyExtractor.apply(userEntity);
                }
            }
        }
        return null;
    }

}