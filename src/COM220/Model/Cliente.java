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
public class Cliente implements Serializable{
    String CPF, Nome, Endereço;
    int Telefone;

    public Cliente() {
    }

    public Cliente(String CPF, String Nome, String Endereço, int Telefone) {
        this.CPF = CPF;
        this.Nome = Nome;
        this.Endereço = Endereço;
        this.Telefone = Telefone;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEndereço() {
        return Endereço;
    }

    public void setEndereço(String Endereço) {
        this.Endereço = Endereço;
    }

    public int getTelefone() {
        return Telefone;
    }

    public void setTelefone(int Telefone) {
        this.Telefone = Telefone;
    }
    
    
}
