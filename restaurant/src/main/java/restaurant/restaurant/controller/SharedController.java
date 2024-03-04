package restaurant.restaurant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import restaurant.restaurant.dto.MyplaceDTO;
import restaurant.restaurant.service.AuthService;
import restaurant.restaurant.service.SharedService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/shared")
public class SharedController {

    private final AuthService authService;
    private final SharedService sharedService;

    @GetMapping("/list")
    public String ShareP(Model model) {
        authService.setUserData(model);
        List<MyplaceDTO> myplaceDTOList = sharedService.findAll();
        model.addAttribute("myplaceList", myplaceDTOList);

        return "shared/list";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable int id, Model model) {
        authService.setUserData(model);
        sharedService.updateViews(id);
        MyplaceDTO myplaceDTO = sharedService.findByPlaceId(id);
        model.addAttribute("myplace", myplaceDTO);


        return "shared/detail";
    }


}
