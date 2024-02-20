package WithComposition;

public class CarProgram {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View(model);
        model.register(view);
        new Controller(view, model);

        model.startTimer();

    }
}
