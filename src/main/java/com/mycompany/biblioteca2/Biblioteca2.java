/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.biblioteca2;

import com.dao.PrestamoDAO;
import controller.PrestamoController;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import views.PrestamoView;

/**
 *
 * @author Antonio Sanchez
 */
public class Biblioteca2 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                PrestamoView view = new PrestamoView();
                PrestamoDAO dao = new PrestamoDAO();
                PrestamoController controller = new PrestamoController(view, dao);

                JFrame frame = new JFrame("Gestor de Usuarios");
                frame.setContentPane(view);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
