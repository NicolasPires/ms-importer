package com.nicolaslab.fxeventlab.importer.domain.port.out;

import com.nicolaslab.fxeventlab.importer.domain.event.OperationCreatedEvent;

public interface EventPublisherPort {
    void publish(OperationCreatedEvent event);
}
