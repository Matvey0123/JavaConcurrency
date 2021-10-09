import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        ListOperator listOperator = new ListOperator();
        Thread thread = new Thread(new Sorter(listOperator));
        thread.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputData = reader.readLine();
        while (inputData.compareTo("") != 0) {
            listOperator.add(inputData);
            inputData = reader.readLine();
        }
        listOperator.print();
    }
}
