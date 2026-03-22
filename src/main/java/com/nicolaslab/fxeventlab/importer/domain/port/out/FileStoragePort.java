package com.nicolaslab.fxeventlab.importer.domain.port.out;

public interface FileStoragePort {
    String upload(String fileName, byte[] content);
}
