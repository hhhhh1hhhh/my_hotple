package restaurant.restaurant.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import restaurant.restaurant.dto.CommentDTO;
import restaurant.restaurant.entity.CommentEntity;
import restaurant.restaurant.service.AuthService;
import restaurant.restaurant.service.CommentService;


import java.util.List;


@Controller
@RequiredArgsConstructor
public class MainController {

    private final AuthService authService;
    private final CommentService commentService;


    @GetMapping("/")
    public String MainP(Model model) {
        authService.setUserData(model);
        return "main";
    }

    @GetMapping("/mypage")
    public String MypageP(Model model) {
        authService.setUserData(model);
        String useremail = (String) model.getAttribute("username");

        List<CommentDTO> commentList = commentService.findCommentsByWriterEmail(useremail);

        model.addAttribute("commentList", commentList);

        return "mypage";
    }


}
