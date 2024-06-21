package org.example;

import org.example.service.BankStatementAnalyzer;
import org.example.service.BankStatementCSVParser;
import org.example.service.BankStatementParser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        final BankStatementParser bankStatementParser = new BankStatementCSVParser();

        bankStatementAnalyzer.analyze("test.csv", bankStatementParser);
    }

}