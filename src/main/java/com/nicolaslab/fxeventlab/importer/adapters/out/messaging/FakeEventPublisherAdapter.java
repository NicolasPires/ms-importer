package com.nicolaslab.fxeventlab.importer.adapters.out.messaging;

import com.nicolaslab.fxeventlab.importer.domain.event.OperationCreatedEvent;
import com.nicolaslab.fxeventlab.importer.domain.port.out.EventPublisherPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FakeEventPublisherAdapter implements EventPublisherPort {
    @Override
    public void publish(OperationCreatedEvent event) {
        log.info("Evento publicado {}", event);
    }
}
