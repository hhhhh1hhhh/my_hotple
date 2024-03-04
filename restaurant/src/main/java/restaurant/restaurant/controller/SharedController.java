package restaurant.restaurant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import restaurant.restaurant.dto.MyplaceDTO;
import restaurant.restaurant.entity.MyplaceEntity;
import restaurant.restaurant.service.AuthService;
import restaurant.restaurant.service.MyplaceService;
import restaurant.restaurant.service.SharedService;

import java.util.List;

@Controller
@RequiredArgsConstructor

public class SharedController {

    private final AuthService authService;
    private final SharedService sharedService;

    @GetMapping("/shared")
    public String ShareP(Model model) {
        authService.setUserData(model);
        List<MyplaceDTO> myplaceDTOList = sharedService.findAll();
        model.addAttribute("myplaceList", myplaceDTOList);

        return "shared";
    }

    @GetMapping("shared/{id}")
    public String findById(@PathVariable int id, Model model) {
        authService.setUserData(model);
        sharedService.updateViews(id);
        MyplaceDTO myplaceDTO = sharedService.findByPlaceId(id);
        model.addAttribute("myplace", myplaceDTO);


        return "detail";
    }


}
