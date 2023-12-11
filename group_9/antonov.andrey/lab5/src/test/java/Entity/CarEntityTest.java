package Entity;

import annotaion.Column;
import annotaion.Table;
import entity.Brand;
import entity.Color;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(schema = "cars_storage", name = "cars")
public class CarEntityTest {
    @Column(name = "id")
    private Integer id;

    @Column(name = "brand")
    private Brand brand;

    @Column(name = "color")
    private Color color;

    @Column(name = "seatsQuantity")
    private Integer seatsQuantity;

    @Column(name = "carCategoryId")
    private int carCategoryId;

    @Column(name = "userId")
    private Integer userId;

    @Column(name = "image")
    private String image;
}
