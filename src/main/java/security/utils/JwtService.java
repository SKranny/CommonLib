package security.utils;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import security.dto.TokenData;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Slf4j
public class JwtService {
    @Value("${jwt.secret-code}")
    private String secretKey;


    public String getUserNameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public List<String> getRolesFromToken(String token) {
        return getClaimFromToken(token, (Function<Claims, List<String>>) claims -> claims.get("roles", List.class));
    }

    public String getEmailFromToken(String token) {
        return getClaimFromToken(token, claims -> claims.get("email", String.class));
    }

    public Long getIdFromToken(String token) {
        return getClaimFromToken(token, claims -> claims.get("id", Long.class));
    }

    private <T> T getClaimFromToken(String token, Function<Claims, T> claimResolver) {
        return claimResolver.apply(getAllClaimsFromToken(token));
    }

    public TokenData parseToken(String token) {
        return TokenData.builder()
                .id(getIdFromToken(token))
                .email(getEmailFromToken(token))
                .token(token)
                .userName(getUserNameFromToken(token))
                .authorities(getRolesFromToken(token).stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()))
                .build();
    }

    private Claims getAllClaimsFromToken(String token){
        try{
            return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
        }
        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error! Wrong argument passed!");
        }
        catch (SignatureException e) {
            throw new SignatureException("Error! Invalid signature");
        }
        catch (MalformedJwtException e) {
            throw new MalformedJwtException("Error! JWT is invalid!");
        }
        catch (UnsupportedJwtException e) {
            throw new UnsupportedJwtException("Error! JWT is not supported!");
        }
        catch (ExpiredJwtException e){
            throw new RuntimeException("Error! JWT has expired!");
        }

    }
}
