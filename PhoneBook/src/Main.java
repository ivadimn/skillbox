import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.*;

public class Main {

    public static final int PHONE_NUMBER_LENGTH = 11;
    public static final String PHONE_NUMBER_SYMBOLS = "+-()0123456789 ";

    private static TreeMap<String, List<String>> phoneBook1 = new TreeMap<>();
    public static void main(String[] args) throws IOException {
        String input;
        String number;
        String name;
        List<String> numbers;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(;;) {
            System.out.println("Введите номер телефона или имя : ");
            input = reader.readLine().trim();
            if (input.equalsIgnoreCase("exit")) break;
            if (input.equalsIgnoreCase("export")) {
                System.out.println("Введите путь и имя файла для сохранения телефонной книги : ");
                String path = reader.readLine().trim();
                if (path.length() > 0) {
                    export(path);
                }
                continue;
            }
            if (input.equalsIgnoreCase("LIST")) {
                printBook1();
                continue;
            }

            if (!isPhoneNumber(input)) {
                name = input;
                numbers = phoneBook1.get(name);
                if (numbers != null) {
                    printNumbers(name);
                }
                else {
                    System.out.println("Номеров по имени " + name + " не найден, введите номер: ");
                    input = reader.readLine().trim();
                    number = normalizeNumber(input);
                    if (!number.isEmpty()) {
                        addNumber(name, number);
                        System.out.println("Номер : " + input + " сохранен в телефонной книге с именем " + name);
                    }
                    else {
                        System.out.println("Пустой номер");
                    }
                }

            }
            else {
                number = normalizeNumber(input);
                name = getName(number);
                if (name != null) {
                    System.out.println("По номеру : " + number + " найдено имя " +  name);
                }
                else {
                    System.out.println("Имя для " + input + " не найдено введите имя ");
                    input = reader.readLine().trim();
                    addNumber(input, number);
                    System.out.println("Номер телефона - " + number + " сохранён в имени " + input);
                }
            }

        }
    }

    public static void addNumber(String name, String number) {
        List<String> phoneList = phoneBook1.get(name);
        if (phoneList == null) {
            phoneList = new ArrayList<>();
            phoneList.add(number);
            phoneBook1.put(name, phoneList);
        }
        else {
            phoneList.add(number);
        }
    }

   public static String getName(String number) {
       for (String name : phoneBook1.keySet()) {
           if (phoneBook1.get(name).contains(number)) {
               return name;
           }
       }
       return null;
   }

   public static void printBook1() {
        for (String key : phoneBook1.keySet()) {
            printNumbers(key);
        }
   }

   public static void printNumbers(String name) {
        System.out.println("Номера телефонов на имя " + name + " :");
        for (String num : phoneBook1.get(name)) {
            System.out.println("\t" + num);
        }
   }

    private static boolean isPhoneNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (PHONE_NUMBER_SYMBOLS.indexOf(input.charAt(i)) < 0) {
                return false;
            }
        }
        return true;
    }

    private static String normalizeNumber(String number) {
        return number.replaceAll("[\\D]+","");
    }

    private static void export(String path) throws IOException {
        JSONObject book = new JSONObject();
        for (String name : phoneBook1.keySet()) {
            JSONArray numberArray = new JSONArray();
            numberArray.addAll(phoneBook1.get(name));
            book.put(name, numberArray);
        }
        String strbook = JSONObject.toJSONString(book);
        System.out.println(strbook);
        FileWriter fr = new FileWriter(new File(path));
        fr.write(strbook);
        fr.flush();
        fr.close();
    }
}
