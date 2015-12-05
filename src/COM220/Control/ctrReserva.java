/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COM220.Control;

import COM220.Model.Quarto;
import COM220.Model.Reserva;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author natanmorais
 */
public class ctrReserva {

    //Criar atributo para ter o view do Reserva.
    ArrayList<Reserva> listaReservas = new ArrayList<>();
    ctrQuarto controlQ = new ctrQuarto();

    public ctrReserva() {
        BuscaReservas();
    }

    public void SalvaReserva() {
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
        }
    }

    public void BuscaReservas() {
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
        }
    }

    public List<Quarto> verificaDisponibilidade(long ini, long fim) {
        BuscaReservas();
        List<Quarto> quartosDisp = controlQ.listaDeQuartos();
        List<Integer> quartosNao = new ArrayList<>();
        for (Reserva r : listaReservas) {
            if (r.getCancelada()
                    || ini >= r.getDataEntrada() && ini <= r.getDataSaida()
                    || fim >= r.getDataEntrada() && fim <= r.getDataSaida()
                    || ini <= r.getDataEntrada() && fim >= r.getDataSaida()) {
                for (Quarto q : r.getQuartos()) {
                    quartosNao.add(q.getNumero());
                }
            }
        }
        
        ///Isso não pode!!!!!
        
        for (Quarto q : quartosDisp) {
            for (Integer num : quartosNao) {
                if (q.getNumero() == num) {
                    quartosDisp.remove(q);
                }
            }
        }

        return quartosDisp;
    }

    public void addReserva(Reserva reserva) {
        BuscaReservas();
        listaReservas.add(reserva);
        SalvaReserva();
    }

    public ArrayList<Reserva> listarTodasReservas() {
        return listaReservas;
    }

    public void cancelarReserva(long cod) {
        BuscaReservas();
        for (Reserva r : listaReservas) {
            if (r.getCodigo() == cod) {
                r.setCancelada(true);
            }
        }
    }
}
