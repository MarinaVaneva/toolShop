package bg.softuni.ToolShop.service;

import bg.softuni.ToolShop.model.dtos.UserRegistrationDTO;
import bg.softuni.ToolShop.model.entity.UserEntity;
import bg.softuni.ToolShop.model.view.UserViewModel;
import bg.softuni.ToolShop.repository.UserRepository;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final UserDetailsService userDetailsService;


  public UserService(UserRepository userRepository,
      PasswordEncoder passwordEncoder,
      UserDetailsService userDetailsService) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
    this.userDetailsService = userDetailsService;
  }

  public void registerUser(UserRegistrationDTO registrationDTO,
      Consumer<Authentication> successfulLoginProcessor) {

    UserEntity userEntity = new UserEntity().
        setFirstName(registrationDTO.getFirstName()).
        setLastName(registrationDTO.getLastName()).
        setEmail(registrationDTO.getEmail()).
        setPassword(passwordEncoder.encode(registrationDTO.getPassword()));

    userRepository.save(userEntity);

    UserDetails userDetails = userDetailsService.loadUserByUsername(registrationDTO.getEmail());

    Authentication authentication = new UsernamePasswordAuthenticationToken(
        userDetails,
        userDetails.getPassword(),
        userDetails.getAuthorities()
    );

    successfulLoginProcessor.accept(authentication);
  }
  public UserEntity findById(Long id) {
    return userRepository.findById(id)
            .orElse(null);
  }
  public List<UserViewModel> findAllUserAndCountOfOrdersOrderByCountDesc() {

    return userRepository.findAllUserAndCountOfOrdersOrderByCountDesc()
            .stream()
            .map(user -> {
              UserViewModel userViewModel = new UserViewModel();
              userViewModel.setFirstName(user.getFirstName());
              userViewModel.setLastName(user.getLastName());
              userViewModel.setCountOfTools(user.getOrders().size());

              return userViewModel;
            })
            .collect(Collectors.toList());
  }

}
