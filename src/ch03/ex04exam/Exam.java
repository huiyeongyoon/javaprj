package ch03.ex04exam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exam {
  public static void main(String[] args) throws FileNotFoundException {
    int indexOf40 = -1;

    FileInputStream fis = new FileInputStream("res/nums.data");
    Scanner scan = new Scanner(fis);

    while (scan.hasNextLine()) {
      if (Integer.parseInt(scan.nextLine()) == 40) {
        break;
      }
    }

    System.out.printf("index is %s", indexOf40);
    scan.close();

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
      }
    }
  }
}
