package restaurant.restaurant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import restaurant.restaurant.dto.LikesDTO;
import restaurant.restaurant.service.LikesService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/like")
public class LikesController {

    private final LikesService likesService;


    @PostMapping("/add")
    public ResponseEntity<String> addLike(@RequestBody LikesDTO likesDTO) {
        int userId = likesDTO.getUserId();
        int myplaceId = likesDTO.getMyplaceId();

        boolean isLiked = likesService.isLikedByUser(userId, myplaceId);

        if (!isLiked) {
            likesService.saveLike(likesDTO);
            return ResponseEntity.ok("Like added successfully");
        } else {
            likesService.deleteLike(userId, myplaceId);
            return ResponseEntity.ok("Like removed successfully");
        }
    }
}
