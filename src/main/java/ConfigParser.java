import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class ConfigParser {
    private String fileName;
    private Map<String,String> configMap = new HashMap<String, String>();

    public ConfigParser(String fileName) {
        this.fileName = "src/main/java/" + fileName;
        Path path = FileSystems.getDefault().getPath(this.fileName);
        try(Scanner input = new Scanner(path)) {
            while (input.hasNextLine()) {
                String line = input.nextLine();
                if(line.equals("")) {
                    continue;
                }
                if(line.contains("[")) {
                    line = line.replaceAll("[^a-zA-Z0-9]", " ").trim() + ".";
//                    System.out.println(line);
                    String[] arr = input.nextLine().split("=");
                    String key = line + arr[0];
                    if(configMap.containsKey(key)) {
                        continue;
                    }
                    configMap.put(key,arr[1]);
                } else {
                String[] arr = line.split("=");
                    if(configMap.containsKey(arr[0])) {
                        continue;
                    }
                    configMap.put(arr[0], arr[1]);
                }
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(configMap);

    }

    public String get(String key) {
        return configMap.get(key);
    }

}
