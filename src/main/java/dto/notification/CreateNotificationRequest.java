package dto.notification;

import com.fasterxml.jackson.annotation.JsonProperty;
import constants.NotificationType;
import lombok.Data;

@Data
public class CreateNotificationRequest {
    private Long authorId;

    private Long recipientId;

    @JsonProperty("notificationType")
    private NotificationType type;

    private ContentDTO content;
}
