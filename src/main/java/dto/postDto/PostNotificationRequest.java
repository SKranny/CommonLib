package dto.postDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import constants.NotificationType;
import dto.notification.ContentDTO;
import dto.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostNotificationRequest implements NotificationRequest {
    private Long authorId;

    private String title;

    private List<Long> friendsId;

    @JsonProperty("notificationType")
    private NotificationType type;

    private ContentDTO content;

}
