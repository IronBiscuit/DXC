package Coders;

import CustomExceptions.EncodeException;

import java.util.HashMap;


public class Encoder extends ReferenceTable {

    public Encoder(HashMap<Character, Integer> CIMap, HashMap<Integer, Character> ICMap) {
        super(CIMap, ICMap);
    }

    public String encode(String plainText, Character offsetChar) throws EncodeException {
        if (!this.CIMap.containsKey(offsetChar)) {
            throw new EncodeException("Unrecognised offset character");
        }

        Integer offset = this.CIMap.get(offsetChar);
        StringBuilder encodedString = new StringBuilder();
        encodedString.append(offsetChar);

        for (int i = 0; i < plainText.length(); i++) {
            Character currentChar = plainText.charAt(i);

            if (this.CIMap.containsKey(currentChar)) {
                Integer index = this.CIMap.get(currentChar);
                index -= offset;

                if (index < 0) {
                    index = this.tableSize + index;
                }

                currentChar = this.ICMap.get(index);

            }

            encodedString.append(currentChar);
        }

        return encodedString.toString();
    }
}
