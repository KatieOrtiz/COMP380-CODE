package code0.ecommercesite;

import java.util.Arrays;
import java.util.List;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EcommerceSiteController {
	
	@GetMapping("/signup")
	public String showForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		
		List<String> listProfession = Arrays.asList("Developer", "Tester", "Architect");
		model.addAttribute("listProfession", listProfession);
		
		return "signup_form";
	}

	@PostMapping("/signup")
	public String submitForm(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
		System.out.println(user);
		
		if (bindingResult.hasErrors()) {
			List<String> listProfession = Arrays.asList("Developer", "Tester", "Architect");
			model.addAttribute("listProfession", listProfession);
			
			return "signup_form";
		}else {
			return "signup_success";
		}
	}

	@GetMapping("/home")
	public String home() {		
		return "home";
	}

	@GetMapping("/cart")
	public String cart() {		
		return "cart";
	}

	@GetMapping("/login")
	public String login() {		
		return "login";
	}
	
	@GetMapping("/about")
	public String about() {		
		return "about";
	}

	@GetMapping("/faq")
	public String faq() {		
		return "faq";
	}

	@GetMapping("/contact")
	public String contact() {		
		return "contact";
	}
}