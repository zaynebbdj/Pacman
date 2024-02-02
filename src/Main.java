public class Main { 
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        Gui frame = new Gui();
        Thread thread = new Thread(frame.getView()); 
        thread.start();
    }
}
