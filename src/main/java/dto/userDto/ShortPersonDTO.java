package dto.userDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShortPersonDTO {
    private Long id;

    @Email
    @NotNull
    @JsonProperty(required = true)
    private String email;

    @NotNull
    @JsonProperty(required = true)
    private String firstName;

    @NotNull
    @JsonProperty(required = true)
    private String lastName;
}
