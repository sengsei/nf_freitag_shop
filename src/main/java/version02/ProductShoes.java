package version02;

public class ProductShoes implements Product{
    private int id;
    private String name;
    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

}
