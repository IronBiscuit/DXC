package CharacterLoader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class CharacterLoader {
    private HashMap<Character, Integer> CIMap;
    private HashMap<Integer, Character> ICMap;

    public CharacterLoader(String file) {
        this.CIMap = new HashMap<Character, Integer>();
        this.ICMap = new HashMap<Integer, Character>();
        this.loadFile(file);
    }

    public HashMap<Character, Integer> getCIMap() {
        return this.CIMap;
    }

    public HashMap<Integer, Character> getICMap() {
        return this.ICMap;
    }


    private void loadFile(String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                Character character = line.charAt(0);
                this.ICMap.put(i, character);
                this.CIMap.put(character, i);
                i += 1;
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
