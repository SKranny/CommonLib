package security;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Indexed;
import security.config.SecurityConfig;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Indexed
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Import({SecurityConfig.class})
@EnableFeignClients
public @interface EnableMicroserviceSecurity {
}
