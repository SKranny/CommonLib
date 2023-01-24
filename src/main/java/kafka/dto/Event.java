package kafka.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Event<T> {
    private String serviceName;

    @Builder.Default
    private LocalDateTime time = LocalDateTime.now();

    private T content;
}
