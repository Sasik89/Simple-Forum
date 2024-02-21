package forum.controller;

import forum.exceptions.LoginAlreadyExistException;
import forum.memory.IUsersDAO;
import forum.model.User;
import forum.model.dto.UsersDTO;
import forum.session.SessionData;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticationControler {

    @Autowired
    IUsersDAO usersDAO;
    @Resource
    SessionData sessionData;

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("sessionData", sessionData);
        return "login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        if(usersDAO.logged(username, password)){
            sessionData.setUsername(new User(username));
            model.addAttribute("sessionData", sessionData);
            System.out.println(username);
            return "redirect:/";
        }
        return "redirect:/login";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public String logout(Model model) {
        usersDAO.logout();
        model.addAttribute("sessionData", null); //przekazuje wartość null do HTMLa
        return "redirect:/";
    }

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String register(Model model) {  //wysyla model do htmla
        model.addAttribute("sessionData", sessionData);
        model.addAttribute("userModel", new UsersDTO() );
        return "register";
    }
    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute UsersDTO usersDTO) {
        try{
            usersDAO.addUser(usersDTO.getUsername(),  usersDTO.getPassword());
        } catch (LoginAlreadyExistException e){
            return "redirect:/register";
        }
        return "redirect:/";
    }
}

