package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public class BankStatementCSVParser {
        private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        private BankTransaction parseFromCSV(final String line) {
            final String[] columns = line.split(",");

            final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
            final double amount = Double.parseDouble(columns[1]);
            final String description = columns[2];

            return new BankTransaction(date, amount, description);
        }

        public List<BankTransaction> parseLinesFromCSV(final List<String> lines) {
            final List<BankTransaction> bankTransactions = new ArrayList<>();

            for(final String line: lines) {
                bankTransactions.add(parseFromCSV(line));
            }

            return bankTransactions;
        }
    }

    private static final String RESOURCES = "src/main/resources/";

    public static void main(String[] args) throws IOException {

        final Path path = Paths.get(RESOURCES + args[0]);

        final List<String> lines = Files.readAllLines(path);
        double total = 0d;
        for(final String line: lines) {
            final String[] columns = line.split(",");
            final double amount = Double.parseDouble(columns[1]);
            total += amount;
        }

        System.out.println("The total for all transactions is " + total);
    }
}