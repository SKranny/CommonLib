package dto.notification;

import constants.NotificationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDTO {
    private Long id;

    private Long authorId;

    private Long recipientId;

    private NotificationType type;

    private ContentDTO content;

    private LocalDateTime createDatetime;

    private LocalDateTime sendDatetime;

    private Boolean isSent;
}
