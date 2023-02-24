package dto.postDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@Schema(description = "Посты")
@Builder
public class PostDTO {
    @Schema(description = "Идентификатор")
    private Long id;

    @Schema(description = "Время создания поста")
    private Date time;

    @Schema(description = "Время публикации поста")
    private Date publishTime;

    @Schema(description = "Идентификатор автора")
    private Long authorId;

    @Schema(description = "Заголовок")
    private String title;

    @Schema(description = "Текст поста")
    private String postText;

    @Schema(description = "Состояние блокировки поста")
    private Boolean isBlocked;

    @Schema(description = "Статус удаления поста")
    private Boolean isDelete;

    @Schema(description = "Состояние по друзьям")
    private Boolean withFriends;

    @Schema(description = "Список тегов")
    private Set<TagDTO> tags;

    @Schema(description = "Мой лайк на пост")
    private boolean myLike;

    @Schema(description = "Количество лайков на пост")
    private Long likeAmount;

    @Schema(description = "Количество комментов на пост")
    private Long commentAmount;
}
