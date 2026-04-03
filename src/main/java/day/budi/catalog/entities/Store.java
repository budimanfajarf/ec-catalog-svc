package day.budi.catalog.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "stores")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String uuid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String address;

    @OneToMany(mappedBy = "store")
    @Builder.Default
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
        product.setStore(this);
    }

    public void removeProduct(Product product) {
        products.remove(product);
        product.setStore(null);
    }

    // Getters and Setters
    // Lombok will generate the getters and setters.

    // public Long getId() {
    // return id;
    // }

    // public void setId(Long id) {
    // this.id = id;
    // }

    // public String getUuid() {
    // return uuid;
    // }

    // public void setUuid(String uuid) {
    // this.uuid = uuid;
    // }

    // public String getName() {
    // return name;
    // }

    // public void setName(String name) {
    // this.name = name;
    // }

    // public String getAddress() {
    // return address;
    // }

    // public void setAddress(String address) {
    // this.address = address;
    // }
}
