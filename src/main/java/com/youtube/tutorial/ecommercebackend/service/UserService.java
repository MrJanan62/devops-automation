package com.youtube.tutorial.ecommercebackend.service;

import com.youtube.tutorial.ecommercebackend.api.model.LoginBody;
import com.youtube.tutorial.ecommercebackend.api.model.RegistrationBody;
import com.youtube.tutorial.ecommercebackend.exception.UserAlreadyExistsException;
import com.youtube.tutorial.ecommercebackend.model.LocalUser;
import com.youtube.tutorial.ecommercebackend.model.dao.LocalUserDAO;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service

public class UserService {

  private LocalUserDAO localUserDAO;
  private EncryptionService encryptionService;

  private JWTService jwtService;

  public UserService(LocalUserDAO localUserDAO, EncryptionService encryptionService,JWTService jwtService) {
    this.localUserDAO = localUserDAO;
    this.encryptionService = encryptionService;
    this.jwtService = jwtService;
  }

  public LocalUser registerUser(RegistrationBody registrationBody) throws UserAlreadyExistsException {

    if(localUserDAO.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent() &&
        localUserDAO.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent())
    {
      throw new UserAlreadyExistsException();
    }
    LocalUser user = new LocalUser();
    user.setEmail(registrationBody.getEmail());
    user.setFirstName(registrationBody.getFirstName());
    user.setLastName(registrationBody.getLastName());
    user.setUsername(registrationBody.getUsername());
    user.setPassword(encryptionService.encryptPassword(registrationBody.getPassword()));
    return localUserDAO.save(user);

  }

  public String loginUser(LoginBody loginBody){

    Optional<LocalUser> opUser = localUserDAO.findByUsernameIgnoreCase(loginBody.getUsername());
      if (opUser.isPresent()){
        LocalUser user= opUser.get();
        if (encryptionService.verifyPassword(loginBody.getPassword(), user.getPassword())){
          return jwtService.generateJWT(user);
        }
      }
      return null;

    }

  }

