package Coders;

import CustomExceptions.DecodeException;

import java.util.HashMap;

public class Decoder extends ReferenceTable{

    public Decoder(HashMap<Character, Integer> CIMap, HashMap<Integer, Character> ICMap) {
        super(CIMap, ICMap);
    }

    public String decode(String plainText) throws DecodeException {
        Character offsetChar = plainText.charAt(0);

        if (!this.CIMap.containsKey(offsetChar)) {
            throw new DecodeException("Unrecognised offset character");
        }

        Integer offset = this.CIMap.get(offsetChar);
        StringBuilder decodedString = new StringBuilder();

        for (int i = 1; i < plainText.length(); i++) {
            Character currentChar = plainText.charAt(i);

            if (this.CIMap.containsKey(currentChar)) {
                Integer index = this.CIMap.get(currentChar);
                index += offset;

                if (index >= this.tableSize) {
                    index =  index - this.tableSize;
                }

                currentChar = this.ICMap.get(index);
            }

            decodedString.append(currentChar);
        }

        return decodedString.toString();
    }
}
