package restaurant.restaurant.controller;

import lombok.RequiredArgsConstructor;
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


    @GetMapping("/list")
    public String myplaceP(Model model) {
        authService.setUserData(model);
        List<MyplaceDTO> myplaceDTOList = myplaceService.findByUserId(model); // 모델 전달
        model.addAttribute("myplaceList", myplaceDTOList);

        return "myplace/list";
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
    public String myplaceSave(@ModelAttribute MyplaceDTO myplaceDTO, Model model) {
        authService.setUserData(model);
        System.out.println("myplaceDTO = " + myplaceDTO);

        myplaceService.save(myplaceDTO);

        return "redirect:/myplace/list";
    }

    @GetMapping("/edit")
    public String myplaceEdit(Model model) {
        authService.setUserData(model);
        return "myplace/edit";
    }

}
