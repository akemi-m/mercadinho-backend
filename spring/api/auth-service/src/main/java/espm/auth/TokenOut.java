package espm.auth;

import lombok.Builder;
import lombok.experimental.Accessors;

@Builder
@Accessors(fluent = true)
public record TokenOut(
        String jwt) {
}
