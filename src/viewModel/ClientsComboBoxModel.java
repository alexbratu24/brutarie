/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewModel;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import model.Clients;

/**
 *
 * @author Alexandru
 */
public class ClientsComboBoxModel extends AbstractListModel implements ComboBoxModel {

    private List<Clients> _clients ;
    private Clients _selectedClient ;
   // private String _selectedClientValue;
    
    public ClientsComboBoxModel(List<Clients> _clients, Clients _selectedClient) {
        this._clients = _clients;
        this._selectedClient = _selectedClient;
      //  this._selectedClientValue = _selectedClient.getName();
    }

   /* public String getSelectedClientValue() {
        return _selectedClientValue;
    }

    public void setSelectedClientValue(String _selectedClientValue) {
        this._selectedClientValue = _selectedClientValue;
    }*/

    public List<Clients> getClients() {
        return _clients;
    }

    public void setClients(List<Clients> _clients) {
        this._clients = _clients;
    }

    public Clients getSelectedClient() {
        return _selectedClient;
    }

    public void setSelectedClient(Clients _selectedClient) {
        this._selectedClient = _selectedClient;
    }
    
    @Override
    public int getSize() {
        return _clients.size();
    }

    @Override
    public Object getElementAt(int index) {
        return _clients.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        Clients client = (Clients) anItem;
        _selectedClient =client;
    }

    @Override
    public Object getSelectedItem() {
        return _selectedClient;
    }

    
}
