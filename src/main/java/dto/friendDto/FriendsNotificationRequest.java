package dto.friendDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import constants.NotificationType;
import dto.notification.ContentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FriendsNotificationRequest {

    private Long authorId;

    private Long recipientId;

    private ContentDTO content;
    @JsonProperty("notificationType")
    private NotificationType type;

}
