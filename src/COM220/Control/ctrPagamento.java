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

/**
 *
 * @author natanmorais
 */
public class ctrPagamento {

    //Criar atributo para ter o view do Pagamento.
    ArrayList<Pagamento> listaPagamentos = new ArrayList<>();

    public void SalvaPagamento() {
        try {

            //Gera o arquivo para armazenar o objeto
            FileOutputStream arquivoGrav
                    = new FileOutputStream("pagamentos.dat");

            //Classe responsavel por inserir os objetos
            ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);

            //Grava o objeto cliente no arquivo
            objGravar.writeObject(listaPagamentos);

            objGravar.flush();

            objGravar.close();

            arquivoGrav.flush();

            arquivoGrav.close();

        } catch (Exception e) {

        }
    }

    public void BuscaPagamentos() {
        try {

            //Carrega o arquivo
            FileInputStream arquivoLeitura = new FileInputStream("pagamentos.dat");

            //Classe responsavel por recuperar os objetos do arquivo
            ObjectInputStream objLeitura
                    = new ObjectInputStream(arquivoLeitura);

            listaPagamentos = (ArrayList<Pagamento>) objLeitura.readObject();

            objLeitura.close();

            arquivoLeitura.close();

        } catch (Exception e) {
        }
    }

    public boolean RegistrarPagamento(Pagamento p) {
        BuscaPagamentos();

        for (Iterator<Pagamento> it = listaPagamentos.iterator(); it.hasNext();) {
            Pagamento pAux = it.next();
            if (p.getReservaEfetuada().getCodigo() == pAux.getReservaEfetuada().getCodigo()) {
                p.setValor(p.getValor() + pAux.getValor());
                it.remove();
            }
        }

        Calendar dataEnt = Calendar.getInstance(),
                dataSai = Calendar.getInstance();
        dataEnt.setTimeInMillis(p.getReservaEfetuada().getDataEntrada());
        dataSai.setTimeInMillis(p.getReservaEfetuada().getDataSaida());
        double Preço = p.getReservaEfetuada().calcularDesconto();
        for (Quarto q : p.getReservaEfetuada().getQuartos()) {
            Preço += q.getPreco();
        }
        if (p.getValor() > Preço) {
            return false;
        } else if (p.getValor() == Preço) {
            p.setSituacao(Constants.PAGO);
        } else if (p.getValor() >= Preço / (dataSai.get(Calendar.DAY_OF_YEAR) - dataEnt.get(Calendar.DAY_OF_YEAR))) {
            p.setSituacao(Constants.GARANTIDO);
        } else {
            if (p.getValor() > 0) {
                p.setSituacao(Constants.NAO_GARANTIDO);
            } else {
                p.setSituacao(Constants.NAO_PAGO);
            }
        }
        listaPagamentos.add(p);
        SalvaPagamento();
        return true;
    }

    public int VerificarPagamento(int cod) {
        for (Pagamento p : listaPagamentos) {
            if (p.getReservaEfetuada().getCodigo() == cod) {
                return p.getSituacao();
            }
        }
        return Constants.ERRO;
    }

    public ArrayList<Pagamento> listarTodosPagamentos() {
        BuscaPagamentos();
        return listaPagamentos;
    }

    public void passouDoPrazo() {
        BuscaPagamentos();
        ctrReserva controlR = new ctrReserva();
        ArrayList <Reserva> aux = new ArrayList<>();
        Calendar dia = Calendar.getInstance(), hoje = Calendar.getInstance();
        for (Pagamento p : listaPagamentos) {
            dia.setTimeInMillis(p.getReservaEfetuada().getDataEntrada());
            if (dia.get(Calendar.DAY_OF_YEAR) < hoje.get(Calendar.DAY_OF_YEAR) + 3 && p.getSituacao() <= Constants.NAO_GARANTIDO) {
                aux.add(p.getReservaEfetuada());
            }
        }
        for(Reserva r: controlR.listarTodasReservas()){
            for(Reserva rAux: aux){
                if(r.getCodigo() == rAux.getCodigo()){
                    r.setCancelada(true);
                }
            }
        }
        controlR.SalvaReserva();
    }

}
