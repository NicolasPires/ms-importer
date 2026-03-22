package com.nicolaslab.fxeventlab.importer.application.strategy;

public interface CsvLineParserStrategy {

    ParsedLine parse(String line);
}
