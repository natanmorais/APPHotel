/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COM220.Control;

import COM220.Model.Quarto;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author natanmorais
 */
public class ctrQuarto {
    //Criar atributo para ter o view do Quarto.
    ArrayList<Quarto> listaQuartos = new ArrayList<>();
    
    public ctrQuarto(){
        BuscaQuartos();
    }

    public void SalvaQuarto(){
        try {

            //Gera o arquivo para armazenar o objeto
            FileOutputStream arquivoGrav
                    = new FileOutputStream("quartos.dat");

            //Classe responsavel por inserir os objetos
            ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);

            //Grava o objeto cliente no arquivo
            objGravar.writeObject(listaQuartos);

            objGravar.flush();

            objGravar.close();

            arquivoGrav.flush();

            arquivoGrav.close();

        } catch (Exception e) {

        }
    }

    public void BuscaQuartos(){
        try {

            //Carrega o arquivo
            FileInputStream arquivoLeitura = new FileInputStream("quartos.dat");

            //Classe responsavel por recuperar os objetos do arquivo
            ObjectInputStream objLeitura
                    = new ObjectInputStream(arquivoLeitura);

            listaQuartos = (ArrayList<Quarto>) objLeitura.readObject();

            objLeitura.close();

            arquivoLeitura.close();

        } catch (Exception e) {

        }
    }
    
    public void AddQuarto(Quarto q){
        BuscaQuartos();
        listaQuartos.add(q);
        SalvaQuarto();
    }
    
    public ArrayList <Quarto> listaDeQuartos() {
            return listaQuartos;        
    }
    
    public boolean RemoverQuarto( int numero ){
        for(Quarto q : listaQuartos){
            if(q.getNumero() == numero){
                listaQuartos.remove(q);
                SalvaQuarto();
                return true;
            }
        }
        return false;
    }
}
