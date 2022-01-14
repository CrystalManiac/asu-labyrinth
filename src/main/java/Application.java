import asu.utils.TaskParser;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Log4j2
public class Application {
    public static void main(String[] args) {
        try {
            System.out.println(TaskParser.readTasksFormFile("small-test.in.txt"));
        }
        catch (IOException e){
            log.error(e.getMessage());
        }
    }
}
