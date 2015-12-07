/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COM220.Control;

import COM220.Model.Pagamento;
import COM220.Model.Quarto;
import COM220.Model.Reserva;
import COM220.Utils.Constants;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
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
    ctrPagamento controlP = new ctrPagamento();

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
        
        for(Iterator<Quarto> it = quartosDisp.iterator(); it.hasNext(); ){
            Quarto q = it.next();
            for (Integer num : quartosNao) {
                if (q.getNumero() == num) {
                    it.remove();
                    break;
                }
            }
        }

        return quartosDisp;
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

    public double calculaDesconto(Reserva r) {
        return r.calcularDesconto();
    }

    public void fazerReserva(Reserva r) {
        BuscaReservas();
        listaReservas.add(r);
        SalvaReserva();
    }

    public ArrayList<Reserva> relatorioCancelados() {
        ArrayList<Reserva> canc = new ArrayList<>();
        BuscaReservas();
        for (Reserva r : listaReservas) {
            if (r.getCancelada()) {
                canc.add(r);
            }
        }
        return canc;
    }

    public ArrayList<Reserva> relatorioNaoPagos() {
        ArrayList<Reserva> naoP = new ArrayList<>();
        BuscaReservas();
        for (Pagamento p : controlP.listaPagamentos) {
            if (p.getSituacao() == Constants.NAO_PAGO) {
                naoP.add(p.getReservaEfetuada());
            }
        }
        return naoP;
    }

    public ArrayList<Reserva> relatorioASerPagoHoje() {
        ArrayList<Reserva> naoP = new ArrayList<>();
        Calendar hoje = Calendar.getInstance(), dia = null;
        BuscaReservas();
        for (Pagamento p : controlP.listaPagamentos) {
            if (p.getSituacao() == Constants.NAO_PAGO) {
                dia.setTimeInMillis(p.getReservaEfetuada().getDataEntrada());
                if ((dia.get(Calendar.DAY_OF_YEAR) + 3) == hoje.get(Calendar.DAY_OF_YEAR)) {
                    naoP.add(p.getReservaEfetuada());
                }
            }
        }
        return naoP;
    }

    public ArrayList<Reserva> relatorioPeriodo(long ini, long fim){
        ArrayList<Reserva> list = new ArrayList<>();
        BuscaReservas();
        for (Reserva r : listaReservas) {
            if (r.getDataEntrada() >= ini && r.getDataEntrada() <= fim) {
                list.add(r);
            }
        }
        return list;
    }
}
