
package electropoint.desktop;

import electropoint.entity.Machine;
import electropoint.entity.Sensor;
import electropoint.entity.SensorPut;
import electropoint.entity.Supplier;
import electropoint.property.PutTable;
import electropoint.property.exportData;
import electropoint.property.session;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.TemporalType;
import javax.swing.JOptionPane;
import javax.swing.UIManager;


public class mainFrame extends javax.swing.JFrame {


    private PutTable putTable = new PutTable();
    private exportData export = new exportData();
    private session ses = new session(); 
    
    public mainFrame() {
        initComponents();
        initSupplier();
        initUIManager();
        initItemMenuAuth(false);
        initTable();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        messageAddSensor = new javax.swing.JFrame();
        mainPanelMessageSensor = new javax.swing.JPanel();
        field_type = new javax.swing.JTextField();
        field_model = new javax.swing.JTextField();
        field_code = new javax.swing.JTextField();
        field_accurancy = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        textArea_additionaly = new javax.swing.JTextArea();
        chose_supplier = new javax.swing.JComboBox<>();
        button_addSensor = new javax.swing.JButton();
        messageAddSensorPut = new javax.swing.JFrame();
        mainPanelMessageSensorPut = new javax.swing.JPanel();
        chose_machine = new javax.swing.JComboBox<>();
        chose_sensor = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        tabbedMenu = new javax.swing.JTabbedPane();
        itemAuth = new javax.swing.JPanel();
        panelAuth = new javax.swing.JPanel();
        login = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        labelAuth = new javax.swing.JLabel();
        buttonAuthEntered = new javax.swing.JButton();
        buttonAuthExit = new javax.swing.JButton();
        itemMachine = new javax.swing.JPanel();
        button_machineOutload = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMachine = new javax.swing.JTable();
        buttonMachineAdd = new javax.swing.JButton();
        button_refreshMachine = new javax.swing.JButton();
        button_deleteMachine = new javax.swing.JButton();
        itemSensor = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableSensor = new javax.swing.JTable();
        button_messageAddSensor = new javax.swing.JButton();
        button_refreshSensor = new javax.swing.JButton();
        button_deleteSensor = new javax.swing.JButton();
        button_sensorOutload = new javax.swing.JButton();
        tiemSensorPut = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableSensorPut = new javax.swing.JTable();
        button_deleteSensorPut = new javax.swing.JButton();
        button_refreshSensorPut = new javax.swing.JButton();
        button_messageAddSensorPut = new javax.swing.JButton();
        button_sensorPutOutload = new javax.swing.JButton();

        messageAddSensor.setTitle("Добавление датчика");
        messageAddSensor.setMinimumSize(new java.awt.Dimension(400, 240));

        textArea_additionaly.setColumns(20);
        textArea_additionaly.setLineWrap(true);
        textArea_additionaly.setRows(5);
        textArea_additionaly.setWrapStyleWord(true);
        textArea_additionaly.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textArea_additionalyMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(textArea_additionaly);

        button_addSensor.setText("Добавить");
        button_addSensor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_addSensorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout mainPanelMessageSensorLayout = new javax.swing.GroupLayout(mainPanelMessageSensor);
        mainPanelMessageSensor.setLayout(mainPanelMessageSensorLayout);
        mainPanelMessageSensorLayout.setHorizontalGroup(
            mainPanelMessageSensorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelMessageSensorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelMessageSensorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(field_type)
                    .addComponent(field_model)
                    .addComponent(field_code)
                    .addComponent(field_accurancy)
                    .addComponent(jScrollPane4)
                    .addGroup(mainPanelMessageSensorLayout.createSequentialGroup()
                        .addComponent(chose_supplier, 0, 200, Short.MAX_VALUE)
                        .addGap(106, 106, 106)
                        .addComponent(button_addSensor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        mainPanelMessageSensorLayout.setVerticalGroup(
            mainPanelMessageSensorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelMessageSensorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(field_type)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(field_model)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(field_code)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(field_accurancy)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addGap(6, 6, 6)
                .addGroup(mainPanelMessageSensorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chose_supplier)
                    .addComponent(button_addSensor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout messageAddSensorLayout = new javax.swing.GroupLayout(messageAddSensor.getContentPane());
        messageAddSensor.getContentPane().setLayout(messageAddSensorLayout);
        messageAddSensorLayout.setHorizontalGroup(
            messageAddSensorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanelMessageSensor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        messageAddSensorLayout.setVerticalGroup(
            messageAddSensorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanelMessageSensor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        messageAddSensor.setLocationRelativeTo(null);

        messageAddSensorPut.setMinimumSize(new java.awt.Dimension(350, 150));

        jButton3.setText("Добавить");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout mainPanelMessageSensorPutLayout = new javax.swing.GroupLayout(mainPanelMessageSensorPut);
        mainPanelMessageSensorPut.setLayout(mainPanelMessageSensorPutLayout);
        mainPanelMessageSensorPutLayout.setHorizontalGroup(
            mainPanelMessageSensorPutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelMessageSensorPutLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelMessageSensorPutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .addComponent(chose_machine, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chose_sensor, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        mainPanelMessageSensorPutLayout.setVerticalGroup(
            mainPanelMessageSensorPutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelMessageSensorPutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chose_machine)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chose_sensor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout messageAddSensorPutLayout = new javax.swing.GroupLayout(messageAddSensorPut.getContentPane());
        messageAddSensorPut.getContentPane().setLayout(messageAddSensorPutLayout);
        messageAddSensorPutLayout.setHorizontalGroup(
            messageAddSensorPutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanelMessageSensorPut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        messageAddSensorPutLayout.setVerticalGroup(
            messageAddSensorPutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanelMessageSensorPut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        messageAddSensorPut.setLocationRelativeTo(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabbedMenu.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tabbedMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        labelAuth.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelAuth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAuth.setText("Авторизация");

        buttonAuthEntered.setText("ВХОД");
        buttonAuthEntered.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonAuthEnteredMouseClicked(evt);
            }
        });

        buttonAuthExit.setText("ВЫХОД");
        buttonAuthExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonAuthExitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelAuthLayout = new javax.swing.GroupLayout(panelAuth);
        panelAuth.setLayout(panelAuthLayout);
        panelAuthLayout.setHorizontalGroup(
            panelAuthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAuthLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelAuthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(login)
                    .addComponent(password)
                    .addComponent(labelAuth, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAuthLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelAuthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonAuthExit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAuthEntered, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(106, 106, 106))
        );
        panelAuthLayout.setVerticalGroup(
            panelAuthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAuthLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(labelAuth)
                .addGap(69, 69, 69)
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(buttonAuthEntered)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonAuthExit)
                .addContainerGap(144, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout itemAuthLayout = new javax.swing.GroupLayout(itemAuth);
        itemAuth.setLayout(itemAuthLayout);
        itemAuthLayout.setHorizontalGroup(
            itemAuthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemAuthLayout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(panelAuth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(272, 272, 272))
        );
        itemAuthLayout.setVerticalGroup(
            itemAuthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemAuthLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(panelAuth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        tabbedMenu.addTab("Авторизация", itemAuth);

        button_machineOutload.setText("ВЫГРУЗИТЬ");
        button_machineOutload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_machineOutloadMouseClicked(evt);
            }
        });

        tableMachine.setAutoCreateRowSorter(true);
        tableMachine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(tableMachine);

        buttonMachineAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/electropoint/resource/add.png"))); // NOI18N
        buttonMachineAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonMachineAddMouseClicked(evt);
            }
        });

        button_refreshMachine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/electropoint/resource/refresh.png"))); // NOI18N
        button_refreshMachine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_refreshMachineMouseClicked(evt);
            }
        });

        button_deleteMachine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/electropoint/resource/delete.png"))); // NOI18N
        button_deleteMachine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_deleteMachineMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout itemMachineLayout = new javax.swing.GroupLayout(itemMachine);
        itemMachine.setLayout(itemMachineLayout);
        itemMachineLayout.setHorizontalGroup(
            itemMachineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemMachineLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(itemMachineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemMachineLayout.createSequentialGroup()
                        .addComponent(button_machineOutload)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonMachineAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button_refreshMachine)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button_deleteMachine))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE))
                .addContainerGap())
        );
        itemMachineLayout.setVerticalGroup(
            itemMachineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemMachineLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(itemMachineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button_refreshMachine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_deleteMachine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonMachineAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_machineOutload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedMenu.addTab("Машины", itemMachine);

        tableSensor.setAutoCreateRowSorter(true);
        tableSensor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tableSensor);

        button_messageAddSensor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/electropoint/resource/add.png"))); // NOI18N
        button_messageAddSensor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_messageAddSensorMouseClicked(evt);
            }
        });

        button_refreshSensor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/electropoint/resource/refresh.png"))); // NOI18N
        button_refreshSensor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_refreshSensorMouseClicked(evt);
            }
        });

        button_deleteSensor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/electropoint/resource/delete.png"))); // NOI18N
        button_deleteSensor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_deleteSensorMouseClicked(evt);
            }
        });

        button_sensorOutload.setText("ВЫГРУЗИТЬ");
        button_sensorOutload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_sensorOutloadMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout itemSensorLayout = new javax.swing.GroupLayout(itemSensor);
        itemSensor.setLayout(itemSensorLayout);
        itemSensorLayout.setHorizontalGroup(
            itemSensorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemSensorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(itemSensorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemSensorLayout.createSequentialGroup()
                        .addComponent(button_sensorOutload)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button_messageAddSensor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button_refreshSensor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button_deleteSensor)))
                .addContainerGap())
        );
        itemSensorLayout.setVerticalGroup(
            itemSensorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemSensorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(itemSensorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button_refreshSensor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_deleteSensor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_messageAddSensor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_sensorOutload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedMenu.addTab("Датчики", itemSensor);

        tableSensorPut.setAutoCreateRowSorter(true);
        tableSensorPut.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tableSensorPut);

        button_deleteSensorPut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/electropoint/resource/delete.png"))); // NOI18N
        button_deleteSensorPut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_deleteSensorPutMouseClicked(evt);
            }
        });

        button_refreshSensorPut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/electropoint/resource/refresh.png"))); // NOI18N
        button_refreshSensorPut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_refreshSensorPutMouseClicked(evt);
            }
        });

        button_messageAddSensorPut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/electropoint/resource/add.png"))); // NOI18N
        button_messageAddSensorPut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_messageAddSensorPutMouseClicked(evt);
            }
        });

        button_sensorPutOutload.setText("ВЫГРУЗИТЬ");
        button_sensorPutOutload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_sensorPutOutloadMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout tiemSensorPutLayout = new javax.swing.GroupLayout(tiemSensorPut);
        tiemSensorPut.setLayout(tiemSensorPutLayout);
        tiemSensorPutLayout.setHorizontalGroup(
            tiemSensorPutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tiemSensorPutLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tiemSensorPutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tiemSensorPutLayout.createSequentialGroup()
                        .addComponent(button_sensorPutOutload)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button_messageAddSensorPut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button_refreshSensorPut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button_deleteSensorPut)))
                .addContainerGap())
        );
        tiemSensorPutLayout.setVerticalGroup(
            tiemSensorPutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tiemSensorPutLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tiemSensorPutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button_refreshSensorPut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_deleteSensorPut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_messageAddSensorPut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_sensorPutOutload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabbedMenu.addTab("Установка датчиков", tiemSensorPut);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedMenu)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedMenu)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAuthEnteredMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAuthEnteredMouseClicked
        initItemMenuAuth(true);
    }//GEN-LAST:event_buttonAuthEnteredMouseClicked

    private void buttonAuthExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAuthExitMouseClicked
        initItemMenuAuth(false);
    }//GEN-LAST:event_buttonAuthExitMouseClicked

    private void buttonMachineAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMachineAddMouseClicked
        String text = JOptionPane.showInputDialog(null, "Введите название машины");
        
        Machine m = new Machine();
        m.setName(text);
        ses.getEm().getTransaction().begin();
        ses.getEm().persist(m);
        ses.getEm().getTransaction().commit();
        initTable();
    }//GEN-LAST:event_buttonMachineAddMouseClicked

    private void button_refreshMachineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_refreshMachineMouseClicked
        initTable();
    }//GEN-LAST:event_button_refreshMachineMouseClicked

    private void button_deleteMachineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_deleteMachineMouseClicked
        try {
            int row = tableMachine.getSelectedRow();
            String text = tableMachine.getValueAt(row, 0).toString();
            Machine m = (Machine) ses.getEm().createNamedQuery("Machine.findByName").setParameter("name",text).getResultList().get(0);
            ses.getEm().getTransaction().begin();
            ses.getEm().remove(m); 
            ses.getEm().getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());  
        }
        
        initTable();
    }//GEN-LAST:event_button_deleteMachineMouseClicked

    private void button_refreshSensorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_refreshSensorMouseClicked
        
        initTable();
        
    }//GEN-LAST:event_button_refreshSensorMouseClicked

    private void button_deleteSensorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_deleteSensorMouseClicked
        try {
            int row = tableSensor.getSelectedRow();
            String text = tableSensor.getValueAt(row, 0).toString();
            Sensor s = (Sensor) ses.getEm().createNamedQuery("Sensor.findByModel").setParameter("model",text).getResultList().get(0);
            ses.getEm().getTransaction().begin();
            ses.getEm().remove(s); 
            ses.getEm().getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());  
        }
        
        initTable();
    }//GEN-LAST:event_button_deleteSensorMouseClicked

    private void button_messageAddSensorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_messageAddSensorMouseClicked
        messageAddSensor.setVisible(true);
    }//GEN-LAST:event_button_messageAddSensorMouseClicked

    private void textArea_additionalyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textArea_additionalyMouseClicked
        
        
    }//GEN-LAST:event_textArea_additionalyMouseClicked

    private void button_addSensorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_addSensorMouseClicked
        Sensor sen = new Sensor();
        String choise = chose_supplier.getSelectedItem().toString();
        Supplier sup = (Supplier) ses.getEm().createNamedQuery("Supplier.findByName").setParameter("name",choise).getResultList().get(0);
       
        sen.setSupplier(sup);
        sen.setModel(field_model.getText());
        sen.setCode(field_code.getText());
        sen.setType(field_type.getText());
        sen.setAdditionally(textArea_additionaly.getText());
        sen.setAccuracyCoordinates(field_accurancy.getText());
        
        ses.getEm().getTransaction().begin();
        ses.getEm().persist(sen);
        ses.getEm().getTransaction().commit();
        
        initTable();
        
        messageAddSensor.setVisible(false);
    }//GEN-LAST:event_button_addSensorMouseClicked

    private void button_deleteSensorPutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_deleteSensorPutMouseClicked
        
        try {
            int row = tableSensorPut.getSelectedRow();
            String nameMachine = tableSensorPut.getValueAt(row, 0).toString();
            String modelSensor = tableSensorPut.getValueAt(row, 1).toString();
            
            Machine mach = (Machine) ses.getEm().createNamedQuery("Machine.findByName").setParameter("name", nameMachine).getResultList().get(0);
            Sensor sen = (Sensor) ses.getEm().createNamedQuery("Sensor.findByModel").setParameter("model", modelSensor).getResultList().get(0);
            
            SensorPut s = (SensorPut) ses.getEm()
                    .createQuery("SELECT s FROM SensorPut s WHERE s.machine = :machine and s.sensor = :sensor")
                    .setParameter("machine", mach)
                    .setParameter("sensor", sen)
                    .getResultList().get(0);
            
            ses.getEm().getTransaction().begin();
            ses.getEm().remove(s); 
            ses.getEm().getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());  
        }
        
        initTable();
        
    }//GEN-LAST:event_button_deleteSensorPutMouseClicked

    private void button_refreshSensorPutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_refreshSensorPutMouseClicked
        
        initTable();
        
    }//GEN-LAST:event_button_refreshSensorPutMouseClicked

    private void button_messageAddSensorPutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_messageAddSensorPutMouseClicked
        
        initSensorPut();
        
        messageAddSensorPut.setVisible(true);
        
    }//GEN-LAST:event_button_messageAddSensorPutMouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        SensorPut senPut = new SensorPut();
        
        String modelSensor = chose_sensor.getSelectedItem().toString();
        String nameMachine = chose_machine.getSelectedItem().toString();
        
        Sensor sen = (Sensor) ses.getEm().createNamedQuery("Sensor.findByModel").setParameter("model", modelSensor).getResultList().get(0);
        Machine mach = (Machine) ses.getEm().createNamedQuery("Machine.findByName").setParameter("name", nameMachine).getResultList().get(0);
        
        senPut.setMachine(mach);
        senPut.setSensor(sen);
        
        ses.getEm().getTransaction().begin();
        ses.getEm().persist(senPut);
        ses.getEm().getTransaction().commit();
        
        initTable();
        
        messageAddSensorPut.setVisible(false);
    }//GEN-LAST:event_jButton3MouseClicked

    private void button_machineOutloadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_machineOutloadMouseClicked
        String nameFile = JOptionPane.showInputDialog(null, "Введите название файла");
        
        try {
            export.exportTable(tableMachine, new File(".\\outload\\"+ nameFile +".xls"));
        } catch (IOException ex) {
            Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_button_machineOutloadMouseClicked

    private void button_sensorOutloadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_sensorOutloadMouseClicked
        String nameFile = JOptionPane.showInputDialog(null, "Введите название файла");
        
        try {
            export.exportTable(tableSensor, new File(".\\outload\\"+ nameFile +".xls"));
        } catch (IOException ex) {
            Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_button_sensorOutloadMouseClicked

    private void button_sensorPutOutloadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_sensorPutOutloadMouseClicked
        String nameFile = JOptionPane.showInputDialog(null, "Введите название файла");
        
        try {
            export.exportTable(tableSensorPut, new File(".\\outload\\"+ nameFile +".xls"));
        } catch (IOException ex) {
            Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_button_sensorPutOutloadMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAuthEntered;
    private javax.swing.JButton buttonAuthExit;
    private javax.swing.JButton buttonMachineAdd;
    private javax.swing.JButton button_addSensor;
    private javax.swing.JButton button_deleteMachine;
    private javax.swing.JButton button_deleteSensor;
    private javax.swing.JButton button_deleteSensorPut;
    private javax.swing.JButton button_machineOutload;
    private javax.swing.JButton button_messageAddSensor;
    private javax.swing.JButton button_messageAddSensorPut;
    private javax.swing.JButton button_refreshMachine;
    private javax.swing.JButton button_refreshSensor;
    private javax.swing.JButton button_refreshSensorPut;
    private javax.swing.JButton button_sensorOutload;
    private javax.swing.JButton button_sensorPutOutload;
    private javax.swing.JComboBox<String> chose_machine;
    private javax.swing.JComboBox<String> chose_sensor;
    private javax.swing.JComboBox<String> chose_supplier;
    private javax.swing.JTextField field_accurancy;
    private javax.swing.JTextField field_code;
    private javax.swing.JTextField field_model;
    private javax.swing.JTextField field_type;
    private javax.swing.JPanel itemAuth;
    private javax.swing.JPanel itemMachine;
    private javax.swing.JPanel itemSensor;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel labelAuth;
    private javax.swing.JTextField login;
    private javax.swing.JPanel mainPanelMessageSensor;
    private javax.swing.JPanel mainPanelMessageSensorPut;
    private javax.swing.JFrame messageAddSensor;
    private javax.swing.JFrame messageAddSensorPut;
    private javax.swing.JPanel panelAuth;
    private javax.swing.JTextField password;
    private javax.swing.JTabbedPane tabbedMenu;
    private javax.swing.JTable tableMachine;
    private javax.swing.JTable tableSensor;
    private javax.swing.JTable tableSensorPut;
    private javax.swing.JTextArea textArea_additionaly;
    private javax.swing.JPanel tiemSensorPut;
    // End of variables declaration//GEN-END:variables

    private void initUIManager() {
        login.putClientProperty("JTextField.placeholderText", "login");
        password.putClientProperty("JTextField.placeholderText", "password");
    }

    private void initMenu() {
        
        
    }
    
    public void initItemMenuAuth(boolean active) {
        for (int i = 1; i < tabbedMenu.getTabCount(); i++) {
            tabbedMenu.setEnabledAt(i, active);
        }
    }

    private void initTable() {
        
        List listMachine = ses.getEm().createNamedQuery("Machine.findAll")
                .getResultList();
        List listSensor = ses.getEm().createNamedQuery("Sensor.findAll")
                .getResultList();
        List listSensorPut = ses.getEm().createNamedQuery("SensorPut.findAll")
                .getResultList();
        
        putTable.outputMachine(tableMachine, listMachine);
        putTable.outputSensor(tableSensor, listSensor);
        putTable.outputSensorPut(tableSensorPut, listSensorPut);
    }

    private void initSupplier() {
        List listSupllier = ses.getEm().createNamedQuery("Supplier.findAll").getResultList();
        chose_supplier.removeAllItems();
        for (Object ob : listSupllier) {
            Supplier s = (Supplier) ob;
            chose_supplier.addItem(s.getName());
        }
        
        field_type.putClientProperty("JTextField.placeholderText", "Type");
        field_model.putClientProperty("JTextField.placeholderText", "Model");
        field_code.putClientProperty("JTextField.placeholderText", "Code");
        field_accurancy.putClientProperty("JTextField.placeholderText", "AccurancyCoodinats");
    }
    
    public void initSensorPut() {
        
        List listSensor = ses.getEm().createNamedQuery("Sensor.findAll").getResultList();
        chose_sensor.removeAllItems();
        for (Object ob : listSensor) {
            Sensor s = (Sensor) ob;
            chose_sensor.addItem(s.getModel());
        }
        
        List listMachine = ses.getEm().createNamedQuery("Machine.findAll").getResultList();
        chose_machine.removeAllItems();
        for (Object ob : listMachine) {
            Machine m = (Machine) ob;
            chose_machine.addItem(m.getName());
        }
        
    }
}
