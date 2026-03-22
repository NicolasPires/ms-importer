package com.nicolaslab.fxeventlab.importer.adapters.out.storage;

import com.nicolaslab.fxeventlab.importer.domain.port.out.FileStoragePort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LocalStorageAdapter implements FileStoragePort{

    @Override
    public String upload(String fileName, byte[] content) {
        log.info("Arquivo salvo: {}", fileName);
        return "local://" + fileName;
    }
}
