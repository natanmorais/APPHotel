/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COM220.Control;

import COM220.Model.Cliente;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author natanmorais
 */
public class ctrCliente {

    //Criar atributo para ter o view do Cliente.
    List<Cliente> listaClientes = new ArrayList<>();
    
    public ctrCliente(){
        BuscaClientes();        
    }

    public void SalvaCliente(){
        try {

            //Gera o arquivo para armazenar o objeto
            FileOutputStream arquivoGrav
                    = new FileOutputStream("clientes.dat");

            //Classe responsavel por inserir os objetos
            ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);

            //Grava o objeto cliente no arquivo
            objGravar.writeObject(listaClientes);

            objGravar.flush();

            objGravar.close();            

            arquivoGrav.close();

        } catch (Exception e) {
        }
    }

    public void BuscaClientes(){
        try {

            //Carrega o arquivo
            FileInputStream arquivoLeitura = new FileInputStream("clientes.dat");

            //Classe responsavel por recuperar os objetos do arquivo
            ObjectInputStream objLeitura
                    = new ObjectInputStream(arquivoLeitura);

            listaClientes = (ArrayList<Cliente>) objLeitura.readObject();

            objLeitura.close();

            arquivoLeitura.close();

        } catch (Exception e) {
        }
    }
    
    public boolean RemoverCliente( String CPF ){
        for(Cliente c: listaClientes){
            if(c.getCPF().equals(CPF)){
                listaClientes.remove(c);
                SalvaCliente();
                return true;
            }
        }
        return false;
    }
    
    public void CadastrarCliente(Cliente c){
        BuscaClientes();
        listaClientes.add(c);
        SalvaCliente();
    }
    
    public Boolean existeCliente(String CPF){
        BuscaClientes();
        for(Cliente c: listaClientes){
            if(c.getCPF().equals(CPF)){
                return true;
            }
        }
        return false;
    }
    
    public List<Cliente> listaDeClientes(){
        return listaClientes;
    }
}
