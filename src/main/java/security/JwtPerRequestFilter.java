package security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import security.utils.JwtService;
import security.utils.TokenUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JwtPerRequestFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = TokenUtil.parseToken(request);

        if (Optional.ofNullable(token).isPresent()) {
            TokenAuthentication details = new TokenAuthentication(jwtService.parseToken(token));
            SecurityContextHolder.getContext().setAuthentication(details);
        }

        filterChain.doFilter(request, response);
    }
}
