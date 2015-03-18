/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewModel;

import java.util.List;
import model.Clients;
import model.Productions;
import model.Products;

/**
 *
 * @author Alexandru
 */
public class RegularUserModel {
    private List<Clients> _clients;
    private List<Productions> _categories;
    private List<Products> _products;

    public RegularUserModel(List<Clients> _clients, List<Productions> _productions, List<Products> _products) {
        this._clients = _clients;
        this._categories = _productions;
        this._products = _products;
    }

    public List<Productions> getCategories() {
        return _categories;
    }

    public void setCategories(List<Productions> _categories) {
        this._categories = _categories;
    }

    public List<Products> getProducts() {
        return _products;
    }

    public void setProducts(List<Products> _products) {
        this._products = _products;
    }
    
    

    public RegularUserModel() {
        
    }

    public List<Clients> getClients() {
        return _clients;
    }

    public void setClients(List <Clients> _clients) {
        this._clients = _clients;
    }
    
    
}
