package aws.annotation;

import aws.AwsClient;
import aws.AwsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Indexed
@Import({AwsClient.class, AwsConfiguration.class})
public @interface EnableAwsClient {
}
