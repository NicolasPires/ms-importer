package com.nicolaslab.fxeventlab.importer.adapters.in.api;

import com.nicolaslab.fxeventlab.importer.application.usecase.ImportCsvUseCaseImpl;
import com.nicolaslab.fxeventlab.importer.domain.port.in.ImportCsvUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/v1/import")
@RequiredArgsConstructor
public class ImportController {

    private final ImportCsvUseCase useCase;

    @PostMapping
    public ResponseEntity<Void> upload(@RequestParam("file") MultipartFile file) {
        useCase.execute(file);
        return ResponseEntity.accepted().build();
    }
}
