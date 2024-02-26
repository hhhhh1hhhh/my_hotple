package restaurant.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import restaurant.restaurant.service.AuthService;

@Controller
public class MyplaceController {


    private final AuthService authService;

    public MyplaceController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/myplace")
    public String myplaceP(Model model) {
        authService.setUserData(model);
        return "myplace";
    }

}
