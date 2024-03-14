package restaurant.restaurant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import restaurant.restaurant.service.AuthService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mypage")
public class MypageController {

    private final AuthService authService;

    @GetMapping("")
    public String MypageP(Model model) {
        authService.setUserData(model);
        return "mypage";
    }


}
