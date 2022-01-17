import turtle
import tkinter as tk
NORTH, SOUTH, WEST, EAST = [i for i in range(4)]

rotate_direction = NORTH
string_patht="WRWWLWWLWWLWLWRRWRWWWRWWRWLW"
string_patht2="WWRRWLWLWWLWWLWWRWWRWWLW"


def goto_(turtle,rotate):
    turtle.penup()  # don't draw when turtle moves
    if(rotate==NORTH):
        turtle.left(270)
        turtle.goto(0, 200)  # move the turtle to a location
    elif (rotate == SOUTH):
        turtle.left(90)
        turtle.goto(0, -200)  # move the turtle to a location
    elif (rotate == WEST):
        turtle.left(0)
        turtle.goto(-200,0)  # move the turtle to a location
    elif (rotate == EAST):
        turtle.left(180)
        turtle.goto(200, 0)  # move the turtle to a location
    turtle.showturtle()  # make the turtle visible
    turtle.pendown()
def do_stuff(phraze,phraze2):
    global rotate_direction
    goto_(my_lovely_turtle,rotate_direction)
    for i in phraze:
        if (i == "W"):
            my_lovely_turtle.dot(20,"blue")
            my_lovely_turtle.forward(50)
            yield
        elif (i == "R"):
            my_lovely_turtle.right(90)
        elif (i == "L"):
            my_lovely_turtle.left(90)
    my_lovely_turtle.forward(100)

    my_lovely_turtle.right(180)
    my_lovely_turtle.forward(100)
    for i in phraze2:
        if (i == "W"):
            my_lovely_turtle.dot(15,"red")
            my_lovely_turtle.forward(50)
            yield
        elif (i == "R"):
            my_lovely_turtle.right(90)
        elif (i == "L"):
            my_lovely_turtle.left(90)
    my_lovely_turtle.forward(100)


gen = None

def press():
    global string_patht
    global string_patht2
    global gen
    if (gen == None): gen = do_stuff(string_patht, string_patht2)
    try:
        next(gen)
    except StopIteration:
        pass


if __name__ == "__main__":
    root = tk.Tk()
    canvas = tk.Canvas(root)
    canvas.config(width=1000, height=500)
    canvas.pack(side=tk.LEFT)
    screen = turtle.TurtleScreen(canvas)
    button = tk.Button(root, text="Press me", command=press)
    button.pack()
    my_lovely_turtle = turtle.RawTurtle(screen, shape="turtle")
    root.mainloop()
