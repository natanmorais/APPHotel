/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COM220.Model;

import COM220.Utils.Constants;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author natanmorais
 */
public class Reserva implements Serializable{
    long dataEntrada, dataSaída;
    double Desconto;
    ArrayList<Quarto> Quartos = new ArrayList<>();

    public Reserva() {
    }

    public Reserva(long dataEntrada, long dataSaída, double Desconto) {
        this.dataEntrada = dataEntrada;
        this.dataSaída = dataSaída;
        this.Desconto = Desconto;
    }

    public long getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(long dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public long getDataSaída() {
        return dataSaída;
    }

    public void setDataSaída(long dataSaída) {
        this.dataSaída = dataSaída;
    }

    public double getDesconto() {
        return Desconto;
    }

    public void setDesconto(double Desconto) {
        this.Desconto = Desconto;
    }

    public ArrayList<Quarto> getQuartos() {
        return Quartos;
    }

    public void setQuartos(ArrayList<Quarto> Quartos) {
        this.Quartos = Quartos;
    }
    
    
}
