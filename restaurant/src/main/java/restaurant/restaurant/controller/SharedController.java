package restaurant.restaurant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import restaurant.restaurant.dto.MyplaceDTO;
import restaurant.restaurant.entity.MyplaceEntity;
import restaurant.restaurant.service.AuthService;
import restaurant.restaurant.service.MyplaceService;

import java.util.List;

@Controller
@RequiredArgsConstructor

@RequestMapping("/shared")
public class SharedController {

    private final AuthService authService;
    private final MyplaceService myplaceService;

    @GetMapping("")
    public String ShareP(Model model) {
        authService.setUserData(model);
        List<MyplaceDTO> myplaceDTOList = myplaceService.findAll();
        model.addAttribute("myplaceList", myplaceDTOList);

        return "shared";
    }



}
