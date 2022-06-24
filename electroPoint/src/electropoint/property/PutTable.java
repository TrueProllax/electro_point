
package electropoint.property;

import electropoint.entity.Machine;
import electropoint.entity.Sensor;
import electropoint.entity.SensorPut;
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class PutTable {

    public PutTable() {
        
    }
    
    public void outputMachine (JTable table, List list) {
        Vector <String> tableHeaders = new Vector();
        Vector tableData = new Vector();
        
        tableHeaders.add("Название машины");
        
        for (int i = 0; i < list.size(); i++) {
            Vector <Object> oneRow = new Vector<Object>();
            
            Machine m = (Machine) list.get(i);
            oneRow.add(m.getName());
            
            tableData.add(oneRow);
        }
        DefaultTableModel model = new DefaultTableModel(tableData,tableHeaders);
        table.setModel(model);
        
    }
    
    public void outputSensor (JTable table, List list) {
        Vector <String> tableHeaders = new Vector();
        Vector tableData = new Vector();
        
        tableHeaders.add("Модель");
        tableHeaders.add("Тип");
        tableHeaders.add("Поставщик");
        tableHeaders.add("Точность координат");
        tableHeaders.add("Дополнительно");
        
        for (int i = 0; i < list.size(); i++) {
            Vector <Object> oneRow = new Vector<Object>();
            
            Sensor m = (Sensor) list.get(i);
            oneRow.add(m.getModel());
            oneRow.add(m.getType());
            oneRow.add(m.getSupplier().getName());
            oneRow.add(m.getAccuracyCoordinates());
            oneRow.add(m.getAdditionally());
            
            tableData.add(oneRow);
        }
        
        table.setModel(new DefaultTableModel(tableData,tableHeaders));
        
    }
    
    public void outputSensorPut (JTable table, List list) {
        Vector <String> tableHeaders = new Vector();
        Vector tableData = new Vector();
        
        tableHeaders.add("Машина");
        tableHeaders.add("Модель");
        tableHeaders.add("Тип");
        
        for (int i = 0; i < list.size(); i++) {
            Vector <Object> oneRow = new Vector<Object>();
            
            SensorPut m = (SensorPut) list.get(i);
            oneRow.add(m.getMachine().getName());
            oneRow.add(m.getSensor().getModel());
            oneRow.add(m.getSensor().getType());
            
            tableData.add(oneRow);
        }
        
        table.setModel(new DefaultTableModel(tableData,tableHeaders));
        
    }
    
}
