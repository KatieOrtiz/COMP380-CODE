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
	
	@GetMapping("/email")
	public String email() {		
		return "email";
	}
	
	@GetMapping("/order_confirmation")
	public String order_confirmation() {		
		return "order_confirmation";
	}

	@GetMapping("/checkout")
	public String checkout() {		
		return "checkout";
	}

	@GetMapping("/products")
	public String products(){
		return "products";
	}

	@GetMapping("/cart")
	public String cart() {		
		return "cart";
	}

	//Mapping for /login, connects to login page 
	@GetMapping("/login")
	public String showForm1(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		
		List<String> listProfession = Arrays.asList("Developer", "Tester", "Architect");
		model.addAttribute("listProfession", listProfession);
		
		return "login";
	}

	//go from login to loginsuccess, reads user.txt, if username and pw are same from what is entered to what is in user.txt, 
	//it will allow to go to login success, otherwise stay in login
	@PostMapping("/login")
	public String submitForm1(@Valid @ModelAttribute("user") User user1, BindingResult bindingResult, Model model) {
		readfile reading = new readfile();
		reading.openFile();
		reading.readFile();
		String f = user1.getUsername();
		String g = user1.getPassword();
		String h = reading.getB();
		String i = reading.getD();
		if(f.equals(h)){
			if(g.equals(i)){
				user1.setName(reading.getF());
				return "login_success";
			}else{
				return "login";
			}
		}
		else{
			return "login";
		}
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