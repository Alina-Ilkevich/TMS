package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/get")
    public String getUserInfo(@RequestParam int id, Model model) {
        Users user = userService.getUserInfo(id);
        if (user != null) {
            model.addAttribute("message", true);
            model.addAttribute("user", user);
        } else {
            model.addAttribute("message", false);
            model.addAttribute("message", "The user with ID " + id + " not found");
        }
        return "user";
    }

    @GetMapping(value = "/create")
    public ModelAndView showCreateUserForm() {
        return new ModelAndView("create", "user", new Users());
    }

    @PostMapping(value = "/create")
    public ModelAndView createUser(@ModelAttribute Users user, Model model)  {
        if (!user.getLogin().isEmpty() && !user.getName().isEmpty()) {
            userService.createUser(user);
            model.addAttribute("message", "The user with name " + user.getName() + " created successful");
            return new ModelAndView("create_result", "model", model);
        }
        model.addAttribute("message", "Not all data was entered!");
        return new ModelAndView("create", "user", new Users()).addObject(model);
    }

    @GetMapping(value = "/delete")
    public ModelAndView showDeleteUserForm() {
        return new ModelAndView("delete", "user", new Users());
    }

    @PostMapping("/delete")
    public ModelAndView deleteUser(@RequestParam int id, Model model) {
        Users user = userService.getUserInfo(id);
        if (user != null) {
            userService.deleteUser(id);
            model.addAttribute("message", "The user with ID " + id + " was deleted");
        } else {
            model.addAttribute("message", "The user with ID " + id + " does not exist");
        }
        return new ModelAndView("delete_result", "model", model);
    }
}
