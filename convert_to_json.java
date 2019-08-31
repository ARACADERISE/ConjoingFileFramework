package convert_to_json.convert_to_json;

import java.io.File;
import java.util.Formatter;

public class convert_to_json {

  private final String quote = "\"";

  public void JSON_IT(String data_to_transfer) {
    try {
      File to_json = new File("//home//runner//info.json");
      Formatter convert = new Formatter(to_json);
      convert.format("%s %s", "{\n\"type\":",this.quote+data_to_transfer+this.quote+"\n}");
      convert.close();
    } catch(Exception e) {
      System.out.println(e);
    }
  }
}
