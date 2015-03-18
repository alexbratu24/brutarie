/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussinesLogic;

import dbAccess.DBAccess;
import java.util.ArrayList;
import java.util.List;
import model.Clients;
import model.Productions;
import model.Products;
import viewModel.RegularUserModel;

/**
 *
 * @author Alexandru
 */
public class RegularUserController {
    private RegularUserModel _model ;
    private DBAccess _dbAccess;
    
    public RegularUserController() {
        
        _dbAccess = DBAccess.getInstance();
        _model= new RegularUserModel();
    }

    public void refreshInsertOrderPanel() {
        List <Clients> clients = new ArrayList<Clients> ();
        List<Productions> categories= new ArrayList<Productions> ();
        List<Products> products= new ArrayList<Products> ();
        clients = _dbAccess.getAllClients ();
        _model.setClients(clients);
        categories = _dbAccess.getAllCategories ();
        _model.setCategories(categories);
        products =_dbAccess.getAllProducts ();
        _model.setProducts(products);
        
    }
    
    public List<Clients> getComboBoxClients ()
    {        
        return _model.getClients();
    }

    public List<Productions> getComboBoxCategories() {
        return _model.getCategories();
    }

    public List<Products> getComboBoxProducts(Productions category) {
        List<Products> results = new ArrayList<Products> ();
        List<Products> allProducts = new ArrayList<Products> ();
        int cat_id = category.getProductionId();
        allProducts= _model.getProducts();
        
        for (Products p : allProducts)
        {
            if ( (int) p.getIdProduction().getProductionId()==cat_id)
            {
                results.add(p);
            }
        }
        return results;        
    }
    
}
