package com.works.bulutvet.controller;

import com.works.bulutvet.entities.Role;
import com.works.bulutvet.entities.User;
import com.works.bulutvet.repositories.RoleRepository;
import com.works.bulutvet.services.UserService;
import com.works.bulutvet.services.UtilService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/settings")
public class SettingsController {

    final UserService uService;
    final RoleRepository rRepo;
    final UtilService utilService;
    public SettingsController(UserService uService, RoleRepository rRepo, UtilService utilService) {
        this.uService = uService;
        this.rRepo = rRepo;
        this.utilService = utilService;
    }

    @GetMapping("")
    public String settings(Model model){
        model.addAttribute("userList",utilService.userList());
        return "settings";
    }
    @PostMapping("/register")
    public String register(User us, @RequestParam(defaultValue = "1") String roleIDSt){
        try{
            int roleID = Integer.parseInt(roleIDSt);
            us.setEnabled(true);
            us.setTokenExpired(true);

            Role role= rRepo.findById(roleID).get();
            List<Role> roles=new ArrayList<>();
            roles.add(role);
            us.setRoles(roles);

            uService.register(us);
            return "redirect:/login";
        }catch (Exception e){
            System.out.println(e);
        }
        return "settings";
    }



}

