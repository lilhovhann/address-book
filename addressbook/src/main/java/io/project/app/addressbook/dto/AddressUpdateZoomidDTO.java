package io.project.app.addressbook.dto;

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
public class AddressUpdateZoomidDTO extends DTO{

    private Long chatId;

    private long contact_id;
    
    private String email;

}
