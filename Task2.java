import java.io.*;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) throws IOException {

        BufferedReader fileRead = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter fileWrite = new BufferedWriter(new FileWriter("output.txt"));

        Scanner sc = new Scanner(fileRead.readLine());
        fileRead.close();

        int min = (int)(Math.pow(10,5) + 1);
        int max = -1;
        int currentNumber;

        while (sc.hasNext()) {
            currentNumber = sc.nextInt();
            if (currentNumber > max) {
                max = currentNumber;
            }
            if (currentNumber < min) {
                min = currentNumber;
            }
         }

        fileWrite.write(Integer.toString(max - min));
        fileWrite.close();

    }
}
