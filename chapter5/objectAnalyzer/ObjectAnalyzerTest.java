package objectAnalyzer;

import java.util.ArrayList;

/**
 * This program uses reflection to spy on objects
 * @version 5.7.1 2020-4-20
 * @author yefan_jiang
 */
public class ObjectAnalyzerTest {
    public static void main(String[] args) {
        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 1; i <= 5; i++)
        {
            squares.add(i * i);
        }
        System.out.println(new ObjectAnalyzer().toString(squares));
    }
}