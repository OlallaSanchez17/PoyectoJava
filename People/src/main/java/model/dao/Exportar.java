
package model.dao;


import javax.swing.JTable;
import javax.swing.table.TableModel;
import java.io.FileWriter;
import java.io.IOException;

public class Exportar {

    public static void exportTableToCSV(JTable table, String filePath) throws IOException {
        TableModel model = table.getModel();
        FileWriter csv = new FileWriter(filePath);

     
        for (int i = 0; i < model.getColumnCount(); i++) {
            csv.write(model.getColumnName(i));
            if (i < model.getColumnCount() - 1) csv.write(",");
        }
        csv.write("\n");

     
        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 0; j < model.getColumnCount(); j++) {
                Object value = model.getValueAt(i, j);
                csv.write(value != null ? value.toString() : "");
                if (j < model.getColumnCount() - 1) csv.write(",");
            }
            csv.write("\n");
        }

        csv.close();
    }
}