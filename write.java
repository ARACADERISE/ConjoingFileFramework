package write.write;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class write {

  public Scanner get_dir = new Scanner(System.in);

  public void write_data(ArrayList<String> data_to_write, ArrayList<String> add_more, boolean is_ready) {
    System.out.print("(FULL)Directory of .txt file >> ");
    String dir = get_dir.nextLine();
    while(is_ready) {
      try {
        Formatter writing = new Formatter(dir);
        writing.format("%s",data_to_write);
        writing.close();
      } catch (Exception e) {
        System.out.println(e);
      }
      break;
    }
  }
}
