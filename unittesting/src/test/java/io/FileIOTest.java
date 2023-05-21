package io;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FileIOTest {

    static FileIO fileIO;
    public static String resourcesDirectory = "src/test/resources/";

    @Before
    public void setUp() {
        fileIO = new FileIO();
    }

    @Test
    public void testReadFile() {
        int[] expectedNumbers = {3, 6, 7, 9, 0, 1, 4};
        String filePath = resourcesDirectory + "numbers_test.txt";
        int[] actualNumbers = fileIO.readFile(filePath);
        Assert.assertArrayEquals(expectedNumbers, actualNumbers);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testReadFileNonExistentFileException() {
        String filePath = resourcesDirectory + "nonExistentFile.txt";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Input file does not exist");
        fileIO.readFile(filePath);
    }

    @Test
    public void testReadFileEmptyFileException() {
        String filePath = resourcesDirectory + "empty_test.txt";
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Given file is empty");
        fileIO.readFile(filePath);
    }

    @Test
    public void testReadFileContainsInvalidEntries() {
        int[] expectedNumbers = {6, 0, 9, 4, 2, 0} ;
        String filePath = resourcesDirectory + "invalid_entries_test.txt";
        int[] actualNumbers = fileIO.readFile(filePath);
        Assert.assertArrayEquals(expectedNumbers, actualNumbers);
    }



}
