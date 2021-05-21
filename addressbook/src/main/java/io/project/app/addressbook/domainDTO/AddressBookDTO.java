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
public class AddressBookDTO {

    private String chatId;

    private long contact_id = System.currentTimeMillis();

    private String contactName;

    private String email;

    private String phoneNumber;
    
    private String zoomId;

    private LocalDateTime recordDate = LocalDateTime.now();

}
