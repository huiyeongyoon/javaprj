package ch03.ex02loop;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class App {
  public static void main(String[] args) throws IOException {

    // String line = ?
    FileInputStream fis = new FileInputStream("res/data.csv");
    Scanner scan = new Scanner(fis);

    scan.nextLine();

    String line;

    while (scan.hasNextLine()) {
      line = scan.nextLine();

      System.out.printf("line : %s\n", line);
      String[] tokens = line.split(",");
      System.out.printf("token : %s\n", Arrays.toString(tokens));

      String name = tokens[0];
      int kor = Integer.parseInt(tokens[1]);
      int eng = Integer.parseInt(tokens[2]);
      int math = Integer.parseInt(tokens[3]);

      System.out.printf("name:%s kor:%d eng:%d math:%d", name, kor, eng, math);

    }

    scan.close();
    fis.close();
  }
}
