package io.project.app.addressbook.domainDTO;

import io.project.app.addressbook.domain.*;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 *
 * @author lilit
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
  
    private String chatId;
    
    private String firstname;
    
    private String lastname;
    
    private LocalDateTime registerDate = LocalDateTime.now();
    
}
