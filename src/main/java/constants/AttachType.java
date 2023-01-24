package constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AttachType {
    IMAGE_PNG("image/png", "png"),
    IMAGE_JPEG("image/jpeg", "jpg"),
    GIF("image/gif", "gif"),
    MP3("audio/mpeg", "mp3"),

    TEXT("text/plain", "txt");

    private final String mimeType;

    private final String extension;
}
