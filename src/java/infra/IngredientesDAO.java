/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package infra;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafa
 */
public class IngredientesDAO {
    public List<String> listarIngredientesDisponiveis(){
        List<String> lista = new ArrayList();
        
        lista.add("Palmito");
        lista.add("Queijo");
        lista.add("Azeitona");
  /*      lista.add("Tomate");
        lista.add("Ervilhas");
        lista.add("Presunto");
        lista.add("Calabresa");
        lista.add("Ovos de codorna");
        lista.add("Cebola");
          */
        
        return lista;
        
        
    }
}
