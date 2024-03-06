package restaurant.restaurant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import restaurant.restaurant.dto.MyplaceDTO;
import restaurant.restaurant.service.AuthService;
import restaurant.restaurant.service.MyplaceService;
import restaurant.restaurant.service.SharedService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/myplace")
public class MyplaceController {

    private final AuthService authService;
    private final MyplaceService myplaceService;
    private final SharedService sharedService;


//    @GetMapping("/list")
//    public String myplaceP(Model model) {
//        authService.setUserData(model);
//
//        List<MyplaceDTO> myplaceDTOList = myplaceService.findByUserId(model); // 모델 전달
//        model.addAttribute("myplaceList", myplaceDTOList);
//
//        return "myplace/list";
//    }

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
    public String findById(@PathVariable int id, Model model) {
        authService.setUserData(model);

        MyplaceDTO myplaceDTO = sharedService.findByPlaceId(id);
        model.addAttribute("myplace", myplaceDTO);

        return "myplace/detail";
    }

    @GetMapping("/write")
    public String myplaceWrite(Model model) {
        authService.setUserData(model);

        return "myplace/write";
    }

    @PostMapping("/save")
    public String myplaceSave(@ModelAttribute MyplaceDTO myplaceDTO) {
        myplaceService.save(myplaceDTO);

        return "redirect:/myplace/list";
    }

    @GetMapping("/edit/{id}")
    public String myplaceEditForm(@PathVariable int id, Model model) {
        authService.setUserData(model);

        MyplaceDTO myplaceDTO = sharedService.findByPlaceId(id);
        model.addAttribute("myplaceEdit", myplaceDTO);
        System.out.println("1. id = " + myplaceDTO.getId()); // 여기까지는 잘 넘어옴

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

}
