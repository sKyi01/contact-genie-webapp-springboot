package com.spring.genie.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.spring.genie.dao.UserRepository;
import com.spring.genie.entities.ContactDetail;
import com.spring.genie.entities.User;

@Controller
@RequestMapping("/user")
//@MultipartConfig
public class UserController {

	@Autowired
	private UserRepository uRepo;

	@ModelAttribute
	public void handleCommonRequest(Model m, Principal p) {
		System.out.println("j idea");

		String username = p.getName();
		System.out.println("USER " + username);
		User u = uRepo.getUserByUserName(username);
		System.out.println(u);
		m.addAttribute("user", u);

	}

	@RequestMapping("/index")
	public String userPage(Model m, Principal p) {

		return "normal/user_dashboard";
	}

	@GetMapping("/add-contact")
	public String getAddContactForm(Model m) {
		m.addAttribute("title", "add contact - Contact Genie");
		m.addAttribute("contact", new ContactDetail());
		return "normal/add_contact_form";
	}

	@PostMapping("/handleContact")
	public String handleContactDetails(@ModelAttribute ContactDetail c, Principal p,
			@RequestParam("profileImage") MultipartFile profileImage) throws IOException {
		String username = p.getName();
		User u = uRepo.getUserByUserName(username);
		c.setUser(u);
		u.getContact().add(c);

		if (profileImage == null) {

			System.out.println("Profile Image is Empty !!");

		} else {

			c.setImage(profileImage.getOriginalFilename());
			File saveProfile = new ClassPathResource("static/img/").getFile();

			Path path = Paths.get(saveProfile.getAbsolutePath() + File.separator + profileImage.getOriginalFilename());

			Files.copy(profileImage.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Image Uploaded Successfully");
		}
		this.uRepo.save(u);
		System.out.println("Contact Data" + c);
		System.out.println("data saved to database");

		return "normal/add_contact_form";

	}

}
