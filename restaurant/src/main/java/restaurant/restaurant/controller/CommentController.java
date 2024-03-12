package restaurant.restaurant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import restaurant.restaurant.dto.CommentDTO;
import restaurant.restaurant.entity.CommentEntity;
import restaurant.restaurant.service.CommentService;

import java.util.List;
import java.util.Optional;

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
            // 작성 성공하면 댓글 목록을 가져와서 리턴
            // 댓글목록: 해당 게시글의 댓글 전체
           List<CommentDTO> commentDTOList = commentService.findAll(commentDTO.getMyplaceId());
            return new ResponseEntity<>(commentDTOList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("해당 게시글이 존재하지 않습니다.", HttpStatus.NOT_FOUND);
        }

    }


    // 댓글 수정 페이지로 이동
//    @GetMapping("/edit/{id}")
//    public String commentEditForm(@PathVariable int id, Model model) {
//        CommentDTO commentDTO = commentService.findByCommentId(id);
//
//        model.addAttribute("commentEdit", commentDTO);
//
//        return "myplace/edit";
//    }
//
//
//    @PostMapping("/edit/{id}")
//    public String editComment(@PathVariable int id, @RequestParam String commentContents) {
//
//        CommentDTO commentDTO = commentService.editComment(id, commentContents);
//
//        if (commentDTO != null) {
//            return "redirect:/shared/" + commentDTO.getMyplaceId();
//        } else {
//            return "redirect:/shared/" + commentDTO.getMyplaceId();
//        }
//    }


    // CommentController의 editComment 메서드 수정
    @PostMapping("/edit/{id}")
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


    @GetMapping("/delete/{id}")
    public String commentDel(@PathVariable int id) {
        int myplaceId = commentService.deleteAndGetMyplaceId(id);

        if (myplaceId != -1) {
            return "redirect:/shared/" + myplaceId;
        } else {
            return "redirect:/sgared/";
        }
    }

}
