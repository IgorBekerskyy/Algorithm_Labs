package algo_lab_1;

import java.util.List;

public class AppMain {
    public static final String CSV_FILE_NAME = "plane.csv";

    public static void main(String[] args) {
        WriteAndReadCsvFile.writePlaneToCsvFile(CSV_FILE_NAME);
        List<Plane> planes = WriteAndReadCsvFile.getPlanesFromCsvFile(CSV_FILE_NAME);
        BubbleSorting.bubbleSortingByVolume(planes);
        MergeSorting.mergeSortingByPassengers(planes);
    }

}
