package convert_to_json.convert_to_json;

import java.io.*;
import java.util.*;

public class convert_to_json {

  private final String quote = "\"";
  private String data_info;
  private String file_read_info;

  public void GET_FILE_READ_INFO(String file_read_info) {
    this.file_read_info = file_read_info;
  }

  public void GET_NAME_INFO(String data_info) {
    this.data_info = data_info;
  }

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
