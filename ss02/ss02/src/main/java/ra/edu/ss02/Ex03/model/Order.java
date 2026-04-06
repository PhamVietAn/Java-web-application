package ra.edu.ss02.Ex03.model;

import lombok.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String orderCode;
    private String productName;
    private double totalAmount;
    private Date orderDate;
}
