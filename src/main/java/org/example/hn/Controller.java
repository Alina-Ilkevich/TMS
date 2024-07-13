package org.example.hn;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@org.springframework.stereotype.Controller
@RequestMapping("/users")
public class Controller {
    @GetMapping("/get")
    public String getUserInfo(@RequestParam int id, Model model) {
        User user = null;
        try {
            user = UserService.getUserInfo(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user != null) {
            model.addAttribute("message", true);
            model.addAttribute("id", user.getId());
            model.addAttribute("name", user.getName());
            model.addAttribute("age", user.getAge());
            model.addAttribute("login", user.getLogin());

        } else {
            model.addAttribute("message", false);
            model.addAttribute("message", "The user with ID " + id + " not found");
        }
        return "user";
    }
    @GetMapping(value = "/create")
    public ModelAndView showCreateUserForm() {
        return new ModelAndView("create", "user", new User());
    }

    @PostMapping(value = "/create")
    public ModelAndView createUser(@ModelAttribute User user, Model model) {
        if (!user.getLogin().isEmpty() && !user.getName().isEmpty()) {
            try {
                UserService.createUser(user);
                model.addAttribute("message", "The user with name " + user.getName() + " created successful");
                return new ModelAndView("create_result", "model", model);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        model.addAttribute("message", "Not all data was entered!");
        return new ModelAndView("create", "user", new User()).addObject(model);
    }

    @RequestMapping(value = "/change")
    public ModelAndView showChangeLoginForm() {
        return new ModelAndView("change", "user", new User());
    }
    @PostMapping(value = "/change")
    public ModelAndView changeLogin(@ModelAttribute User user, Model model) {
        if (!user.getLogin().isEmpty()) {
            try {
                if (UserService.changeUserLogin(user)) {
                    model.addAttribute("message", "New login applied");
                } else {
                    model.addAttribute("message", "The user with ID " + user.getId() + " does not exist");
                }
                return new ModelAndView("change_result", "model", model);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            model.addAttribute("message", "Not all data was entered!");
            return new ModelAndView("change", "user", new User()).addObject(model);
        }
    }

    @GetMapping(value = "/delete")
    public ModelAndView showDeleteUserForm() {
        return new ModelAndView("delete", "user", new User());
    }

    @PostMapping("/delete")
    public ModelAndView deleteUser(@ModelAttribute User user, Model model) {
        try {
            if (UserService.deleteUser(user.getId())) {
                model.addAttribute("message", "The user with ID " + user.getId() + " was deleted");
            } else {
                model.addAttribute("message", "The user with ID " + user.getId() + " does not exist");
            }
            return new ModelAndView("delete_result", "model", model);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
