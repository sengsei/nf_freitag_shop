package version02;

public class ProductHat implements Product {
    private int id;
    private String name;

    public ProductHat(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

}
