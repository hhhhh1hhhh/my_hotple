package restaurant.restaurant.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import restaurant.restaurant.dto.CommentDTO;
import restaurant.restaurant.dto.LikesDTO;
import restaurant.restaurant.entity.CommentEntity;
import restaurant.restaurant.service.AuthService;
import restaurant.restaurant.service.CommentService;
import restaurant.restaurant.service.LikesService;


import java.util.List;


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
