package asu.utils;

import asu.model.Task;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
class Direction {
    private int x;
    private int y;
}

public class TaskHandler {
    final String resourcesPath = "src/main/resources/output/";


    private final int NORTH = 1;
    private final int SOUTH = 2;
    private final int WEST = 4;
    private final int EAST = 8;

    private HashMap<Integer, Direction> OFFSETS = new HashMap<>();
    private HashMap<Integer, Integer> OPPOSITES = new HashMap<>();
    private HashMap<Integer, Integer> LEFTS = new HashMap<>();
    private HashMap<Integer, Integer> RIGHTS = new HashMap<>();

    public TaskHandler() {
        prepareData();
    }


    private void prepareData() {

        OFFSETS.put(NORTH, new Direction(0, -1));
        OFFSETS.put(SOUTH, new Direction(0, 1));
        OFFSETS.put(WEST, new Direction(-1, 0));
        OFFSETS.put(EAST, new Direction(1, 0));


        OPPOSITES.put(NORTH, SOUTH);
        OPPOSITES.put(SOUTH, NORTH);
        OPPOSITES.put(WEST, EAST);
        OPPOSITES.put(EAST, WEST);


        LEFTS.put(NORTH, WEST);
        LEFTS.put(WEST, SOUTH);
        LEFTS.put(SOUTH, EAST);
        LEFTS.put(EAST, NORTH);


        RIGHTS.put(NORTH, EAST);
        RIGHTS.put(EAST, SOUTH);
        RIGHTS.put(SOUTH, WEST);
        RIGHTS.put(WEST, NORTH);
    }


    public String maze(String entrance_to_exit, String exit_to_entrance) {
        HashMap<Direction, Integer> maze = new HashMap<>();
        Direction ints = OFFSETS.get(NORTH);
        int x = ints.getX();
        int y = ints.getY();
        int direction = SOUTH;


        for (String path : Arrays.asList(entrance_to_exit, exit_to_entrance)) {
            for (Character c : path.toCharArray()) {
                if (c == 'W') {
                    Direction ints1 = OFFSETS.get(direction);

                    int dx = ints1.getX();
                    int dy = ints1.getY();

                    x += dx;
                    y += dy;

                    Direction key = new Direction(x, y);
                    if (maze.containsKey(key)) {
                        Integer value = maze.get(key);
                        maze.put(key, value | OPPOSITES.get(direction));
                    } else {
                        maze.put(key, OPPOSITES.get(direction));

                    }

                } else if (c == 'L') {
                    direction = LEFTS.get(direction);
                } else if (c == 'R') {
                    direction = RIGHTS.get(direction);
                } else
                    throw new IllegalArgumentException(String.format("unexpected char '%s' in input.", c));

            }
            direction = OPPOSITES.get(direction);
            maze.remove(new Direction(x, y));

        }
        ArrayList<Integer> xs = maze.keySet().stream().map(Direction::getX).distinct().sorted().collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> ys = maze.keySet().stream().map(Direction::getY).distinct().sorted().collect(Collectors.toCollection(ArrayList::new));

        StringBuilder result = new StringBuilder();

        for (int yZZ : ys) {
            for (int xZZ : xs) {
                result.append(String.format("%x", maze.get(new Direction(xZZ, yZZ))));
            }
            result.append("\n");
        }
        System.out.println(result);
        return result.toString();

    }

    public void handleAndWriteFileTasks(List<Task> tasks, String fileName) throws IOException {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String strDate = dateFormat.format(date)
                .replaceAll(" ", "_")
                .replaceAll(":", "_");
        String fileNameWithDate = fileName + strDate;

        FileUtil.createFile(resourcesPath, fileNameWithDate, "txt");

        StringBuilder sb = new StringBuilder();
        for (Task task : tasks) {
            sb.append(maze(task.getForward(), task.getBackward()));
            sb.append("\n");
        }
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(String.format(resourcesPath + "%s.txt", fileNameWithDate)))
        ) {
            writer.write(sb.toString());
        }
    }

}
