package com.psrgd.fars.controller;

import java.time.Instant;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.psrgd.fars.domain.event.AtPostEvent;
import com.psrgd.fars.template.FarsPostProducer;

@RestController
@RequestMapping("/api/post")
public class PostController {
    private final FarsPostProducer producer;

    public PostController(final FarsPostProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public String createPost(@RequestParam String text) {
        IO.println("[PostController:createPost] Controller invocado" + text);
        var event = new AtPostEvent("did:plc:manuelbandeira1930", 
         "bandeira.fars.social", text, Instant.now());
         producer.publishPost(event);
         return "Post enviado para Pasárgada com sucesso!"; 
    }
    
}
