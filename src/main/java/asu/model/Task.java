package asu.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class Task {
    @NonNull
    private String forward;
    @NonNull
    private String backward;
}
