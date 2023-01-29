package feignClient;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Indexed;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Indexed
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Import({FeignRequestInterceptor.class})
@EnableFeignClients
public @interface EnableFeignClient {
}
