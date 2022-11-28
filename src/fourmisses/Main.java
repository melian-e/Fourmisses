package fourmisses;

public class Main {

    public static void main(String[] args) {
    	
        Model model = new Model(1000,1000);
        View view = new View();
        
        model.updateView(view);

        System.out.println("test");
        Model.write();

    }
}
