/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia;

import java.util.ArrayList;

/**
 *
 * @author igorv
 */
public class Venda {
    final private int codigo;
    private Cliente cliente;
    private Funcionario funcionario;
    private float preco;
    ArrayList<Produto> listaprodutos = new ArrayList<>();

    public Venda(int codigo, Cliente cliente, Funcionario funcionario, float preco) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.preco = preco;
    }

    public Venda(int codigo, Funcionario funcionario, float preco) {
        this.codigo = codigo;
        this.funcionario = funcionario;
        this.preco = preco;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }
    
    
}
