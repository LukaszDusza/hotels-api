package akadamia.security.register;

import akadamia.security.Role;
import akadamia.security.RoleRepository;
import akadamia.security.UserApp;
import akadamia.security.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserAppService implements Mapper<UserAppDTO, UserApp> {

  private RoleRepository roleRepository;
  private PasswordEncoder passwordEncoder;
  private UserRepository userRepository;

  public UserAppService(RoleRepository roleRepository, PasswordEncoder passwordEncoder, UserRepository userRepository) {
    this.roleRepository = roleRepository;
    this.passwordEncoder = passwordEncoder;
    this.userRepository = userRepository;
  }

  @Override
  public UserApp map(UserAppDTO u) {

    Role role = roleRepository.findRoleByName("USER");
    Set<Role> roles = new HashSet<>();
    roles.add(role);

    return new UserApp(u.getName(), u.getLastName(), u.getEmail(), u.getLogin(),
        passwordEncoder.encode(u.getPassword()), 1, roles);
  }

  public UserApp registerUser(UserAppDTO userAppDTO) {
    UserApp newUser = map(userAppDTO);
    return userRepository.save(newUser);
  }

}
