/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COM220.Model;

import COM220.Utils.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author natanmorais
 */
public class Reserva implements Serializable {

    private long dataEntrada, dataSaida;
    private double Desconto;
    private List<Quarto> Quartos = new ArrayList<>();
    private Boolean Cancelada = false;
    private Cliente cliente;
    private final long codigo;

    public Reserva() {
        //Código único.
        codigo = Calendar.getInstance().getTimeInMillis();
    }

    public Reserva( Cliente cliente, long dataEntrada, long dataSaida, double Desconto) {
        this();
        this.cliente = cliente;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.Desconto = Desconto;
    }
    
    public long getCodigo(){
        return codigo;
    }
    
    public Cliente getCliente(){
        return cliente;
    }   
    
    public long getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(long dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public long getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(long dataSaída) {
        this.dataSaida = dataSaída;
    }

    public double getDesconto() {
        return Desconto;
    }

    public void setDesconto(double Desconto) {
        this.Desconto = Desconto;
    }

    public List<Quarto> getQuartos() {
        return Quartos;
    }

    public void setQuartos(List<Quarto> Quartos) {
        this.Quartos = Quartos;
    }

    public double calcularDesconto() {
        double percent = this.getDesconto()/100;
        double Preço = 0;
        for (Quarto q : Quartos) {
            Preço += q.getPreco();
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
