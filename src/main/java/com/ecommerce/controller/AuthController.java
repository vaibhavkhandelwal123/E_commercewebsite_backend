package com.ecommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ecommerce.config.JwtProvider;
import com.ecommerce.exception.UserException;
import com.ecommerce.model.Cart;
import com.ecommerce.model.User;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.request.LoginRequest;
import com.ecommerce.response.AuthResponse;
import com.ecommerce.service.CartService;
import com.ecommerce.service.CustomUserServiceImplementation;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private static final Authentication UsernamePasswordAuthenticationToken = null;

	private UserRepository userRepository;
	
	private JwtProvider jwtprovider;
	private PasswordEncoder passwordEncoder;
	private CustomUserServiceImplementation customerUserService;
	private CartService cartService;
	
	
	public AuthController(UserRepository userRepository,
			CustomUserServiceImplementation	customerUserService,
			PasswordEncoder passwordEncoder,
			JwtProvider jwtprovider,
			CartService cartService) {
		this.userRepository=userRepository;
		this.customerUserService=customerUserService;
		this.passwordEncoder=passwordEncoder;
		this.jwtprovider = jwtprovider;
		this.cartService=cartService;
	}
	@PostMapping("/signup")
	public ResponseEntity<AuthResponse>creteUserHandler(@RequestBody User user) throws UserException{
		
		String email = user.getEmail();
		String password = user.getPassword();
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		
		
		User isEmailExist = userRepository.findByEmail(email);
		
		if(isEmailExist!=null) {
			throw new UserException("Email is Already Used With Another Account");
		}
		
		User createdUser = new User();
		createdUser.setEmail(email);
		createdUser.setPassword(passwordEncoder.encode(password));
		createdUser.setFirstName(firstName);
		createdUser.setLastName(lastName);
		createdUser.setOther("hiii");
		
		User savedUser = userRepository.save(createdUser);
		Cart cart = cartService.createCart(savedUser);

		Authentication authentication = new UsernamePasswordAuthenticationToken(savedUser.getEmail(),savedUser.getPassword());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String token = jwtprovider.generateToken(authentication);
		
		AuthResponse authResponse  = new AuthResponse(token,"Signup Success");
		authResponse.setJwt(token);
		authResponse.setMessage("Signup Success");
		return new ResponseEntity<AuthResponse>(authResponse,HttpStatus.CREATED);
	}

	@PostMapping("/signin")
	public ResponseEntity<AuthResponse>loginUserHandler( @RequestBody LoginRequest loginRequest){
		String username = loginRequest.getEmail();
		String password = loginRequest.getPassword();
		
		Authentication authentication = authenticate(username,password);
		SecurityContextHolder.getContext().setAuthentication(authentication);
String token = jwtprovider.generateToken(authentication);
		
		AuthResponse authResponse  = new AuthResponse(token,"Signin Success");
		
		return new ResponseEntity<AuthResponse>(authResponse,HttpStatus.CREATED);
	}
	private Authentication authenticate(String username, String password) {
		
		UserDetails userdetails = customerUserService.loadUserByUsername(username);
		
		if(userdetails==null)
		{
			throw new BadCredentialsException("Invalid Username");
		}
		
		if(passwordEncoder.matches(password, userdetails.getPassword())) {
			throw new BadCredentialsException("Invalid Password...");
		}
		return new UsernamePasswordAuthenticationToken(userdetails,null,userdetails.getAuthorities());
	}
}

