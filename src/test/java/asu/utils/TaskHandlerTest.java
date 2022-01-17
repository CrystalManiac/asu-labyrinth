package asu.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskHandlerTest {

    @Test
    void maze() {
        String[] split = "WRWWLWWLWWLWLWRRWRWWWRWWRWLW WWRRWLWLWWLWWLWWRWWRWWLW".split(" ");
        String entrance_to_exit = split[0];
        String exit_to_entrance = split[1];
        String maze = new TaskHandler().maze(entrance_to_exit, exit_to_entrance);
        String result = "ac5\n" + "386\n" + "9c7\n" + "e43\n" + "9c5\n";
        assertEquals(result, maze);
    }
}