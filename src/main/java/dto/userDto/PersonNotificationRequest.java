package dto.userDto;

import dto.notification.ContentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonNotificationRequest {

    private Long PersonId;

    private String firstName;

    private String lastName;

    private ContentDTO content;
}
