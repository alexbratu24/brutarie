/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussinesLogic;

import bussinesModel.InsertOrder;
import bussinesModel.OrderItem;
import dbAccess.DBAccess;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import model.Clients;

/**
 *
 * @author Alexandru
 */
public class OrderController {
    private List<InsertOrder> _orders; 
    private DBAccess _dbAccess ;

    public OrderController() {
        _dbAccess = DBAccess.getInstance();
        InsertOrder currentOrder = new InsertOrder();
        currentOrder.setDate_placed(Calendar.getInstance().getTime());
        _orders = new ArrayList<InsertOrder> ();
        _orders.add(currentOrder);        
    }
    
    public OrderController ( Clients client )
    {
        _dbAccess = DBAccess.getInstance();
        InsertOrder currentOrder = new InsertOrder();
        currentOrder.setDate_placed(Calendar.getInstance().getTime());
        currentOrder.setClient(client);
        _orders = new ArrayList<InsertOrder> ();
        _orders.add(currentOrder);      
    }
    public OrderController ( Clients client , Date date)
    {
        _dbAccess = DBAccess.getInstance();
        InsertOrder currentOrder = new InsertOrder();
        currentOrder.setDate_placed(Calendar.getInstance().getTime());
        currentOrder.setDate_delivery(date);
        currentOrder.setClient(client);
        _orders = new ArrayList<InsertOrder> ();
        _orders.add(currentOrder);      
    }
    
    public List<InsertOrder> getOrders() {
        return _orders;
    }

    public void setOrders(List<InsertOrder> _Orders) {
        this._orders = _Orders;
    }    

    public void insertNormalItem(OrderItem item) {
        this._orders.get(0).addItem(item);        
    }
    
    public Date getGeneralDate ()
    {
        return _orders.get(0).getDate_delivery();
    }
    
    public void insertSpecialItem(OrderItem item, Date date) {
        // adauga in alt order decat in current order , verifica daca ai vreun order cu data
        InsertOrder ord;
        int n=this._orders.size();
        Boolean done=false;
        for (int i=1;i<n&&!done;i++)
        {
            ord=this._orders.get(i);
            if (ord.getDate_delivery().equals(date) )
            {
                ord.addItem(item);
                done=true;
            }
        }
        if (!done)
        {
            List<OrderItem> itms = new ArrayList<OrderItem> ();
            itms.add(item);
            InsertOrder nsord = new InsertOrder (this._orders.get(0).getClient(),itms,this._orders.get(0).getDate_placed(),date,0,"");
            _orders.add(nsord);
        }
    }
}
