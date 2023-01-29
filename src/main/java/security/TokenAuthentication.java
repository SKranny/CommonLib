package security;

import lombok.Getter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import security.dto.TokenData;

@Getter
public class TokenAuthentication extends UsernamePasswordAuthenticationToken {
    private TokenData tokenData;

    public TokenAuthentication(TokenData tokenData) {
        super(tokenData.getUserName(), null, tokenData.getAuthorities());
        this.tokenData = tokenData;
    }
}
