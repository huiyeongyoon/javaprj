package ch03.ex01string;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class App {
  public static void main(String[] args) throws IOException {

    // String line = ?
    FileInputStream fis = new FileInputStream("res/data.csv");
    Scanner scan = new Scanner(fis);

    scan.nextLine();
    String line;
    {
      line = scan.nextLine();

      String[] tokens = line.split(",");

      String name = tokens[0];
      int kor = Integer.parseInt(tokens[1]);
      int eng = Integer.parseInt(tokens[2]);
      int math = Integer.parseInt(tokens[3]);

      System.out.printf("name:%s kor:%d eng:%d math:%d", name, kor, eng, math);
    }

    {
      line = scan.nextLine();

      String[] tokens = line.split(",");

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
