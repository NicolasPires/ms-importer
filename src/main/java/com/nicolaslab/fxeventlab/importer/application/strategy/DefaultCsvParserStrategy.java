package com.nicolaslab.fxeventlab.importer.application.strategy;

import org.springframework.stereotype.Component;

@Component
public class DefaultCsvParserStrategy implements CsvLineParserStrategy{

    @Override
    public ParsedLine parse(String line) {
        String[] fields = line.split(",");

        return new ParsedLine(
                fields[0],
                Integer.valueOf(fields[1])
        );
    }
}
