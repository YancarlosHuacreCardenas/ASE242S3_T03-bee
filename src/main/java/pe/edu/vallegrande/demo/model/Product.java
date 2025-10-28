package pe.edu.vallegrande.demo.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    @JsonProperty("product_id") // 🔹 Ahora Angular recibirá product_id
    private Integer productId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "category", length = 3)
    private String category;

    @Column(name = "is_available")
    @JsonProperty("is_available")
    private Boolean isAvailable = true;

    @Column(name = "image_url", length = 255)
    @JsonProperty("image_url")
    private String imageUrl;

    @Column(name = "launch_date")
    @JsonProperty("launch_date")
    private LocalDateTime launchDate;

    @Column(name = "prep_time")
    @JsonProperty("prep_time")
    private String prepTime;

    @Column(name = "is_featured")
    @JsonProperty("is_featured")
    private Boolean isFeatured = false;

    @Column(name = "nutritional_info", columnDefinition = "JSON")
    @JsonProperty("nutritional_info")
    private String nutritionalInfo;

    // Constructores
    public Product() {}

    public Product(String name, String description, BigDecimal price, String category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.isAvailable = true;
        this.isFeatured = false;
    }

    // Getters y Setters
    public Integer getProductId() { return productId; }
    public void setProductId(Integer productId) { this.productId = productId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Boolean getIsAvailable() { return isAvailable; }
    public void setIsAvailable(Boolean isAvailable) { this.isAvailable = isAvailable; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public LocalDateTime getLaunchDate() { return launchDate; }
    public void setLaunchDate(LocalDateTime launchDate) { this.launchDate = launchDate; }

    public String getPrepTime() { return prepTime; }
    public void setPrepTime(String prepTime) { this.prepTime = prepTime; }

    public Boolean getIsFeatured() { return isFeatured; }
    public void setIsFeatured(Boolean isFeatured) { this.isFeatured = isFeatured; }

    public String getNutritionalInfo() { return nutritionalInfo; }
    public void setNutritionalInfo(String nutritionalInfo) { this.nutritionalInfo = nutritionalInfo; }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", isAvailable=" + isAvailable +
                ", imageUrl='" + imageUrl + '\'' +
                ", launchDate=" + launchDate +
                ", prepTime='" + prepTime + '\'' +
                ", isFeatured=" + isFeatured +
                ", nutritionalInfo='" + nutritionalInfo + '\'' +
                '}';
    }
}
