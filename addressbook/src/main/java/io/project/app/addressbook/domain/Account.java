package io.project.app.addressbook.domain;

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;

/**
 *
 * @author lilit
 */


public class Account {
  
    @Id
    private String id;
    
    private String chatId;
    
    private String firstname;
    
    private String lastname;
    
    private LocalDateTime registerDate = LocalDateTime.now();
    
}
