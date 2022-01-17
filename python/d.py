d = {
    "1000":"1",
    "0100":"2",
    "1100":"3",
    "0010":"4",
    "1010":"5",
    "0110":"6",
    "1110":"7",
    "0001":"8",
    "1001":"9",
    "0101":"a",
    "1101":"b",
    "0011":"c",
    "1011":"d",
    "0111":"e",
    "1111":"f"
}
d2 = dict(zip(d.values(), d.keys()))
print(d2)
def form(elem):
    out = ""
    if(elem[0]=="1"):out+="C"
    if(elem[1]=="1"):out+="Ю"
    if(elem[2]=="1"):out+="З"
    if(elem[3]=="1"):out+="В"
    return out
mas = ["ac5", "386", "9c7", "e43", "9c5"]
for j in mas:
    print("#############")
    print("++++++++++++++")
    print(j)
    print("++++++++++++++")
    for i in j:
        print(form(d2[i]))
    print("#############\n")