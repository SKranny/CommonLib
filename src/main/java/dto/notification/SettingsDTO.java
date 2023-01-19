package dto.notification;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SettingsDTO {
    private Long id;

    @JsonProperty(defaultValue = "false")
    private Boolean friendRequest;

    @JsonProperty(defaultValue = "false")
    private Boolean friendBirthday;

    @JsonProperty(defaultValue = "false")
    private Boolean postComment;

    @JsonProperty(defaultValue = "false")
    private Boolean commentOnComment;

    @JsonProperty(defaultValue = "false")
    private Boolean post;

    @JsonProperty(defaultValue = "false")
    private Boolean message;

    @JsonProperty(defaultValue = "false")
    private Boolean phoneNotification;

    @JsonProperty(defaultValue = "false")
    private Boolean emailNotification;
}
