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
    double Preço;
    String Descrição;

    public Quarto() {
    }

    public Quarto(int Numero, double Preço, String Descrição) {
        this.Numero = Numero;
        this.Preço = Preço;
        this.Descrição = Descrição;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public double getPreço() {
        return Preço;
    }

    public void setPreço(double Preço) {
        this.Preço = Preço;
    }

    public String getDescrição() {
        return Descrição;
    }

    public void setDescrição(String Descrição) {
        this.Descrição = Descrição;
    }
    
}
