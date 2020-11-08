package algo_lab_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteAndReadCsvFile {

    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final int NAME_OF_PLANE = 0;
    private static final int VOLUME_OF_FUEL_THANKS_IN_LITERS = 1;
    private static final int PASSENGER_CAPACITY = 2;

    private static final String FILE_HEADER = "name,volumeInLiters,passengers";

    protected static void writePlaneToCsvFile(String fileName) {

        Plane plane = new Plane("Plane", 27D, 300);
        Plane plane1 = new Plane("Plane1", 40D, 200);
        Plane plane2 = new Plane("Plane2", 28D, 250);
        Plane plane3 = new Plane("Plane3", 21D, 260);
        Plane plane4 = new Plane("Plane4", 32D, 240);
        Plane plane5 = new Plane("Plane5", 19D, 310);
        Plane plane6 = new Plane("Plane6", 21.2D, 220);
        Plane plane7 = new Plane("Plane7", 36D, 290);
        Plane plane8 = new Plane("Plane8", 27D, 197);
        Plane plane9 = new Plane("Plane9", 28.5D, 199);
        Plane plane10 = new Plane("Plane10", 36D, 214);
        Plane plane11 = new Plane("Plane11", 28.67D, 237);

        List<Plane> planes = new ArrayList<>();
        planes.add(plane);
        planes.add(plane1);
        planes.add(plane2);
        planes.add(plane3);
        planes.add(plane4);
        planes.add(plane5);
        planes.add(plane6);
        planes.add(plane7);
        planes.add(plane8);
        planes.add(plane9);
        planes.add(plane10);
        planes.add(plane11);

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
            fileWriter.append(FILE_HEADER);
            fileWriter.append(NEW_LINE_SEPARATOR);

            for (Plane planeToCsv : planes) {
                fileWriter.append(String.valueOf(planeToCsv.getName()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(planeToCsv.getVolumeInLiters().toString());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(planeToCsv.getPassengers().toString());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }

            System.out.println("No error");

        } catch (Exception e) {
            System.out.println(" Error !");
            e.printStackTrace();
        } finally {
            try {
                assert fileWriter != null;
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error with closing fileWriter");
                e.printStackTrace();
            }
        }
    }

    protected static List<Plane> getPlanesFromCsvFile(String fileName) {
        BufferedReader fileReader = null;
        List<Plane> planes = new ArrayList<>();
        try {
            String line = "";
            fileReader = new BufferedReader(new FileReader(fileName));
            fileReader.readLine();

            while ((line = fileReader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length > 0) {
                    Plane student = new Plane(tokens[NAME_OF_PLANE],
                            Double.parseDouble(tokens[VOLUME_OF_FUEL_THANKS_IN_LITERS]),
                            Integer.parseInt(tokens[PASSENGER_CAPACITY]));
                    planes.add(student);
                }
            }
        } catch (Exception e) {
            System.out.println("Error ");
            e.printStackTrace();
        } finally {
            try {
                assert fileReader != null;
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error when closing fileReader");
                e.printStackTrace();
            }
        }
        return planes;
    }
}
