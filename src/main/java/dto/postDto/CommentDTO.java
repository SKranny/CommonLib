package dto.postDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Schema(description = "Комментарий")
@Builder
public class CommentDTO {
    @Schema(description = "Идентификатор")
    private Long id;
    @Schema(description = "Идентификатор поста")
    private Long postId;
    @Schema(description = "Время создания комментария")
    private Date time;
    @Schema(description = "Идентификатор автора")
    private Long authorId;
    @Schema(description = "Текст комментария")
    private String text;
}
