/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussinesModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Clients;

/**
 *
 * @author Alexandru
 */
public class InsertOrder {

    private Clients client;
    List<OrderItem> items;
    private Date date_placed;
    private Date date_delivery;
    private float value;
    private String description;

    public InsertOrder() {
        items= new ArrayList<OrderItem> ();
    }

    public InsertOrder(Clients client, List<OrderItem> items, Date date_placed, Date date_delivery, float value, String description) {
        this.client = client;
        this.items = items;
        this.date_placed = date_placed;
        this.date_delivery = date_delivery;
        this.value = value;
        this.description = description;
    }

    public Date getDate_placed() {
        return date_placed;
    }

    public void setDate_placed(Date date_placed) {
        this.date_placed = date_placed;
    }

    public Date getDate_delivery() {
        return date_delivery;
    }

    public void setDate_delivery(Date date_delivery) {
        this.date_delivery = date_delivery;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void addItem (OrderItem item)
    {
        this.items.add(item);
    }
}
