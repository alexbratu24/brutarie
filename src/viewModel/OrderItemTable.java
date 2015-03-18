/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewModel;

import bussinesModel.OrderItem;
import java.util.Date;

/**
 *
 * @author Alexandru
 */
public class OrderItemTable {
    private OrderItem orderItem;
    private Date deliveryDate;

    public OrderItemTable(OrderItem orderItem, Date deliveryDate) {
        this.orderItem = orderItem;
        this.deliveryDate = deliveryDate;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    
}
