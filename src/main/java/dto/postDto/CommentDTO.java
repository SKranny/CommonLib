package dto.postDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Data
@Schema(description = "Комментарий")
@Builder
public class CommentDTO {
    @Schema(description = "Идентификатор")
    private Long id;
    @Schema(description = "Идентификатор поста")
    private Long postId;
    @Schema(description = "Время создания комментария")
    private ZonedDateTime time;
    @Schema(description = "Время редактирования комментария")
    private ZonedDateTime editTime;
    @Schema(description = "Идентификатор автора")
    private Long authorId;
    @Schema(description = "Текст комментария")
    private String text;
    @Schema(description = "Комментарий заблокирован")
    private boolean isBlocked;
    @Schema(description = "Комментарий удален")
    private boolean isDelete;
    @Schema(description = "Количество лайков для комментария")
    private Long likeAmount;
    @Schema(description = "Мой лайк на комментарий")
    private boolean myLike;
    @Schema(description = "Количество комментариев")
    private Long commentsCount;

}
