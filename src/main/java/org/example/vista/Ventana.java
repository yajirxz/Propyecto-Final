package org.example.vista;

import org.example.modelo.ModeloTablaCuerpo;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
// Atributos panel 1
    private JPanel panel1;
    private JLabel lblId; //ID
    private JTextField txtId;
    private JLabel lblNombre;//Nombre
    private JTextField txtNombre;
    private JLabel lblUbicacion;  //Ubicación
    private JTextField txtUbicacion;
    private JLabel lblSistema; //Sistema
    private JTextField txtSistema;
    private JLabel lblEnfermedades; // Enfermedades
    private JTextField txtEnfermedades;
    private JLabel lblUrl;  // URL
    private JTextField txtUrl;
    private JButton btnAgregar;
    private JLabel lblAgregar;

// Atributos panel 2
    private JPanel panel2;
    private JButton btnCargar;
    private JTable tblCuerpo; //Tabla
    private JScrollPane scrollPane;
// Atributos panel 3
    private JPanel panel3;
    private ModeloTablaCuerpo modelo;
    private JLabel lblFoto;
//Atributos panel 4
    private JPanel panel4;


    private JLabel lblIdPanel4; //Etiqueta ID Panel 4
    private JTextField txtIdPanel4;
    private JLabel lblNombrePanel4; //Etiqueta Nombre Panel4
    private JTextField txtNombrePanel4;
    private JLabel lblUbicacionPanel4; //Etiqueta Ubicación Panel 4
    private JTextField txtUbicacionPanel4;
    private JLabel lblSistemaPanel4; //Etiqueta Sistema Panel 4
    private JTextField txtSistemaPanel4;
    private JLabel lblEnfermedadesPanel4; //Etiqueta Enfermedades Panel 4
    private JTextField txtEnfermedadesPanel4;
    private JLabel lblUrlPanel4; //Etiqueta URL panel 4
    private JTextField txtUrlPanel4;
    private JButton btnActualizar; //Boton Actualizar Datos
    private JLabel ApartadoEliminar;
    private JLabel lblEliminar;
    private JTextField txtEliminar;
    private JButton btnEliminar;
    private GridLayout layout;

    public Ventana(String title) throws HeadlessException {
        super(title);
        this.setSize(1200,1500);
        layout = new GridLayout(2,2);
        this.getContentPane().setLayout(layout);

        //Panel 1
        panel1 = new JPanel();
        panel1.setBackground(new Color(234, 41, 76));

        lblId = new JLabel("ID: ");
        lblNombre = new JLabel("Nombre:   ");
        lblUbicacion = new JLabel("Ubicacion:    ");
        lblSistema = new JLabel("Sistema:   ");
        lblEnfermedades = new JLabel("Enfermedades:   ");
        lblUrl = new JLabel("URL: ");

        txtId = new JTextField(3);
        txtId.setText("0");
        txtId.setEnabled(false);
        txtNombre = new JTextField(25);
        txtUbicacion = new JTextField(15);
        txtSistema = new JTextField(30);
        txtEnfermedades = new JTextField(30);
        txtUrl = new JTextField(40);

        btnAgregar = new JButton("Agregar");

        panel1.add(lblId);
        panel1.add(txtId);
        panel1.add(lblNombre);
        panel1.add(txtNombre);
        panel1.add(lblUbicacion);
        panel1.add(txtUbicacion);
        panel1.add(lblSistema);
        panel1.add(txtSistema);
        panel1.add(lblEnfermedades);
        panel1.add(txtEnfermedades);
        panel1.add(lblUrl);
        panel1.add(txtUrl);
        panel1.add(btnAgregar);

        this.getContentPane().add(panel1,0);

        //Panel 2
        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(111, 177, 131));
        btnCargar = new JButton("Cargar");
        panel2.add(btnCargar);

        tblCuerpo = new JTable();
        scrollPane = new JScrollPane(tblCuerpo);
        panel2.add(scrollPane);

        this.getContentPane().add(panel2,1);

        //Panel 3
        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(194, 145, 43));
        lblFoto = new JLabel("Foto");
        this.panel3.add(lblFoto);
        this.getContentPane().add(panel3,2);



        //Panel 4
        panel4 = new JPanel();
        panel4.setBackground(new Color(23, 130, 181, 255));

        lblIdPanel4 = new JLabel("ID");
        lblNombrePanel4 = new JLabel("Nuevo 'Nombre':");
        lblUbicacionPanel4 = new JLabel("Nuevo 'Ubicacion':");
        lblSistemaPanel4 = new JLabel("Nuevo 'Sistema':");
        lblEnfermedadesPanel4 = new JLabel("Nuevo 'Enfermedades':");
        lblUrlPanel4 = new JLabel("Nuevo 'URL':");

        txtIdPanel4 = new JTextField(3);
        txtNombrePanel4 = new JTextField(20);
        txtUbicacionPanel4 = new JTextField(15);
        txtSistemaPanel4 = new JTextField(20);
        txtEnfermedadesPanel4 = new JTextField(20);
        txtUrlPanel4 = new JTextField(50);

        btnActualizar = new JButton("Actualizar datos");


        panel4.add(lblIdPanel4);
        panel4.add(txtIdPanel4);
        panel4.add(lblNombrePanel4);
        panel4.add(txtNombrePanel4);
        panel4.add(lblUbicacionPanel4);
        panel4.add(txtUbicacionPanel4);
        panel4.add(lblSistemaPanel4);
        panel4.add(txtSistemaPanel4);
        panel4.add(lblEnfermedadesPanel4);
        panel4.add(txtEnfermedadesPanel4);
        panel4.add(lblUrlPanel4);
        panel4.add(txtUrlPanel4);

        panel4.add(btnActualizar);


        ApartadoEliminar = new JLabel("*******************************************************************************************************************************************************************");

        lblEliminar = new JLabel("Eliminar ID :");
        txtEliminar = new JTextField(3);
        btnEliminar = new JButton("Eliminar Datos");

        panel4.add(ApartadoEliminar);
        panel4.add(lblEliminar);
        panel4.add(txtEliminar);
        panel4.add(btnEliminar);

        this.getContentPane().add(panel4,3);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JLabel getLblUbicacion() {
        return lblUbicacion;
    }

    public void setLblUbicacion(JLabel lblUbicacion) {
        this.lblUbicacion = lblUbicacion;
    }

    public JTextField getTxtUbicacion() {
        return txtUbicacion;
    }

    public void setTxtUbicacion(JTextField txtUbicacion) {
        this.txtUbicacion = txtUbicacion;
    }

    public JLabel getLblSistema() {
        return lblSistema;
    }

    public void setLblSistema(JLabel lblSistema) {
        this.lblSistema = lblSistema;
    }

    public JTextField getTxtSistema() {
        return txtSistema;
    }

    public void setTxtSistema(JTextField txtSistema) {
        this.txtSistema = txtSistema;
    }

    public JLabel getLblEnfermedades() {
        return lblEnfermedades;
    }

    public void setLblEnfermedades(JLabel lblEnfermedades) {
        this.lblEnfermedades = lblEnfermedades;
    }

    public JTextField getTxtEnfermedades() {
        return txtEnfermedades;
    }

    public void setTxtEnfermedades(JTextField txtEnfermedades) {
        this.txtEnfermedades = txtEnfermedades;
    }

    public JLabel getLblUrl() {
        return lblUrl;
    }

    public void setLblUrl(JLabel lblUrl) {
        this.lblUrl = lblUrl;
    }

    public JTextField getTxtUrl() {
        return txtUrl;
    }

    public void setTxtUrl(JTextField txtUrl) {
        this.txtUrl = txtUrl;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JTable getTblCuerpo() {
        return tblCuerpo;
    }

    public void setTblCuerpo(JTable tblCuerpo) {
        this.tblCuerpo = tblCuerpo;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }

    public void setBtnCargar(JButton btnCargar) {
        this.btnCargar = btnCargar;
    }

    public JLabel getLblAgregar() {
        return lblAgregar;
    }

    public void setLblAgregar(JLabel lblAgregar) {
        this.lblAgregar = lblAgregar;
    }

    public ModeloTablaCuerpo getModelo() {
        return modelo;
    }

    public void setModelo(ModeloTablaCuerpo modelo) {
        this.modelo = modelo;
    }

    public JLabel getLblFoto() {
        return lblFoto;
    }

    public void setLblFoto(JLabel lblFoto) {
        this.lblFoto = lblFoto;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public JLabel getLblEliminar() {
        return lblEliminar;
    }

    public void setLblEliminar(JLabel lblEliminar) {
        this.lblEliminar = lblEliminar;
    }

    public JTextField getTxtEliminar() {
        return txtEliminar;
    }

    public void setTxtEliminar(JTextField txtEliminar) {
        this.txtEliminar = txtEliminar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JLabel getLblIdPanel4() {
        return lblIdPanel4;
    }

    public void setLblIdPanel4(JLabel lblIdPanel4) {
        this.lblIdPanel4 = lblIdPanel4;
    }

    public JTextField getTxtIdPanel4() {
        return txtIdPanel4;
    }

    public void setTxtIdPanel4(JTextField txtIdPanel4) {
        this.txtIdPanel4 = txtIdPanel4;
    }

    public JLabel getLblNombrePanel4() {
        return lblNombrePanel4;
    }

    public void setLblNombrePanel4(JLabel lblNombrePanel4) {
        this.lblNombrePanel4 = lblNombrePanel4;
    }

    public JTextField getTxtNombrePanel4() {
        return txtNombrePanel4;
    }

    public void setTxtNombrePanel4(JTextField txtNombrePanel4) {
        this.txtNombrePanel4 = txtNombrePanel4;
    }

    public JLabel getLblUbicacionPanel4() {
        return lblUbicacionPanel4;
    }

    public void setLblUbicacionPanel4(JLabel lblUbicacionPanel4) {
        this.lblUbicacionPanel4 = lblUbicacionPanel4;
    }

    public JTextField getTxtUbicacioPanel4() {
        return txtUbicacionPanel4;
    }

    public void setTxtUbicacioPanel4(JTextField txtUbicacioPanel4) {
        this.txtUbicacionPanel4 = txtUbicacioPanel4;
    }

    public JLabel getLblSistemaPanel4() {
        return lblSistemaPanel4;
    }

    public void setLblSistemaPanel4(JLabel lblSistemaPanel4) {
        this.lblSistemaPanel4 = lblSistemaPanel4;
    }

    public JTextField getTxtSistemaPanel4() {
        return txtSistemaPanel4;
    }

    public void setTxtSistemaPanel4(JTextField txtSistemaPanel4) {
        this.txtSistemaPanel4 = txtSistemaPanel4;
    }

    public JLabel getLblEnfermedadesPanel4() {
        return lblEnfermedadesPanel4;
    }

    public void setLblEnfermedadesPanel4(JLabel lblEnfermedadesPanel4) {
        this.lblEnfermedadesPanel4 = lblEnfermedadesPanel4;
    }

    public JTextField getTxtEnfermedadesPanel4() {
        return txtEnfermedadesPanel4;
    }

    public void setTxtEnfermedadesPanel4(JTextField txtEnfermedadesPanel4) {
        this.txtEnfermedadesPanel4 = txtEnfermedadesPanel4;
    }

    public JLabel getLblUrlPanel4() {
        return lblUrlPanel4;
    }

    public void setLblUrlPanel4(JLabel lblUrlPanel4) {
        this.lblUrlPanel4 = lblUrlPanel4;
    }

    public JTextField getTxtUrlPanel4() {
        return txtUrlPanel4;
    }

    public void setTxtUrlPanel4(JTextField txtUrlPanel4) {
        this.txtUrlPanel4 = txtUrlPanel4;
    }

    public JLabel getApartadoEliminar() {
        return ApartadoEliminar;
    }

    public void setApartadoEliminar(JLabel apartadoEliminar) {
        ApartadoEliminar = apartadoEliminar;
    }

    public void limpiar(){
        txtNombre.setText("");
        txtUbicacion.setText("");
        txtSistema.setText("");
        txtEnfermedades.setText("");
        txtUrl.setText("");

    }
    public void LimpiarPanel4(){
        txtIdPanel4.setText("");
        txtNombrePanel4.setText("");
        txtUbicacionPanel4.setText("");
        txtSistemaPanel4.setText("");
        txtEnfermedadesPanel4.setText("");
        txtUrlPanel4.setText("");
        txtEliminar.setText("");
    }
}
