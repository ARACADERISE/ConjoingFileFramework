package convert_to_json.convert_to_json;

import java.io.*;
import java.util.*;
import write.write.write;

public class convert_to_json {

  private final String quote = "\"";
  private String data_info;
  //private String file_read_info;
  private write w = new write();

  public void GET_NAME_INFO(String data_info) {
    this.data_info = data_info;
  }

  // For "connect"
  public void GET_FILE_READ_INFO(ArrayList<String> file_read_info, String data_to_transfer) {
    try {
      File to_json = new File("//home//runner//info.json");
      Formatter convert = new Formatter(to_json);
      convert.format("%s %s%s %s%S", "{\n\"type\":",this.quote+data_to_transfer+this.quote+",\n",this.quote+data_to_transfer+"_info"+this.quote+":",this.quote+this.data_info+this.quote,",\n"+"\"file_connect_info\":"+this.quote+file_read_info+this.quote+"\n}");
      convert.close();
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
