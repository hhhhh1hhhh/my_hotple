package restaurant.restaurant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import restaurant.restaurant.dto.MyplaceDTO;
import restaurant.restaurant.service.AuthService;
import restaurant.restaurant.service.MyplaceService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/myplace")
public class MyplaceController {


    private final AuthService authService;

    private final MyplaceService myplaceService;


    @GetMapping("/list")
    public String myplaceP(Model model) {
        authService.setUserData(model);
        List<MyplaceDTO> myplaceDTOList = myplaceService.findByUserId(model); // 모델 전달
        model.addAttribute("myplaceList", myplaceDTOList);

        return "myplace/list";
    }


    @GetMapping("/write")
    public String myplacWrite(Model model) {
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

}
