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
	
	
	/** 
	 * Mapping for the /signup page and displays the form for user signup.
	 * @param model holds application data, which is displayed in the view
	 * @return String return the html page signup_form
	 */
	@GetMapping("/signup")
	public String showForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		
		List<String> listProfession = Arrays.asList("Developer", "Tester", "Architect");
		model.addAttribute("listProfession", listProfession);
		
		return "signup_form";
	}

	
	/** 
	 * Mapping for the /signup page after user clicks the button to signup and checks user signup form for errors.
	 * @param user the user that signed up 
	 * @param bindingResult Spring's object that holds the result of the validation of the model object, the binding, and any errors that may have occurred  
	 * @param model holds application data, which is displayed in the view
	 * @return String return the html page signup_form if errors or return html page signup_success if successful
	 */
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

	
	/** 
	 * Mapping for the /home page.
	 * @return String return the html page home
	 */
	@GetMapping("/home")
	public String home() {		
		return "home";
	}

	
	/** 
	 * Mapping for the /checkout page.
	 * @return String return the html page checkout
	 */
	@GetMapping("/checkout")
	public String checkout() {		
		return "checkout";
	}

	
	/** 
	 * Mapping for the /products page.
	 * @return String return the html page products
	 */
	@GetMapping("/products")
	public String products(){
		return "products";
	}

	
	/** 
	 * Mapping for the /cart page.
	 * @return String return the html page cart
	 */
	@GetMapping("/cart")
	public String cart() {		
		return "cart";
	}

	
	/** 
	 * Mapping for /login, connects to login page and displays the login form for user login.
	 * @param model holds application data, which is displayed in the view
	 * @return String return the html page login
	 */
	@GetMapping("/login")
	public String showForm1(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		
		List<String> listProfession = Arrays.asList("Developer", "Tester", "Architect");
		model.addAttribute("listProfession", listProfession);
		
		return "login";
	}

	
	/** 
	 * Mapping for the /login page after user clicks the log in button and checks user login form for errors.
	 * @param user1 the user that logs in 
	 * @param bindingResult Spring's object that holds the result of the validation of the model object, the binding, and any errors that may have occurred
	 * @param model holds application data, which is displayed in the view
	 * @return String return the html page login
	 */
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

	
	
	/** 
	 * Mapping for the /about page.
	 * @return String return the html page about
	 */
	@GetMapping("/about")
	public String about() {		
		return "about";
	}

	
	/** 
	 * Mapping for the /faq page.
	 * @return String return the html page faq
	 */
	@GetMapping("/faq")
	public String faq() {		
		return "faq";
	}

	
	/** 
	 * Mapping for the /contact page.
	 * @return String return the html page contact
	 */
	@GetMapping("/contact")
	public String contact() {		
		return "contact";
	}
}