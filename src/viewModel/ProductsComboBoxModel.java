/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewModel;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import model.Clients;
import model.Products;

/**
 *
 * @author Alexandru
 */
public class ProductsComboBoxModel extends AbstractListModel implements ComboBoxModel{

    private List<Products> _products ;
    private Products _selectedProduct ;

    public ProductsComboBoxModel(List<Products> _products, Products _selectedProduct) {
        this._products = _products;
        this._selectedProduct = _selectedProduct;
    }

    public List<Products> getProducts() {
        return _products;
    }

    public void setProducts(List<Products> _products) {
        this._products = _products;
    }

    public Products getSelectedProduct() {
        return _selectedProduct;
    }

    public void setSelectedProduct(Products _selectedProduct) {
        this._selectedProduct = _selectedProduct;
    }
    
    @Override
    public int getSize() {
        return _products.size();
    }

    @Override
    public Object getElementAt(int index) {
        return _products.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        _selectedProduct = (Products) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return _selectedProduct;
    }
    
}
