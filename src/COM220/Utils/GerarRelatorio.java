/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COM220.Utils;

import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.table.TableModel;

/**
 *
 * @author tiago
 */
public class GerarRelatorio {
    public String GerarHTML( TableModel model ){
        StringBuilder sb = new StringBuilder();
        
        sb.append("<meta charset=\"UTF-8\">");
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>");
        sb.append("Relatório");
        sb.append("</title>");
        sb.append("<body>");
        
        
        sb.append( "<table style='border:1px;width:100%;height:auto'>" );
        
        //Cria os nomes das colunas.
        sb.append("<tr>");
        for( int col = 0; col < model.getColumnCount(); col++ ){
            sb.append("<td>");
            sb.append(model.getColumnName(col));
            sb.append( "</td>");
        }
        sb.append("</tr>");
        
        //Cria os valores.
        for( int row = 0; row < model.getRowCount(); row++ ){
            sb.append("<tr>");
            for( int col = 0; col < model.getColumnCount(); col++ ){
                sb.append("<td>");
                sb.append(model.getValueAt(row, col).toString());
                sb.append( "</td>");
            }
            sb.append("</tr>");
        }
        
        sb.append("</table>");
        sb.append("</body>");
        sb.append("</head>");
        sb.append("</html>");
        
        return sb.toString();
    }
    
    public boolean GerarHTMLESalvarEmArquivo(TableModel model){
        String codigo = GerarHTML(model);
        JFileChooser dialog = new JFileChooser();
        int status = dialog.showSaveDialog(null);
        if( status == JFileChooser.APPROVE_OPTION ){
            File file = dialog.getSelectedFile();
            try{
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(codigo.getBytes());
            fos.close();
            return true;
            }catch( Exception e ){
                
            }
        }
        return false;
    }  
}
