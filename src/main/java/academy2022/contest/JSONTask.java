package academy2022.contest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JSONTask {
    public final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static void main(String[] args) throws IOException, ParseException {
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);

        String json = sc.nextLine();

        JSONParser parser = new JSONParser();
        JSONArray jsonProducts = (JSONArray) parser.parse(json);

        List<Product> products = new ArrayList<>();

        Iterator it = jsonProducts.iterator();
        while (it.hasNext()) {
            JSONObject jsonObj = (JSONObject) it.next();
            Product product = new Product((long) jsonObj.get("id"), (String) jsonObj.get("name"),
                    (long) jsonObj.get("price"), LocalDate.parse((String) jsonObj.get("date"), formatter));
            products.add(product);
        }

        Map<String, String> filters = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            String[] line = sc.nextLine().split(" ");
            filters.put(line[0], line[1]);
        }

        List<Product> res = products.stream()
                .filter(elem -> elem.getPrice() >= Integer.parseInt(filters.get("PRICE_GREATER_THAN")) &&
                        elem.getPrice() <= Integer.parseInt(filters.get("PRICE_LESS_THAN")) &&
                        elem.getName().contains(filters.get("NAME_CONTAINS")) &&
                        elem.getDate().isAfter(LocalDate.parse(filters.get("DATE_AFTER"), formatter)) &&
                        elem.getDate().isBefore(LocalDate.parse(filters.get("DATE_BEFORE"), formatter)))
                .sorted((elem1, elem2) -> {
                    if (elem1.getId() > elem2.getId()) {
                        return 1;
                    }
                    else {
                        return -1;
                    }
                })
                .collect(Collectors.toList());

        JSONArray outArray = new JSONArray();
        StringBuilder str = new StringBuilder();

        for (Product elem : res) {
//            JSONObject outObj = new JSONObject();
//            outObj.put("date", elem.getDate().toString());
//            outObj.put("price", elem.getPrice());
//            outObj.put("name", elem.getName());
//            outObj.put("id", elem.getId());

//            outArray.add(outObj);
            str.append(res.toString());
        }
//        str += "]";

        str = new StringBuilder(str.substring(0, str.length() - 2) + "]");

        File outFile = new File("output.txt");
        PrintWriter pw = new PrintWriter(outFile);

        pw.print(str);

        pw.close();
        sc.close();
    }
}

class Product {
    private long id;
    private String name;
    private long price;
    private LocalDate date;

    public Product(long id, String name, long price, LocalDate date) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;
    }

    public Product() {
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "{\"id\": " + id + ", " + "\"name\": " + "\"" + name + "\"" + ", "
                + "\"price\": " + price + ", " + "\"date\": " + "\"" + date.format(JSONTask.formatter) + "\"" + "},";
    }
}
