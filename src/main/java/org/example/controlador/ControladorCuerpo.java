package org.example.controlador;

import org.example.modelo.CuerpoHumano;
import org.example.modelo.ModeloTablaCuerpo;
import org.example.persistencia.ConexionSingleton;
import org.example.vista.Ventana;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControladorCuerpo extends MouseAdapter {
    private Ventana view;
    private ModeloTablaCuerpo modelo;

    public ControladorCuerpo(Ventana view) {
        this.view = view;
        modelo = new ModeloTablaCuerpo();
        this.view.getTblCuerpo().setModel(modelo);
        this.view.getBtnCargar().addMouseListener(this);
        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getTblCuerpo().addMouseListener(this);
        this.view.getBtnActualizar().addMouseListener(this);
        this.view.getBtnEliminar().addMouseListener(this);

    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.view.getBtnCargar()) {

            modelo.cargarDatos();
            this.view.getTblCuerpo().setModel(modelo);
            this.view.getTblCuerpo().updateUI();
        }
        if (e.getSource() == this.view.getBtnAgregar()) {
            CuerpoHumano cuerpoHumano = new CuerpoHumano();
            cuerpoHumano.setId(0);
            cuerpoHumano.setNombre(this.view.getTxtNombre().getText());
            cuerpoHumano.setUbicacion(this.view.getTxtUbicacion().getText());
            cuerpoHumano.setSistema(this.view.getTxtSistema().getText());
            cuerpoHumano.setEnfermedades(this.view.getTxtEnfermedades().getText());
            cuerpoHumano.setUrl(this.view.getTxtUrl().getText());
            if (modelo.agregarParteCuerpo(cuerpoHumano)) {
                JOptionPane.showMessageDialog(view, "Se agrego correctamente", "Aviso",
                        JOptionPane.INFORMATION_MESSAGE);
                this.view.getTblCuerpo().updateUI();
            } else {
                JOptionPane.showMessageDialog(view, "No se pudo agregar a la base de datos. Revise su conexión",
                        "Error al Insertar", JOptionPane.ERROR_MESSAGE);
            }
            this.view.limpiar();
        }
        if (e.getSource() == this.view.getBtnEliminar()) {
            int respuesta = JOptionPane.showConfirmDialog(view, "¿Esta Seguro?", "Eliminar", JOptionPane.YES_NO_OPTION);
            if (respuesta == 0) {
                String sqlDelete = "DELETE FROM cuerpo WHERE id=?;";
                PreparedStatement pstm = null;
                try {
                    pstm = ConexionSingleton.getInstance("CuerpoHumanoDB.db").getConnection().prepareStatement(sqlDelete);
                } catch (SQLException sqle) {
                    throw new RuntimeException(sqle);
                }
                try {
                    pstm.setInt(1, Integer.parseInt(this.view.getTxtEliminar().getText()));
                    this.view.getTblCuerpo().updateUI();
                    JOptionPane.showMessageDialog(view, "Se elimino correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException a) {
                    JOptionPane.showMessageDialog(view, "Error al eliminar", "Aviso", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                try {
                    pstm.executeUpdate();
                } catch (SQLException sqle) {
                    JOptionPane.showMessageDialog(view, "Error en Id", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    throw new RuntimeException(sqle);
                } finally {
                    this.view.LimpiarPanel4();
                }

            }
        }
        if (e.getSource() == this.view.getBtnActualizar()) {
            int respuesta = JOptionPane.showConfirmDialog(view, "¿Esta seguro de actualizar?", "Actualizar datos", JOptionPane.YES_NO_OPTION);
            if (respuesta == 0) {
                CuerpoHumano cuerpoHumano = new CuerpoHumano();
                cuerpoHumano.setId(Integer.parseInt((String) this.view.getTxtIdPanel4().getText()));
                cuerpoHumano.setNombre(this.view.getTxtNombrePanel4().getText());
                cuerpoHumano.setUbicacion(this.view.getTxtUbicacioPanel4().getText());
                cuerpoHumano.setSistema(this.view.getTxtSistemaPanel4().getText());
                cuerpoHumano.setEnfermedades(this.view.getTxtEnfermedadesPanel4().getText());
                cuerpoHumano.setUrl(this.view.getTxtUrlPanel4().getText());
                this.view.getTblCuerpo().updateUI();
                if (modelo.actualizarPartesDeCuerpo(cuerpoHumano)) {
                    JOptionPane.showMessageDialog(view, "Se actualizo correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    this.view.getTblCuerpo().updateUI();
                } else {
                    JOptionPane.showMessageDialog(view, "Error al actualizar", "Aviso", JOptionPane.ERROR_MESSAGE);

                }
                this.view.LimpiarPanel4();
            } else {
                this.view.LimpiarPanel4();
            }
        }
        if (e.getSource() == this.view.getTblCuerpo()) {
            int rowIndex = this.view.getTblCuerpo().getSelectedRow();
            modelo.obtenerCuerpo(rowIndex);
            CuerpoHumano temp = modelo.obtenerCuerpo(rowIndex);
            this.view.getLblFoto().setText("");
            this.view.getLblFoto().setIcon(temp.createIcon());
        }
    }
}
