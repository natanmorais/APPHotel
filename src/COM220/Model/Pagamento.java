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
public class Pagamento implements Serializable{
    float Valor;
    Reserva ReservaEfetuada;
    int Situacao = Constants.NAO_PAGO;

    public Pagamento() {
    }

    public Pagamento(Reserva ReservaEfetuada) {
        this.ReservaEfetuada = ReservaEfetuada;
    }

    public Pagamento(float Valor, Reserva ReservaEfetuada) {
        this.Valor = Valor;
        this.ReservaEfetuada = ReservaEfetuada;
    }

    public float getValor() {
        return Valor;
    }

    public void setValor(float Valor) {
        this.Valor = Valor;
    }

    public int getSituacao() {
        return Situacao;
    }

    public void setSituacao(int Situacao) {
        this.Situacao = Situacao;
    }

    public Reserva getReservaEfetuada() {
        return ReservaEfetuada;
    }

    public void setReservaEfetuada(Reserva ReservaEfetuada) {
        this.ReservaEfetuada = ReservaEfetuada;
    }
    
    
}
