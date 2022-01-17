package asu.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LabyrinthWays {
    N("1", "Север"),
    S("2", "Юг"),
    NS("3", "Север-Юг"),
    W("4", "Запад"),
    NW("5", "Север-Запад"),
    SW("6", "Юг-Запад"),
    NSW("7", "Север-Юг-Запад"),
    E("8", "Восток"),
    NE("9", "Север-Восток"),
    SE("a", "Юг-Восток"),
    NSE("b", "Север-Юг-Восток"),
    WE("c", "Запад-Восток"),
    NWE("d", "Север-Запад-Восток"),
    SWE("e", "Юг-Запад-Восток"),
    NSWE("f", "Все направления");

    private final String code;
    private final String description;
}
