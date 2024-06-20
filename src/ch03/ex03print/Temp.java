package ch03.ex03print;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Temp {
  public static void main(String[] args) throws IOException {

    System.out.printf("Arguments: %s%n", Arrays.toString(args));

    String name;
    int kor, eng, math;

    FileInputStream fis = new FileInputStream("res/data.csv");
    Scanner scan = new Scanner(fis);

    System.out.println(scan);
    while (scan.hasNextLine()) { // while 블록 시작
      String line = scan.nextLine();

      String[] tokens = line.split(",");
      name = tokens[0];

      // tokens 값이 숫자 형식이 아니라면 초기값 0
      if (!isNumeric(tokens[1])) {
        kor = 0;
      } else {
        kor = Integer.parseInt(tokens[1]);
      }

      // kor 유효성 검사
      if (!(0 <= kor && kor <= 100)) {
        kor = 0;
      }

      if (!isNumeric(tokens[2]))
        eng = 0;
      else {
        eng = Integer.parseInt(tokens[2]);

        if (!(0 <= eng && eng <= 100))
          eng = 0;
      }

      if (!isNumeric(tokens[3]))
        math = 0;
      else {
        math = Integer.parseInt(tokens[3]);

        if (!(0 <= math && math <= 100))
          math = 0;
      }

    } // while 블록 끝
    System.out.println();

    scan.close();
    fis.close();
    System.out.printf("Arguments: %s%n", Arrays.toString(args));

  } // main 함수 끝

  public static boolean isNumeric(String str) {
    try {
      Double.parseDouble(str);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }
}
