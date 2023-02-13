package dto.notification;

import constants.NotificationType;

public interface NotificationRequest {
    ContentDTO getContent();

    Long getAuthorId();

    NotificationType getType();
}
