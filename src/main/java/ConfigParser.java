import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class ConfigParser {
    private String fileName;
    private Map<String,String> configMap = new HashMap<String, String>();

    public ConfigParser(String fileName) {
        this.fileName = "src/main/java/" + fileName;//adding a relative path to the filename.
        File file = new File(this.fileName);
        String filePath = file.exists() ? this.fileName : fileName;//conditional to handle running code from terminal.
        Path path = FileSystems.getDefault().getPath(filePath);
        configParser(path);
    }

    /**
     * This method takes in the path of a file, uses Scanner to read lines of this file,manipulate the words gotten
     * in such a way that they can be stored successfully in a map using keys as specified.
     * @param path
     */
    private void configParser(Path path) {
        try(Scanner input = new Scanner(path)) {
            while (input.hasNextLine()) {
                String line = input.nextLine();//reads a whole lin and stores it in a variable line.
                if(line.equals("")) { //checks if read line is empty and if true moves to next line.
                    continue;
                }
                if(line.contains("[")) { //checks if the read line contains [.
                    /*if the line contains [, replace all special characters with a space, remove all leading and trailing
                    spaces and add a . to the line then read the next line.*/
                    line = line.replaceAll("[^a-zA-Z0-9]", " ").trim() + ".";

                    String data = input.nextLine();// reading next line and storing in a variable data.

                    while (input.hasNextLine() && !data.trim().equals("")) {//a loop to keep looking for a next line until an empty line is found
                        String[] arr = data.split("=");/* split data into an array at the equals sign and add line to the
                                                            beginning of the first element of the array using them as key in the map*/

                        String key = line + arr[0];
                        data = input.nextLine();
                        if (configMap.containsKey(key)) {//checking if map already contains the key and if yes, just continue
                            continue;
                        }
                        configMap.put(key, arr[1]); //if map does not contain key, put a new value using the key.
                    }
                } else { //handles case when original line is not empty and does not have a [.
                    String[] arr = line.split("=");
                    if(configMap.containsKey(arr[0])) {
                        continue;
                    }
                    configMap.put(arr[0], arr[1]);
                }
            }
        } catch (NoSuchElementException | IOException e) { //catching Exceptions.
            e.printStackTrace();
        }
    }

    /**
     * This method takes in a key and return the value attached to the key from the Map storage.
     * @param key
     * @return String
     */
    public String get(String key) {
        return configMap.get(key);
    }

}
