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
import model.Productions;

/**
 *
 * @author Alexandru
 */
public class CategoryComboBoxModel extends AbstractListModel implements ComboBoxModel{
    
    private List<Productions> _categorys  ;
    private Productions _selectedCategory ;

    public CategoryComboBoxModel(List<Productions> _category, Productions _selectedCategory) {
        this._categorys = _category;
        this._selectedCategory = _selectedCategory;
    }

    public CategoryComboBoxModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Productions> getCategory() {
        return _categorys;
    }

    public void setCategory(List<Productions> _category) {
        this._categorys = _category;
    }

    public Productions getSelectedCategory() {
        return _selectedCategory;
    }

    public void setSelectedCategory(Productions _selectedCategory) {
        this._selectedCategory = _selectedCategory;
    }

    

    
    
    @Override
    public int getSize() {
        return _categorys.size();
    }

    @Override
    public Object getElementAt(int index) {
        return _categorys.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        _selectedCategory = (Productions) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return _selectedCategory;
    }
    
}
