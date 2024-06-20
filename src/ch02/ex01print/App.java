package ch02.ex01print;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class App {
  public static void main(String[] args) throws IOException {

    int kor1;
    int kor2;
    int kor3;
    int total;
    double avg;

    kor1 = 30;
    kor2 = 40;
    kor3 = 100;

    total = kor1 + kor2 + kor3;
    avg = total / 3.0;

    System.out.println("┌───────────────────────┐");
    System.out.println("│       성적 출력       │");
    System.out.println("└───────────────────────┘");

    System.out.printf("kor1 : %d\n", kor1);
    System.out.println("kor2 : " + kor2);
    System.out.println("kor3 : " + kor3);
    System.out.println("total : " + total);
    System.out.printf("avg : %6.2f\n", avg); // 6자리 공간 만듬
    System.out.println("────────────────────────");

    // 이런건없음
    // ConsoleOutStream cos = new ConsoleOutputStream();

    // 이미 기본으로 out에 stream이 존재함
    // PrintStream out = new PrintStream(System.out);

    // 경로안정해주면 classpath에 저장된다
    FileOutputStream fos = new FileOutputStream("res/data.txt");

    // autoflush 모와서 printStream보내줄지 아니면 바로 바로 보내줄지 정하는 것 (채팅)
    PrintStream fout = new PrintStream(fos, true, "utf-8");
    fout.printf("%d %d %d", kor1, kor2, kor3);

    fout.close();
    fos.close();

    System.out.println("저장되었습니다");

    // fout.println("hello haha");

    // System.out.write(50);
    // System.out.print(50);
    // System.out.print("34.35");
    // System.out.print("ab\bcd\tef\ng");

  }
}
