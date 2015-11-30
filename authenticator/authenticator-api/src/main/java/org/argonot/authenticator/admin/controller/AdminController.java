package org.argonot.authenticator.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.argonot.authenticator.admin.service.ApplicationService;
import org.argonot.authenticator.admin.service.AuthorizationService;
import org.argonot.authenticator.admin.service.RoleService;
import org.argonot.authenticator.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    private AuthorizationService authorizationService;
    
    @Autowired
    private ApplicationService applicationService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private RoleService roleService;
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView authorizations() {
        ModelAndView page = new ModelAndView("Admin");
        page.addObject("authorizations", authorizationService.listAuthorizations());
        return page;
    }
    
    @RequestMapping(value = "/applications", method = RequestMethod.GET)
    public ModelAndView applications() {
        ModelAndView page = new ModelAndView("Applications");
        page.addObject("applications", applicationService.listApplications());
        return page;
    }
    
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView users() {
        ModelAndView page = new ModelAndView("Users");
        page.addObject("users", userService.listUsers());
        return page;
    }
    
    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public ModelAndView roles() {
        ModelAndView page = new ModelAndView("Roles");
        page.addObject("roles", roleService.listRoles());
        return page;
    }
    
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public ModelAndView logout (HttpServletRequest request, HttpServletResponse response) {
        ModelAndView page = new ModelAndView("Index");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return page;
    }

}
