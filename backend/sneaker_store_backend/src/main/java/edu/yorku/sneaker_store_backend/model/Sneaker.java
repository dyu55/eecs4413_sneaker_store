package edu.yorku.sneaker_store_backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sneaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String brand;
<<<<<<< HEAD
    private String category;
=======

    /**
     * Colorway of the sneaker, e.g., "Bred", "Triple White".
     */
    private String colorway;

    /**
     * Retail price of the sneaker.
     */
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    /**
     * Number of items available in stock.
     */
    private Integer stock;

    private String category;

    private String genre;

    /**
     * Available shoe sizes for this sneaker (e.g., "8", "9.5").
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "sneaker_sizes", joinColumns = @JoinColumn(name = "sneaker_id"))
    @Column(name = "size", length = 10)
    @Builder.Default
    private List<String> availableSizes = new ArrayList<>();

    /**
     * Long description used for product detail pages.
     */
    @Column(length = 1000)
>>>>>>> dev
    private String description;
    private Double price;
    private Integer quantity;

    private String imageUrl;
}
