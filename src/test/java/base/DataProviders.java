package base;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DataProviders {
    @DataProvider(name = "wrongUsers")
    public Object[][] readWrongUsers() {
        try {
            CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/wrongUsers.csv"));
            List<String[]> csvData = csvReader.readAll();
            Object[][] csvDataObject = new Object[csvData.size()][2];

            for (int i = 0; i < csvData.size(); i++) {
                csvDataObject[i] = csvData.get(i);
            }
            return csvDataObject;

        } catch (IOException e) {
            System.out.println(e);
            return null;
        } catch (CsvException e) {
            System.out.println(e);
            return null;
        }
    }
        @DataProvider(name = "items to be added")
        public Object[] getItems () {
            return new Object[]{
                    "bike-light",
                    "bolt-t-shirt",
                    "onesie"
            };
        }
}

