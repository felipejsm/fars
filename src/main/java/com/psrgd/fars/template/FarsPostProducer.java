package com.psrgd.fars.template;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.psrgd.fars.domain.event.AtPostEvent;

@Component
public class FarsPostProducer {

    private final KafkaTemplate<String, AtPostEvent> kafkaTemplate;

    public FarsPostProducer(KafkaTemplate<String, AtPostEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishPost(AtPostEvent event) {
        kafkaTemplate.send("atproto.posts", event.did(), event);
        IO.println("[Fars Producer] Evento enviado para o Kafka: " + event.text());
    }
    
}
