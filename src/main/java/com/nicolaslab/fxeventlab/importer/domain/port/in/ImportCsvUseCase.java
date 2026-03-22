package com.nicolaslab.fxeventlab.importer.domain.port.in;

import org.springframework.web.multipart.MultipartFile;

public interface ImportCsvUseCase {
    void execute(MultipartFile file);
}
