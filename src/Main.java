import java.io.File;
import java.util.HashMap;

import CharacterLoader.CharacterLoader;
import Coders.Decoder;
import Coders.Encoder;
import CustomExceptions.DecodeException;
import CustomExceptions.EncodeException;
class Main {

    private static Boolean checkValidParams(String[] args) {
        if (args.length < 2 || args.length > 3) {
            return false;
        }

        String command = args[0].toLowerCase();
        if (command.equals("decode") && args.length == 2) {
            return true;
        } else return command.equals("encode") && args.length == 3 && args[2].length() == 1;

    }
    public static void main(String[] args) {
        String filepath = new File("").getAbsolutePath();
        filepath = filepath.concat("/characters.txt");
        CharacterLoader cl = new CharacterLoader(filepath);
        HashMap<Character, Integer> CIMap = cl.getCIMap();
        HashMap<Integer, Character> ICMap = cl.getICMap();

        Encoder encoder = new Encoder(CIMap, ICMap);
        Decoder decoder = new Decoder(CIMap, ICMap);

        if (!checkValidParams(args)) {
            System.out.println("Error: Invalid Parameters Specified");
            System.exit(0);
        }

        String command = args[0].toLowerCase();
        String text = args[1];
        try {
            String result;

            if (command.equals("encode")) {
                Character offset = args[2].charAt(0);
                result = encoder.encode(text, offset);
            } else {
                result = decoder.decode(text);
            }

            System.out.println(result);
        } catch (EncodeException | DecodeException e) {
            System.out.println(e.getMessage());
        }

        System.exit(0);
    }
}