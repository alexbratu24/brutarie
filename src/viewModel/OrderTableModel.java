/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Products;

/**
 *
 * @author Alexandru
 */
public class OrderTableModel extends AbstractTableModel{
    private String[] columnNames = {"Nr. Crt","Produs","Cantitate","Data Livrare"};
    private List<OrderItemTable> items ;

    public OrderTableModel ()
    {
        items = new ArrayList<OrderItemTable> ();
    }
    public OrderTableModel(List<OrderItemTable> items) {
        this.items = items;
    }

    public String[] getColumnNames() {
        return columnNames;
    }

    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }

    public List<OrderItemTable> getItems() {
        return items;
    }

    public void setItems(List<OrderItemTable> items) {
        this.items = items;
    }
    
    public void addItem (OrderItemTable item)
    {
        this.items.add(item);
    }
    
    public String getColumnName (int col)
    {
        return columnNames[col];
    }
    @Override
    public int getRowCount() {
        return items.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Products p;
        switch (columnIndex)
        {
            case 0:
                return rowIndex+1;
        //    break;
            case 1:
                p = items.get(rowIndex).getOrderItem().getProduct();
                return p.getName();
        //    break;
            case 2:
                return items.get(rowIndex).getOrderItem().getQuantity();
        //    break;
            case 3:
                SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy");
                Date now = items.get(rowIndex).getDeliveryDate();
                return sdfDate.format(now);
                
        //    break;
            default:
                return 99;
            
            
        }
    }
    
}
