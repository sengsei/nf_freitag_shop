package version02;

public class ProductShoes implements Product{
    private final int id;
    private final String name;

    public ProductShoes(int id, String name) {
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

    @Override
    public String toString() {
        return "ProductShoes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
