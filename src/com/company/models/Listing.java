package com.company.models;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class Listing extends JFrame {

    public Listing() {

        String[] columns = new String[]{"name", "gender", "age"};
        JTable tb1 = new JTable();
        DefaultTableModel dtm = new DefaultTableModel(0,0);
        dtm.setColumnIdentifiers(columns);
        tb1.setModel(dtm);

        Queries q = new Queries();
        List<Passenger> passengersName = q.getPassengerByName("john");
        passengersName.toArray();
        for(Passenger p : passengersName) {
            Object[] row = {p.name, p.gender, p.age};
            dtm.addRow(row);
        }

        List<Passenger> passengersGender = q.getPassengerByGender("male");
        passengersGender.toArray();
        for(Passenger p : passengersGender) {
            Object[] row = {p.name, p.gender, p.age};
            dtm.addRow(row);
        }

        List<Passenger> passengersAge = q.getPassengerByAge("18");
        passengersAge.toArray();
        for(Passenger p : passengersAge) {
            Object[] row = {p.name, p.gender, p.age};
            dtm.addRow(row);
        }

        List<Passenger> passengersNameGender = q.getPassengerByNameGender("john", "male");
        passengersAge.toArray();
        for(Passenger p : passengersNameGender) {
            Object[] row = {p.name, p.gender, p.age};
            dtm.addRow(row);
        }

        this.add(new JScrollPane(tb1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);


    }

}
