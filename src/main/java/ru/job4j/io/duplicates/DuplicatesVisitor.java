package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.Set;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private Set<FileProperty> fileProperties = new HashSet<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(file.toFile().length(), file.getFileName().toString(), file.toAbsolutePath().toString());
        if (!fileProperties.add(fileProperty)) {
            System.out.println(fileProperty);
            FileProperty fp = fileProperties.stream()
                    .filter(fileProperty1 -> fileProperty1.equals(fileProperty))
                    .findFirst()
                    .get();
            System.out.println("Дубликат: " + fp);

        }
        return super.visitFile(file, attrs);
    }
}
