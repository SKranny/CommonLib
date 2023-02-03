package dto.friendDto;

import constants.FriendshipStatusCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FriendDTO {
    private Long id;
    private String photo;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private boolean isOnline;
    private FriendshipStatusCode statusCode;
}
