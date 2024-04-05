package restaurant.restaurant.comment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import restaurant.restaurant.comment.dto.CommentDTO;
import restaurant.restaurant.comment.service.CommentService;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;


    @PostMapping("/save")
    public ResponseEntity save(@ModelAttribute CommentDTO commentDTO) {
        System.out.println("commentDTO = " + commentDTO);
        Integer saveResult = commentService.save(commentDTO);

        if (saveResult != null) {
           List<CommentDTO> commentDTOList = commentService.findAll(commentDTO.getMyplaceId());
            return new ResponseEntity<>(commentDTOList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("해당 게시글이 존재하지 않습니다.", HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<CommentDTO> editComment(@PathVariable int id, @RequestParam String commentContents) {
        // 댓글 수정 로직 수행
        CommentDTO commentDTO = commentService.editComment(id, commentContents);

        if (commentDTO != null) {
            // 댓글이 성공적으로 수정되었을 때 수정된 댓글 반환
            return ResponseEntity.ok(commentDTO);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @DeleteMapping("/delete/{id}")
    public String commentDel(@PathVariable int id) {
        int myplaceId = commentService.deleteAndGetMyplaceId(id);

        if (myplaceId != -1) {
            return "redirect:/shared/" + myplaceId;
        } else {
            return "redirect:/shared/";
        }
    }

}
