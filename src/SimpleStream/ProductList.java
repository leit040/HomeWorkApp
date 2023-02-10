package SimpleStream;

import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;

public class ProductList{
    ArrayList<Product> list;

    public ProductList(){
        this.list = new ArrayList<Product>();
    }

    public void add(Product product){
        this.list.add(product);
    }

    public List<Product> getBookProducts(){
        return   this.list.stream().filter((p) -> p.price > 250 && p.type.equals("Book")).toList();
    }

    public List<Product> getBookProductsWithDiscount(){
        return   this.list.stream().filter((p) -> p.isDiscounted() && p.type.equals("Book")).toList();
    }

    public Product getBookWithMinPrice(){
      return this.list.stream().filter((p) -> p.getType().equals("Book")).min(Product::compareByPrice).get();

    }
    public List<Product> getlastThreeProducts(){
        int size = list.size();
        if(size<=3){
            return this.list.stream().sorted(Product::compareByCreatedAt).toList();
        }
        return   this.list.stream().sorted(Product::compareByCreatedAt).skip(size-3).toList();
    }

    public float Calculate(){
        int year = Year.now().getValue();
        return (float)this.list.stream().filter((p) -> p.price <= 75 && p.type.equals("Book") && p.getCreatedAt().get(Calendar.YEAR) == year).mapToDouble(Product::getPrice).sum();
    }

    public Map<String,List<Product>> getMap(){
        Map<String, List<Product>> result;
       result =  this.list.stream().collect(Collectors.groupingBy(Product::getType));
        return result;
    }
}
