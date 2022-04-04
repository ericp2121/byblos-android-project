package my.firstapp.byblos;

public class Node {
    private String name;
    private String pass;
    private String email;
    private Node next;

    Node () {
        name = null;
        pass = null;
        email = null;
        next = null;
    }

    Node (String name, String pass, String email) {
        this.name = name;
        this.pass = pass;
        this.email = email;
        this.next = null;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public String getEmail() {
        return email;
    }
}
