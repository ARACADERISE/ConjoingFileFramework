package convert_to_json.convert_to_json;

import java.io.*;
import java.util.*;
import write.write.write;

public class convert_to_json {

  private final String quote = "\"";
  private String data_info;
  //private String file_read_info;
  private write w = new write();

  // Makes seperate file for read information about the connected file
  public void make_file(String file, ArrayList<String> data) {
    try {
      File store_file_data = new File("//home//runner//file_info.txt");
      Formatter store = new Formatter(store_file_data);
      store.format("%s\n\n %s", "<< FORMATTED IN ARRAYLIST >>",data);
      store.close();
    } catch(Exception e) {
      System.out.println(e);
    }
  }

  public void GET_NAME_INFO(String data_info) {
    this.data_info = data_info;
  }

  // For "connect"
  public void GET_FILE_READ_INFO(String file_name,ArrayList<String> file_read_info, String data_to_transfer) {
    try {
      File to_json = new File("//home//runner//info.json");
      Formatter convert = new Formatter(to_json);
      convert.format("%s %s%s %s%S", "{\n\"type\":",this.quote+data_to_transfer+this.quote+",\n",this.quote+data_to_transfer+"_info"+this.quote+":",this.quote+this.data_info+this.quote,",\n"+"\"stored_in_file\":"+this.quote+"file_info.txt"+this.quote+"\n}");
      convert.close();
      // Making another file for the file connection data
      make_file(file_name,file_read_info);
    } catch(Exception e) {
      System.out.println(e);
    }
  }

  // For "port" and "reg"
  public void JSON_IT(String data_to_transfer) {
    try {
      File to_json = new File("//home//runner//info.json");
      Formatter convert = new Formatter(to_json);
      convert.format("%s %s%s %s", "{\n\"type\":",this.quote+data_to_transfer+this.quote+",\n",this.quote+data_to_transfer+"_info"+this.quote+":",this.quote+this.data_info+this.quote+"\n}");
      convert.close();
    } catch(Exception e) {
      System.out.println(e);
    }
  }
}
