package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

public class Bean {







  class Email {
  }

  interface EmailService {
    default Email sendEmail(String from, String to, String msg ){
      throw new RuntimeException();
    }
  }
  
  class DynService implements EmailService {
    @Autowired
    EmailService service ;

    public Email sendEmail(String from, String to, String msg ){
      return service.sendEmail("","","");
    }
  }

}
