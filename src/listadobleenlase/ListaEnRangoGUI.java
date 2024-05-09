/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listadobleenlase;

/**
 *
 * @author HP
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class ListaEnRangoGUI extends JFrame {
    private ListaDoble listaDb;
    private JLabel labelListaOriginal, labelListaFiltrada, labelRango, labelBuscar;
    private JTextField textFieldRangoMin, textFieldRangoMax, textFieldBuscar;
    private JButton btnFiltrar, btnBuscar;

    public ListaEnRangoGUI() {
        listaDb = new ListaDoble();

        // Configuración de la ventana
        setTitle("Lista en Rango");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());
        setResizable(false);

        // Panel superior para la lista original
        JPanel panelListaOriginal = new JPanel();
        panelListaOriginal.setLayout(new BorderLayout());
        panelListaOriginal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        labelListaOriginal = new JLabel("Elementos de la lista original:");
        panelListaOriginal.add(labelListaOriginal, BorderLayout.NORTH);
        add(panelListaOriginal, BorderLayout.NORTH);

        // Panel central para el rango y filtrado
        JPanel panelRangoFiltrado = new JPanel();
        panelRangoFiltrado.setLayout(new BorderLayout());
        panelRangoFiltrado.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        JPanel panelRango = new JPanel();
        panelRango.setLayout(new FlowLayout());
        labelRango = new JLabel("Rango (min-max):");
        textFieldRangoMin = new JTextField(5);
        textFieldRangoMax = new JTextField(5);
        btnFiltrar = new JButton("Filtrar");
        btnFiltrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                filtrarLista();
            }
        });
        panelRango.add(labelRango);
        panelRango.add(textFieldRangoMin);
        panelRango.add(textFieldRangoMax);
        panelRango.add(btnFiltrar);
        panelRangoFiltrado.add(panelRango, BorderLayout.NORTH);

        labelListaFiltrada = new JLabel();
        panelRangoFiltrado.add(labelListaFiltrada, BorderLayout.CENTER);
        add(panelRangoFiltrado, BorderLayout.CENTER);

        // Panel inferior para la búsqueda
        JPanel panelBuscar = new JPanel();
        panelBuscar.setLayout(new BorderLayout());
        panelBuscar.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        labelBuscar = new JLabel("Buscar elemento:");
        panelBuscar.add(labelBuscar, BorderLayout.NORTH);

        JPanel panelBusqueda = new JPanel();
        panelBusqueda.setLayout(new FlowLayout());
        textFieldBuscar = new JTextField(10);
        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarElemento();
            }
        });
        panelBusqueda.add(textFieldBuscar);
        panelBusqueda.add(btnBuscar);
        panelBuscar.add(panelBusqueda, BorderLayout.CENTER);
        add(panelBuscar, BorderLayout.SOUTH);
    }

   private void filtrarLista() {
    try {
        int x1 = Integer.parseInt(textFieldRangoMin.getText());
        int x2 = Integer.parseInt(textFieldRangoMax.getText());

        // Filtrar la lista
        IteradorLista iterador = new IteradorLista(listaDb);
        Nodo a = iterador.siguiente();
        while (a != null) {
            int w = a.getDato();
            if (!(w >= x1 && w <= x2)) {
                listaDb.eliminar(w);
            }
            a = iterador.siguiente();
        }

        // Actualizar la etiqueta con la lista filtrada
        StringBuilder sb = new StringBuilder();
        Nodo actual = listaDb.cabeza;
        while (actual != null) {
            sb.append(actual.dato).append(" ");
            actual = actual.adelante;
        }
        labelListaFiltrada.setText("Elementos actuales de la lista: " + sb.toString());
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Ingrese números válidos para el rango", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

   

    private void buscarElemento() {
        try {
            int elementoABuscar = Integer.parseInt(textFieldBuscar.getText());
            listaDb.buscarLista(elementoABuscar);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido para buscar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ListaEnRangoGUI gui = new ListaEnRangoGUI();
                gui.setVisible(true);
            }
        });
    }
}


