package restaurant.restaurant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import restaurant.restaurant.dto.CommentDTO;
import restaurant.restaurant.dto.MyplaceDTO;
import restaurant.restaurant.service.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/myplace")
public class MyplaceController {

    private final AuthService authService;
    private final MyplaceService myplaceService;
    private final SharedService sharedService;
    private final CommentService commentService;
    private final MyplaceFileService myplaceFileService;


    @GetMapping("/list")
    public String paging(@PageableDefault(page = 1) Pageable pageable, Model model) {
        authService.setUserData(model);

        pageable.getPageNumber();
        Page<MyplaceDTO> myplaceDTOPage = myplaceService.paging(pageable, model);

        int blockLimit = 5;
        int startPage = (((int)(Math.ceil((double)pageable.getPageNumber() / blockLimit))) - 1) * blockLimit + 1;
        int endPage = ((startPage + blockLimit - 1) < myplaceDTOPage.getTotalPages()) ? startPage + blockLimit - 1 : myplaceDTOPage.getTotalPages();

        model.addAttribute("myplaceDTOPage", myplaceDTOPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return "/myplace/list";
    }


    @GetMapping("/{id}")
    public String findById(@PathVariable int id, Model model,
                           @PageableDefault(page=1) Pageable pageable) {
        authService.setUserData(model);

        /* 댓글 목록 가져오기*/
        List<CommentDTO> commentDTOList = commentService.findAll(id);
        model.addAttribute("commentList", commentDTOList);


        MyplaceDTO myplaceDTO = sharedService.findByPlaceId(id);
        model.addAttribute("myplace", myplaceDTO);
        model.addAttribute("page", pageable.getPageNumber());

        return "myplace/detail";
    }

    @GetMapping("/write")
    public String myplaceWrite(Model model) {
        authService.setUserData(model);

        return "myplace/write";
    }

    @PostMapping("/save")
    public String myplaceSave(@ModelAttribute MyplaceDTO myplaceDTO) throws IOException {
        myplaceService.save(myplaceDTO);

        return "redirect:/myplace/list";
    }

    @GetMapping("/edit/{id}")
    public String myplaceEditForm(@PathVariable int id, Model model) {
        authService.setUserData(model);

        MyplaceDTO myplaceDTO = sharedService.findByPlaceId(id);
        model.addAttribute("myplaceEdit", myplaceDTO);

        return "myplace/edit";
    }


    @PostMapping("/edit")
    public String myplaceEdit(@ModelAttribute MyplaceDTO myplaceDTO, Model model) {

        MyplaceDTO myplace = myplaceService.edit(myplaceDTO);
        model.addAttribute("myplace", myplace);

        return "redirect:/myplace/" + myplaceDTO.getId();
    }


    @GetMapping("/delete/{id}")
    public String myplaceDel(@PathVariable int id) {
        myplaceService.delete(id);

        return "redirect:/myplace/list";
    }


    @PostMapping("/deleteFile")
    public ResponseEntity<String> deleteFile(@RequestBody Map<String, String> requestData) {
        try {
            String storedFileName = requestData.get("storedFileName");
            String originalFileName = requestData.get("originalFileName");

            String decodedStoredFileName = URLDecoder.decode(storedFileName, "UTF-8");
            String decodedOriginalFileName = URLDecoder.decode(originalFileName, "UTF-8");

            myplaceFileService.deleteFile(decodedStoredFileName, decodedOriginalFileName);
            return ResponseEntity.ok("파일을 성공적으로 삭제했습니다.");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("파일 삭제 중 오류가 발생했습니다.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("파일 삭제 중 오류가 발생했습니다.");
        }
    }
}