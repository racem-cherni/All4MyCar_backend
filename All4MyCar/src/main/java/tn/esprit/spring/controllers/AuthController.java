package tn.esprit.spring.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.models.Client;
import tn.esprit.spring.models.ERole;
import tn.esprit.spring.models.Prestataire;
import tn.esprit.spring.models.Role;
import tn.esprit.spring.models.User;
import tn.esprit.spring.payload.request.LoginRequest;
import tn.esprit.spring.payload.request.SignupRequest;
import tn.esprit.spring.payload.response.JwtResponse;
import tn.esprit.spring.payload.response.MessageResponse;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.PrestataireRepository;
import tn.esprit.spring.repository.RoleRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.security.jwt.JwtUtils;
import tn.esprit.spring.security.services.UserDetailsImpl;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	PrestataireRepository prestataireRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser( @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()));
		

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
			
			
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "pres":
					Role modRole = roleRepository.findByName(ERole.ROLE_PRESTATAIRE)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		user.setEtat(false);
		Date d = new Date();
		user.setDate_registration(d);
		userRepository.save(user);
	/*	Date d = new Date() ;
		List<Role> list = new ArrayList<>(); 
	   for (Role t : roles) 
	    list.add(t); 
		String l= list.get(0).getName().toString() ;
		if ( l.equals("ROLE_USER")) {
			Client client = new Client();
			client.setFirstNameclt(signUpRequest.getUsername());
			client.setEmailclt(signUpRequest.getEmail());
			client.setDate_inscrip(d);
			clientRepository.save(client);
			user.setClient(client);
			userRepository.save(user);

		}
		
		else if ( l.equals("ROLE_PRESTATAIRE")) {
			Prestataire pres = new Prestataire();
			pres.setFirstNamepres(signUpRequest.getUsername());
			pres.setEmailpres(signUpRequest.getEmail());
			pres.setDate_inscrip(d);
			prestataireRepository.save(pres);
			user.setPrestataire(pres);
			userRepository.save(user);
			
		}*/

		return ResponseEntity.ok(new MessageResponse("Merci ! Nous vous rappelons très rapidement."));
		
	}
}