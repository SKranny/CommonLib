package kafka.aspect;

import kafka.annotation.SubmitToKafka;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaAspect {
    private final KafkaTemplate<Long, Object> kafkaTemplate;

    @SneakyThrows
    @Around("@annotation(submitToKafka)")
    public Object dt (ProceedingJoinPoint joinPoint, SubmitToKafka submitToKafka) {
        Object res = joinPoint.proceed();
        Arrays.stream(submitToKafka.topic()).forEach(topic -> kafkaTemplate.send(topic, res));
        log.info(String.format("Object [%s] has been submitted!", res));
        return res;
    }
}
