package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class CentralController {

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String defaultPage(ModelMap model) {
	  model.addAttribute("title", "Spring Security Login Form - Database Authentication");
	  model.addAttribute("message", "This is default page!");
	  return "hello";

	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
	  model.addAttribute("title", "Spring Security Login Form - Database Authentication");
	  model.addAttribute("message", "This page is for ROLE_ADMIN only!");
	  return "admin";
	}

    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public String loginPage() {
        return "login";
    }
 
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accesssDenied(ModelMap model) {
		
	  //check if user is login
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  if (!(auth instanceof AnonymousAuthenticationToken)) {
		UserDetails userDetail = (UserDetails) auth.getPrincipal();	
		model.addAttribute("username", userDetail.getUsername());
	  }

	  return "accessDenied";
	}

}