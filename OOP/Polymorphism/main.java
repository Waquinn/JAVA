package polymorphism;

public class main {
    public static void main(String[] args) {
        System.out.println("\n");

        enemy we = new weakenemy();
        enemy se = new strongenemy("Mike");

        we.dialogue(); 
        we.showStats();

        se.dialogue();
        se.showStats();
}
}
