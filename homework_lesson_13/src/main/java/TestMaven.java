import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

import java.util.List;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;
import java.util.Objects;

public class TestMaven {
    public static void main(String[] args) {

        Properties prop = new Properties();
        try (InputStream resourceStream = TestMaven.class.getClassLoader().getResourceAsStream("config.properties")) {
            prop.load(Objects.requireNonNull(resourceStream));
            System.out.println(prop.get("props.local.hello"));
            System.out.println(prop.get("props.mvn.hello"));
        } catch (IOException e) {
            System.err.println("Unable to load properties file: " + "config.properties");
        }


        List<String> fruits = Lists.newArrayList("orange", "banana", "kiwi");
        fruits.forEach(System.out::println);

        List<String> reverseFruits = Lists.reverse(fruits);
        reverseFruits.forEach(System.out::println);

        Multimap<String, String> map = ArrayListMultimap.create();
        map.put("key", "firstValue");
        map.put("key", "secondValue");
        System.out.println(map);
    }
}
