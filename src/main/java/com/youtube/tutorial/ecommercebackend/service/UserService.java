package com.youtube.tutorial.ecommercebackend.service;

import com.youtube.tutorial.ecommercebackend.api.model.RegistrationBody;
import com.youtube.tutorial.ecommercebackend.exception.UserAlreadyExistsException;
import com.youtube.tutorial.ecommercebackend.model.LocalUser;
import com.youtube.tutorial.ecommercebackend.model.dao.LocalUserDAO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service

public class UserService {

  private LocalUserDAO localUserDAO;

  public UserService(LocalUserDAO localUserDAO) {
    this.localUserDAO = localUserDAO;
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

    user.setPassword(registrationBody.getPassword());
    return localUserDAO.save(user);

  }

}
