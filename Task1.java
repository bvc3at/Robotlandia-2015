import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) throws IOException {

        BufferedReader fileRead = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter fileWrite = new BufferedWriter(new FileWriter("output.txt"));

        Scanner sc;

        boolean isThatPossible = false;
        int numOfSubject = (new Scanner(fileRead.readLine()).nextInt());
        int[][] rangeOfDates = new int[numOfSubject][];
        int rangeDateFrom;
        int rangeDateTo;
        int counter;

        if (numOfSubject == 1) {
            isThatPossible = true;
        }

        for (int i = 0; i < rangeOfDates.length; i++) {
            sc = new Scanner(fileRead.readLine());

            rangeDateFrom = sc.nextInt();
            rangeDateTo = sc.nextInt();

            counter = 0;

            rangeOfDates[i] = new int[rangeDateTo-rangeDateFrom+1];

            for (int j = rangeDateFrom; j <= rangeDateTo; j++) {
                rangeOfDates[i][counter++] = j;
            }
        }

        if (numOfSubject == 2) {
            isThatPossible = ((compareArr(rangeOfDates[0], rangeOfDates[1])).length > 0);
        } else if (numOfSubject > 2) {
            int[] currentCompare = rangeOfDates[0];
            for (int i = 1; i < rangeOfDates.length; i++) {
                currentCompare = integerToInt(compareArr(currentCompare, rangeOfDates[i]));
            }
            isThatPossible = currentCompare.length > 0;
        }
        fileRead.close();



        fileWrite.write(((isThatPossible) ? "YES" : "NO"));
        fileWrite.close();



    }

    private static Integer[] compareArr(int[] arr1, int[] arr2) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    list.add(arr1[i]);
                }
            }
        }
        return list.toArray(new Integer[list.size()]);
    }
    private static int[] integerToInt(Integer[] arrInteger) {
        int[] arr = new int[arrInteger.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arrInteger[i];
        }
        return arr;
    }

}
