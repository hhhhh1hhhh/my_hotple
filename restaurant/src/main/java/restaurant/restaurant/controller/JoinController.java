package restaurant.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import restaurant.restaurant.dto.JoinDTO;
import restaurant.restaurant.service.JoinService;

@Controller
public class JoinController {

    private final JoinService joinService;

    public JoinController(JoinService joinService) {
        this.joinService = joinService;
    }

    @GetMapping("/join")
    public String joinP() {

        return "join";
    }

    @PostMapping("/joinProc")
    public String joinProcess(JoinDTO joinDTO) {

        joinService.joinProcess(joinDTO);


        return "redirect:/login";
    }


}
