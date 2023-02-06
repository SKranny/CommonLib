package dto.userDto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

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
