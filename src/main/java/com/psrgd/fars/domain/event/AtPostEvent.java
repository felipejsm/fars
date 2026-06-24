package com.psrgd.fars.domain.event;

import java.time.Instant;

public record AtPostEvent (String did,
                           String handle,
                           String text,
                           Instant createdAt
){
    
}
