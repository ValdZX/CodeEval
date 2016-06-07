package trash;

import java.util.ArrayList;
import java.util.List;

public class ListIndexTest {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<String>();
        strings.add("qwer");
        strings.add("asdf");
        strings.add("zxcv");
        strings.add("tyui");
        strings.add("ghjk");
        strings.add(0, "1234");
        strings.add(1, "5678");
        System.out.print(strings.toArray().toString());
    }
}
