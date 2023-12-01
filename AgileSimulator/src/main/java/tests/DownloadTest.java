package tests;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import scrum_sim_packages.*;

import java.io.FileReader;
import java.io.IOException;

import static Helpers.ExportToCSV.convertToCSV;
import static org.junit.jupiter.api.Assertions.*;

public class DownloadTest {
    ExportTOJSONTests obj = new ExportTOJSONTests();
    @Test
    void testConvertToCSV() {
        String csvFilePath = "test_output.csv";
        SimulationSession mockSession = obj.CreateSample();
        convertToCSV(mockSession, csvFilePath);
        assertFileContent(csvFilePath);
    }
    @Test
    void testNoName() throws Exception {
        // Arrange
        String csvFilePath = "";
        SimulationSession mockSession = obj.CreateSample();
        assertThrows(Exception.class,Converter(csvFilePath,mockSession));
    }
    @Test
    void testInvalidFileType() throws Exception {
        // Arrange
        String csvFilePath = "user1";
        SimulationSession mockSession = obj.CreateSample();
        assertThrows(Exception.class,Converter(csvFilePath,mockSession));
    }

    private Executable Converter(String name, SimulationSession sim) throws Exception {
        try{
            convertToCSV(sim,name);
        }
        catch(Exception exception){
            throw new Exception();
        }
        return null;
    }
    private void assertFileContent(String csvFilePath) {
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(csvFilePath)).build()) {
            String[] header = reader.readNext();
            assertNotNull(header);
            assertEquals("name", header[0]);
        } catch (IOException e) {
            fail("Error in CSV file: " + e.getMessage());
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
