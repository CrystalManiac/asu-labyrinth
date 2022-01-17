package asu.utils;

import asu.model.Task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskParser {
    public static List<Task> readTasksFormFile(String filename) throws IOException {
        final String resourcesPath = "src/main/resources/input/";
        File file = new File(String.format(resourcesPath+"%s", filename));
        String absolutePath = file.getAbsolutePath();

        List<Task> taskList = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(absolutePath));
        reader.readLine();
        String line = reader.readLine();

        while (line != null){
            String[] ways = line.split(" ");
            Task task = new Task(ways[0], ways[1]);
            taskList.add(task);
            line = reader.readLine();
        }
        return taskList;
    }
}
