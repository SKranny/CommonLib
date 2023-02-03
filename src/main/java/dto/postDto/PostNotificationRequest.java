package dto.postDto;

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
public class PostNotificationRequest {
    private Long authorId;

    private String title;

    @JsonProperty("notificationType")
    private NotificationType type;

    private ContentDTO content;

}
