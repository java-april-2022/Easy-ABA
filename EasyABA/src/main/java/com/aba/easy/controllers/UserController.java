package com.aba.easy.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.aba.easy.models.Activity;
import com.aba.easy.models.LoginUser;
import com.aba.easy.models.User;
import com.aba.easy.services.ActivityService;
import com.aba.easy.services.ScoreService;
import com.aba.easy.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private ScoreService scoreService;
	@Autowired
	private ActivityService activityService;
	
	@GetMapping("/")
	public String index(@ModelAttribute("newUser")User user, @ModelAttribute("newLogin") LoginUser loginUser) {
		return "index.jsp";
	}
	//register a new user
		@PostMapping("/registration")
		public String registerUser(@Valid @ModelAttribute("newUser") User user, BindingResult result, HttpSession session, @ModelAttribute("newLogin") LoginUser loginUser) {
				//validate user
			userService.validate(user, result);
				if(result.hasErrors()) {
					List<FieldError> fieldErrors = result.getFieldErrors();
					for(FieldError error : fieldErrors) {
						System.out.print(error.getDefaultMessage());
					}
					System.out.println();
					return "index.jsp";
				}
				//register user
				userService.registerUser(user);
				//put user in session
				session.setAttribute("loggedInUser", user.getId());
				return "redirect:/dashboard";
			}
		@PostMapping("/login")
		public String loginUser(@Valid @ModelAttribute("newLogin") LoginUser loginUser, BindingResult result, HttpSession session, @ModelAttribute("newUser") User user) {
			//authenticate user
			userService.authenticateUser(loginUser, result);
			if(result.hasErrors()) {
				return "index.jsp";
			}
			//get the entire logged in user object 
			User loggedinUser=userService.findByEmail(loginUser.getEmail());
			// put user in session
			session.setAttribute("loggedInUser", loggedinUser.getId());
			return "redirect:/dashboard";
		}
		//LOGOUT
		@GetMapping("/logout")
		public String logoutUser(HttpSession session) {
			session.invalidate();
			return "redirect:/";
		}
		@GetMapping("/dashboard")
		public String dashboard(@ModelAttribute("newImage")Activity activity,User user,HttpSession session, Model model, BindingResult result) {
//			 check if user is in session
			if(session.getAttribute("loggedInUser")!= null) {
				model.addAttribute("user", userService.findById((Long)session.getAttribute("loggedInUser")));
				model.addAttribute("scores", scoreService.all());
				model.addAttribute("activities", activityService.findAll());
				model.addAttribute("loggedInUser", session.getAttribute("loggedInUser"));
			return "dashboard.jsp";
		}
			else {
				return "redirect:/";
			}
		}
	}
	

	
