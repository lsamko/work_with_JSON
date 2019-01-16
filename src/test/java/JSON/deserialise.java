package JSON;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class deserialise {
    private static final String filePath = "C:\\Users\\l.samko\\Desktop\\jsonDemoFile.json";

    public static void main(String[] args) {
        try {
            // читаем json-файл
            FileReader reader = new FileReader(filePath);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

            // получаем данные из json объекта
            Long id = (Long) jsonObject.get("id");
            System.out.println("The id is: " + id);

            String type = (String) jsonObject.get("type");
            System.out.println("The type is: " + type);

            String name = (String) jsonObject.get("name");
            System.out.println("The name is: " + name);

            Double ppu = (Double) jsonObject.get("ppu");
            System.out.println("The PPU is: " + ppu);

            // получаем массив
            System.out.println("Batters:");
            JSONArray batterArray = (JSONArray) jsonObject.get("batters");
            Iterator i = batterArray.iterator();
            // перебираем все элементы массива отдельно
            while (i.hasNext()) {
                JSONObject innerObj = (JSONObject) i.next();
                System.out.println("ID " + innerObj.get("id") +
                        " type " + innerObj.get("type"));
            }

            System.out.println("Topping:");
            JSONArray toppingArray = (JSONArray) jsonObject.get("topping");
            Iterator j = toppingArray.iterator();
            while (j.hasNext()) {
                JSONObject innerObj = (JSONObject) j.next();
                System.out.println("ID " + innerObj.get("id") +
                        " type " + innerObj.get("type"));
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }
}
