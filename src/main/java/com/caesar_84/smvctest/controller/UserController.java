package main.java.com.caesar_84.smvctest.controller;

import main.java.com.caesar_84.smvctest.model.User;
import main.java.com.caesar_84.smvctest.service.UserService;
import main.java.com.caesar_84.smvctest.ducktapes.StringWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caesar-84 on 2/10/17.
 */
@Controller
public class UserController
{
    private UserService userService;
    //private String lastPassedNameParam;

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "userlist/{pageNum}", method = RequestMethod.GET)
    public String userList(@PathVariable("pageNum") int pageNum, Model model)
    {
        int resultsPerPage = 5;
        List<User> usersList = userService.userList(pageNum, resultsPerPage);
        ArrayList<Integer> pages = new ArrayList<>();

        for (int i = 1; i <= getTotalPages(userService.getRecordsNumber(), resultsPerPage); i++)
        {
            pages.add(i);
        }

        model.addAttribute("pages", pages);
        model.addAttribute("userListOnPage", usersList);

        return "userlist";
    }

    @RequestMapping(value = "/userdata/{pageNum}/{searchRequest}", method = RequestMethod.GET)
    public String userData(@PathVariable("pageNum") int pageNum, @PathVariable("searchRequest")
                        String searchRequest, Model model)
    {
        int resultsPerPage = 5;
        List<User> usersList = userService.getUsersByName(searchRequest, pageNum, resultsPerPage);

        ArrayList<Integer> pages = new ArrayList<>();

        for (int i = 1; i <= getTotalPages(usersList.size(), resultsPerPage); i++)
        {
            pages.add(i);
        }

        model.addAttribute("userList", usersList);
        model.addAttribute("pages", pages);

        return "userdata";
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String users(Model model)
    {
        model.addAttribute("user", new User());

        return "users";
    }

    @RequestMapping(value = "users/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user)
    {
        if (user.getId() == 0) userService.addUser(user);
        else userService.updateUser(user);

        return "redirect:/userlist/1";
    }

    @RequestMapping(value = "/remove/{id}")
    public String removeUser(@PathVariable("id") int id)
    {
        userService.deleteUser(id);

        return "redirect:/userlist/1";
    }

    @RequestMapping(value = "edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("user", userService.getUserById(id));

        return "users";
    }

    @RequestMapping(value = "finduser")
    public String findUserPage(Model model)
    {
        model.addAttribute("nameParam", new StringWrapper());

        return "finduser";
    }

    @RequestMapping(value = "passnameparam")
    public synchronized String passParam(@ModelAttribute("nameParam") StringWrapper nameParam)
    {
        return "redirect:/userdata/1/" + nameParam.getValue();
    }

    private long getTotalPages(long totalUsersNumber, int resultsPerPage) {
        return totalUsersNumber % resultsPerPage == 0 ?
                totalUsersNumber/resultsPerPage : (totalUsersNumber/resultsPerPage) + 1;
    }
}
