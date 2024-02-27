package restaurant.restaurant.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import restaurant.restaurant.service.AuthService;



@Controller
public class MainController {

    private final AuthService authService;

    public MainController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/")
    public String NotLoggedMainP() {

        return "not_logged_main";
    }


    @GetMapping("/main")
    public String LoggedMainP(Model model) {
        authService.setUserData(model);
        return "logged_main";
    }

}
