/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COM220.Control;

import COM220.Model.Reserva;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author natanmorais
 */
public class ctrReserva {
    //Criar atributo para ter o view do Reserva.
    ArrayList<Reserva> listaReservas = new ArrayList<>();

    public void SalvaReserva() throws Exception{
        try {

            //Gera o arquivo para armazenar o objeto
            FileOutputStream arquivoGrav
                    = new FileOutputStream("reservas.dat");

            //Classe responsavel por inserir os objetos
            ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);

            //Grava o objeto cliente no arquivo
            objGravar.writeObject(listaReservas);

            objGravar.flush();

            objGravar.close();

            arquivoGrav.flush();

            arquivoGrav.close();

        } catch (Exception e) {

            throw e;

        }
    }

    public void BuscaReservas() throws Exception{
        try {

            //Carrega o arquivo
            FileInputStream arquivoLeitura = new FileInputStream("reservas.dat");

            //Classe responsavel por recuperar os objetos do arquivo
            ObjectInputStream objLeitura
                    = new ObjectInputStream(arquivoLeitura);

            listaReservas = (ArrayList<Reserva>) objLeitura.readObject();

            objLeitura.close();

            arquivoLeitura.close();

        } catch (Exception e) {

            throw e;

        }
    }
}
