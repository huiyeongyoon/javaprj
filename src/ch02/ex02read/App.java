package ch02.ex02read;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class App {
  public static void main(String[] args) throws IOException {
    int kor1;
    int kor2;
    int kor3;

    FileInputStream fis = new FileInputStream("res/data.txt");
    Scanner scan = new Scanner(fis);

    kor1 = scan.nextInt();
    kor2 = scan.nextInt();
    kor3 = scan.nextInt();

    // scanner는 닫아주면 안됨
    scan.close();
    fis.close();

    int total = kor1 + kor2 + kor3;
    double avg = total / 3.0;

    System.out.println("┌───────────────────────┐");
    System.out.println("│       성적 출력       │");
    System.out.println("└───────────────────────┘");

    System.out.println(kor1);
    System.out.println(kor2);
    System.out.println(kor3);
    System.out.printf("총점: %d\n", total);
    System.out.printf("평균: %.2f\n", avg);

    Scanner scan2 = new Scanner(System.in);

    System.out.println("┌───────────────────────┐");
    System.out.println("│       성적 입력       │");
    System.out.println("└───────────────────────┘");

    System.out.println("kor1");
    kor1 = scan2.nextInt();
    System.out.println("kor2");
    kor2 = scan2.nextInt();
    System.out.println("kor3");
    kor3 = scan2.nextInt();

    total = kor1 + kor2 + kor3;
    avg = total / 3.0;

    System.out.println("┌───────────────────────┐");
    System.out.println("│       성적 출력       │");
    System.out.println("└───────────────────────┘");

    System.out.println(kor1);
    System.out.println(kor2);
    System.out.println(kor3);
    System.out.printf("총점: %d\n", total);
    System.out.printf("평균: %.2f\n", avg);

  }
}
