/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COM220.Model;

import COM220.Utils.Constants;
import java.io.Serializable;

/**
 *
 * @author natanmorais
 */
public class Quarto implements Serializable{
    int Numero;
    double Preco;
    String Descricao;

    public Quarto() {
    }

    public Quarto(int Numero, double Preco, String Descricao) {
        this.Numero = Numero;
        this.Preco = Preco;
        this.Descricao = Descricao;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public double getPreco() {
        return Preco;
    }

    public void setPreco(double Preco) {
        this.Preco = Preco;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    @Override
    public String toString() {
        return "[" + getNumero() + "] - " + getDescricao() + " Preço: R$" + getPreco();
    }    
}
