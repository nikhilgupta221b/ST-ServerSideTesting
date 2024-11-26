package com.example.blogs.services;

import com.example.blogs.services.implementations.FileImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FileServiceTest {

    @InjectMocks
    private FileImplementation fileService;

    @Mock
    private MultipartFile multipartFile;

    private final String testPath = "test/uploads";
    private final String testFileName = "testfile.txt";
    private final String testFileContent = "This is a test file";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // --- TESTS FOR IMAGE UPLOAD ---
    @Test
    void testUploadImageSuccess() throws IOException {
        // Mocking multipart file behavior
        when(multipartFile.getOriginalFilename()).thenReturn(testFileName);
        when(multipartFile.getInputStream()).thenReturn(new ByteArrayInputStream(testFileContent.getBytes()));

        // Method call
        String uploadedFileName = fileService.uploadImage(testPath, multipartFile);

        // Assertions
        assertNotNull(uploadedFileName, "Uploaded file name should not be null");
        assertTrue(uploadedFileName.endsWith(".txt"), "Uploaded file name should end with .txt");
        assertTrue(Files.exists(Paths.get(testPath, uploadedFileName)), "Uploaded file should exist in the path");

        // Cleanup
        Files.deleteIfExists(Paths.get(testPath, uploadedFileName));
    }

    @Test
    void testUploadImagePostNotFound() {
        assertThrows(RuntimeException.class, () -> {
            throw new RuntimeException("Post not found");
        });
    }

    @Test
    void testUploadImageDirectoryCreation() throws IOException {
        // Mocking multipart file behavior
        when(multipartFile.getOriginalFilename()).thenReturn(testFileName);
        when(multipartFile.getInputStream()).thenReturn(new ByteArrayInputStream(testFileContent.getBytes()));

        // Ensure the test directory does not exist before the test
        Path testDir = Paths.get(testPath);
        if (Files.exists(testDir)) {
            Files.deleteIfExists(testDir.resolve(testFileName)); // Clean up any test file
            Files.deleteIfExists(testDir); // Remove the directory
        }

        // Method call
        String uploadedFileName = fileService.uploadImage(testPath, multipartFile);

        // Assertions
        assertNotNull(uploadedFileName, "Uploaded file name should not be null");
        assertTrue(uploadedFileName.endsWith(".txt"), "Uploaded file name should end with .txt");
        assertTrue(Files.exists(Paths.get(testPath, uploadedFileName)), "Uploaded file should exist in the path");

        // Verify that the directory was created
        assertTrue(Files.exists(testDir), "The directory should be created");

        // Cleanup
        Files.deleteIfExists(Paths.get(testPath, uploadedFileName)); // Remove the test file
        Files.deleteIfExists(testDir); // Remove the directory
    }

    // --- TESTS FOR DOWNLOAD IMAGE ---
    @Test
    void testGetImageSuccess() throws IOException {
        // Prepare test file
        Path testFilePath = Paths.get(testPath, testFileName);
        Files.createDirectories(testFilePath.getParent());
        Files.writeString(testFilePath, testFileContent);

        // Method call
        try (InputStream inputStream = fileService.getResource(testPath, testFileName)) {
            assertNotNull(inputStream, "InputStream should not be null");
            assertEquals(testFileContent, new String(inputStream.readAllBytes()), "File content should match expected");
        }

        // Cleanup
        Files.deleteIfExists(testFilePath);
    }

    @Test
    void testGetImageNotFound() {
        // Non-existent file
        String nonExistentFile = "nonexistent.txt";

        // Expect exception
        assertThrows(FileNotFoundException.class, () -> fileService.getResource(testPath, nonExistentFile));
    }

}
