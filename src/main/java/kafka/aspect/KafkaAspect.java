package kafka.aspect;

import kafka.annotation.SubmitToKafka;
import kafka.dto.Event;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@RequiredArgsConstructor
public class KafkaAspect {
    @Value("spring.application.name")
    private String serviceName;

    private final KafkaTemplate<Long, Event<?>> kafkaTemplate;

    @SneakyThrows
    @Around("@annotation(submitToKafka)")
    public Object dt (ProceedingJoinPoint joinPoint, SubmitToKafka submitToKafka) {
        Object res = joinPoint.proceed();
        Arrays.stream(submitToKafka.topic()).forEach(topic -> kafkaTemplate.send(topic, buildEvent(res)));
        return res;
    }

    private Event<?> buildEvent(Object obj) {
        return Event.builder()
                .serviceName(serviceName)
                .content(obj)
                .build();
    }

}
