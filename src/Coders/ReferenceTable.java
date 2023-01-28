package Coders;

import java.util.HashMap;

public class ReferenceTable {
    public HashMap<Character, Integer> CIMap;
    public HashMap<Integer, Character> ICMap;
    public int tableSize;

    public ReferenceTable(HashMap<Character, Integer> CIMap, HashMap<Integer, Character> ICMap) {
        this.CIMap = CIMap;
        this.ICMap = ICMap;
        this.tableSize = CIMap.size();
    }

}
