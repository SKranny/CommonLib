package dto.notification;

import constants.AttachType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AttachDTO {
    private Long id;

    private AttachType type;

    private String text;
}
