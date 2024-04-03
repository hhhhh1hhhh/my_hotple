package restaurant.restaurant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import restaurant.restaurant.comment.dto.CommentDTO;
import restaurant.restaurant.likes.dto.LikesDTO;
import restaurant.restaurant.auth.service.AuthService;
import restaurant.restaurant.comment.service.CommentService;
import restaurant.restaurant.likes.service.LikesService;

import java.util.List;

@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MypageController {

    private final AuthService authService;
    private final CommentService commentService;
    private final LikesService likesService;

    @GetMapping("")
    public String MypageP(Model model) {
        authService.setUserData(model);
        String useremail = (String) model.getAttribute("username");
        int userId = (int) model.getAttribute("id");

        List<CommentDTO> commentList = commentService.findCommentsByWriterEmail(useremail);
        List<LikesDTO> likesList = likesService.findLikesByUserId(userId);

        model.addAttribute("commentList", commentList);
        model.addAttribute("likesList", likesList);

        return "mypage";
    }
}
