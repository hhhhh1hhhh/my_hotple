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

@Controller
@RequiredArgsConstructor
@RequestMapping("/myplace")
public class MyplaceController {


    private final AuthService authService;

    private final MyplaceService myplaceService;



    @GetMapping("/list")
    public String myplaceP(Model model) {
        authService.setUserData(model);
        return "myplace/list";
    }

    @GetMapping("/write")
    public String myplacWrite(Model model) {
        authService.setUserData(model);
        return "myplace/write";
    }

    @PostMapping("/save")
    public String myplaceSave(@ModelAttribute MyplaceDTO myplaceDTO) {
        System.out.println("myplaceDTO = " + myplaceDTO);

        myplaceService.save(myplaceDTO);

        return "myplace/list";
    }

}
