package com.nicolaslab.fxeventlab.importer.application.usecase;

import com.nicolaslab.fxeventlab.importer.application.exception.ImportCsvException;
import com.nicolaslab.fxeventlab.importer.application.service.CsvProcessorService;
import com.nicolaslab.fxeventlab.importer.domain.port.in.ImportCsvUseCase;
import com.nicolaslab.fxeventlab.importer.domain.port.out.FileStoragePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ImportCsvUseCaseImpl implements ImportCsvUseCase {

    private final FileStoragePort storagePort;
    private final CsvProcessorService csvProcessorService;

    @Override
    public void execute(MultipartFile file) {
        try {
            storagePort.upload(file.getOriginalFilename(), file.getBytes());

            csvProcessorService.process(file);
        } catch (Exception e) {
            throw new ImportCsvException("Falha ao importar arquivo CSV", e);
        }
    }
}
