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
public class Reserva implements Serializable {

    int Codigo;
    long dataEntrada, dataSaída;
    double Desconto;
    ArrayList<Quarto> Quartos = new ArrayList<>();
    Boolean Cancelada = false;

    public Reserva() {
    }

    public Reserva(int Codigo, long dataEntrada, long dataSaída, double Desconto) {
        this.dataEntrada = dataEntrada;
        this.dataSaída = dataSaída;
        this.Desconto = Desconto;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
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

    public double calcularDesconto() {
        double percent = this.getDesconto()/100;
        double Preço = 0;
        for (Quarto q : Quartos) {
            Preço += q.getPreço();
        }
        return Preço * percent;
    }

    public Boolean getCancelada() {
        return Cancelada;
    }

    public void setCancelada(Boolean Cancelada) {
        this.Cancelada = Cancelada;
    }
}
