/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COM220.Model;

import COM220.Utils.Constants;
/**
 *
 * @author natanmorais
 */
public class Pagamento {
    float Valor;
    int Situação;
    Reserva ReservaEfetuada;

    public Pagamento() {
    }

    public Pagamento(Reserva ReservaEfetuada) {
        this.ReservaEfetuada = ReservaEfetuada;
    }

    public Pagamento(float Valor, int Situação, Reserva ReservaEfetuada) {
        this.Valor = Valor;
        this.Situação = Situação;
        this.ReservaEfetuada = ReservaEfetuada;
    }

    public float getValor() {
        return Valor;
    }

    public void setValor(float Valor) {
        this.Valor = Valor;
    }

    public int getSituação() {
        return Situação;
    }

    public void setSituação(int Situação) {
        this.Situação = Situação;
    }

    public Reserva getReservaEfetuada() {
        return ReservaEfetuada;
    }

    public void setReservaEfetuada(Reserva ReservaEfetuada) {
        this.ReservaEfetuada = ReservaEfetuada;
    }
    
    
}
