import asu.model.Task;
import asu.utils.TaskHandler;
import asu.utils.TaskParser;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.List;

@Log4j2
public class Application {
    public static void main(String[] args) throws IOException {
        try {
            List<Task> taskListSmallTest = TaskParser.readTasksFormFile("small-test.in.txt");
            List<Task> taskListLargeTest = TaskParser.readTasksFormFile("large-test.in.txt");
            new TaskHandler().handleAndWriteFileTasks(taskListSmallTest, "small-test.out");
            new TaskHandler().handleAndWriteFileTasks(taskListLargeTest, "large-test.out");


        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
