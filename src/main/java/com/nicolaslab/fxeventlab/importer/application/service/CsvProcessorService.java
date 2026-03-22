package com.nicolaslab.fxeventlab.importer.application.service;

import com.nicolaslab.fxeventlab.importer.application.strategy.CsvLineParserStrategy;
import com.nicolaslab.fxeventlab.importer.domain.event.OperationCreatedEvent;
import com.nicolaslab.fxeventlab.importer.domain.port.out.EventPublisherPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
@RequiredArgsConstructor
@Slf4j
public class CsvProcessorService {

    private final EventPublisherPort publisherPort;
    private final CsvLineParserStrategy parserStrategy;

    public void process(MultipartFile file) {

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(file.getInputStream()))) {

            reader.lines()
                    .skip(1)
                    .forEach(line -> {

                       var parsed = parserStrategy.parse(line);

                       publisherPort.publish(new OperationCreatedEvent(
                               parsed.transactionId(),
                               parsed.customerId()
                            )
                       );
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
