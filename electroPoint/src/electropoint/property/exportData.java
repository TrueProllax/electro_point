
package electropoint.property;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import javax.swing.JTable;
import javax.swing.table.TableModel;


public class exportData {

    public exportData() {
    }
    
    public void exportTable (JTable table, File file) throws IOException {
        
        TableModel model = table.getModel();
        BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(new FileOutputStream(file), 
            "windows-1251")
        );
        for (int i=0;i<model.getColumnCount();i++) {
            bw.write(model.getColumnName(i)+"\t");
        }
        bw.write("\n");
        for (int i=0; i<model.getRowCount();i++) {
            for (int j=0; j<model.getColumnCount();j++) {
            bw.write(model.getValueAt(i, j).toString()+"\t");
        }
        bw.write("\n");
        }
        bw.close();
        System.out.println("Write out to "+file);
    
    }

}
