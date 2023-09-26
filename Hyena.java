import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Hyena extends Animal {
    // Create fields.
    private String name;

    // Create Getter and Setter methods to access the private fields
    public String getName() {
        return name;
    }
    // Create Getter and Setter methods to access the private fields
    public void setName(String theName) {
        name = theName;
    }

    // Create an ArrayList to store the split values read from animalNames.txt
    private static List<String> myListOfHyenaNames = new ArrayList<>();

    // Create a static member variable that accumulates the number of hyenas created.
    private static int numOfHyenas = 0;

    // Create a constructor that will increment numOfHyenas when a new Hyena object is created.
    public Hyena() {
        System.out.println("\n A new Hyena object was created!!!");
        numOfHyenas++;
    }

    // Create a method that inputs hyena names from a file named: animalNames.txt
    public static void inputHyenaNames()  {
        // Define the file path
        String filePath = "C:\\2023_fall\\javaPrograms\\animalNames.txt";

        try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath));
             Scanner scanner = new Scanner(System.in)) {
            String line;
            int lineNum = 1;
            while ((line = fileReader.readLine()) != null) {

                if (lineNum == 3) {
                    // Split the line into an array of values using a comma as the delimiter
                    String[] values = line.split(",");
                    // Process the values and add them to the ArrayList
                    for (String value : values) {
                        myListOfHyenaNames.add(value.trim()); // Trim removes leading/trailing spaces
                    }
                }
                lineNum++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // output the list.
    public static void listOut() {
        for (String name : myListOfHyenaNames) {
            System.out.println(name);
        }
    }
    // write a Getter method.
    public int getNumOfHyenas() {
        return numOfHyenas;
    }

    // Create a public method that gets a hyena name from the list and pops the value off the list.
    public String assignHyenaName() {
        return myListOfHyenaNames.get(0);
        // Remove the name from the list so it is not used again.
    }

}
