/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploormlite;

import com.j256.ormlite.field.DatabaseField;

/**
 *
 * @author 11645
 */
public class Pessoa {
    @DatabaseField(id = true)
    public int id;
    @DatabaseField
    public String nome;
    @DatabaseField
    public int idade;

    @Override
    public String toString() {
        return  id + " " + nome + " " + idade;
    }
    
    
}
