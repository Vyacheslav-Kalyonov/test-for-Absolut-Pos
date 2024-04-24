import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Product {

    private final String name;

    private final Set<Product> composition = new HashSet<>();

    public boolean addProduct(Product p) {
        if (dfsForProducts(p)) {
            return false;
        }
        composition.add(p);

        return true;
    }

    public boolean dfsForProducts(Product p) {
        if (this.equals(p)) {
            return true;
        }

        for (Product product : p.getComposition()) {
            if (dfsForProducts(product)) {
                return true;
            }
        }
        return false;
    }

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Product> getComposition() {
        return composition;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Product product = (Product) object;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
