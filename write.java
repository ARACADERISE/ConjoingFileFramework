package write.write;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.*; 

public class write {

  private String data_is;
  private String insert_by_data;

  public String get_data(String file_con_to, String data_info, boolean can_read) {
    if(can_read) {
      this.insert_by_data = data_info;
      System.out.println("Connected To: " + file_con_to);
      return this.insert_by_data + "\n" + file_con_to;
    } else {
      return "Failed";
    }
  }

  public void write_data(ArrayList<String> data_to_write, ArrayList<String> add_more, boolean is_ready) {
    for(String d: data_to_write) {
      this.data_is = d;
    }
    while(is_ready) {
      try {
        File create_txt_file = new File("//home//runner//info.txt");
        FileWriter write_file = new FileWriter(create_txt_file);
        write_file.write("DATA: "+this.data_is);
        write_file.close();
      } catch(Exception e) {
        System.out.println(e);
      }
      break;
    }
  }
}
