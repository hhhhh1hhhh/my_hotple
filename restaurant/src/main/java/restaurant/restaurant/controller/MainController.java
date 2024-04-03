package restaurant.restaurant.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import restaurant.restaurant.auth.service.AuthService;


@Controller
@RequiredArgsConstructor
public class MainController {

    private final AuthService authService;

    @GetMapping("/")
    public String MainP(Model model) {
        authService.setUserData(model);
        return "main";
    }


}
