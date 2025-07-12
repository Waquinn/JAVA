package fundamentals;

public class character {

    //Global variables:
    String name, dialog;
    int hp, mp, lvl;

    //Object:
    character(String name, String dialog, int hp, int mp, int lvl){

        this.name = name;
        this.dialog = dialog;
        this.hp = hp;
        this.mp = mp;
        this.lvl = lvl;
    }

    //Constructor:
    void introduce(){
        System.out.println("I am " + name);
    }
}
