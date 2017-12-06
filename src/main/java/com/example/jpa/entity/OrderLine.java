/**
 * Created by IntelliJ IDEA.
 * User: LiuWenqi
 * Date: 2017-12-02
 * Time: 13:57
 * Description:订单明细类
 */
package com.example.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer amount;//产品购买的数量
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "p_id")
    private Product product;//购买的产品
    private BigDecimal purchasePrice;//采购价格



}
