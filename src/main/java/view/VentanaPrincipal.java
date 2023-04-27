package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.InquilinoController;
import model.Inquilino;
import model.Localidad;
import model.Vivienda;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Insets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField jtfFIni;
	private JTextField jtfFFin;

	private JList jlistInquilino;
	private DefaultListModel<Inquilino> listModelInquilino = null;
	private List<Inquilino> inquilinos = InquilinoController.findAll();
	private JButton btnInquilino;
	private JLabel lblNewLabel_2;
	private JTextField jtfInquilino;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0 };
//		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0};
//		gbl_contentPane.columnWeights = new double[]{0.0, 1.0};
//		gbl_contentPane.columnWidths = new int[]{0};
//		gbl_contentPane.rowHeights = new int[]{0};
//		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JLabel lblNewLabel = new JLabel("F. Inicio:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		jtfFIni = new JTextField();
		GridBagConstraints gbc_jtfFIni = new GridBagConstraints();
		gbc_jtfFIni.weightx = 1.0;
		gbc_jtfFIni.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFIni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFIni.gridx = 1;
		gbc_jtfFIni.gridy = 0;
		contentPane.add(jtfFIni, gbc_jtfFIni);
		jtfFIni.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("F. Fin:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfFFin = new JTextField();
		GridBagConstraints gbc_jtfFFin = new GridBagConstraints();
		gbc_jtfFFin.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFFin.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFFin.gridx = 1;
		gbc_jtfFFin.gridy = 1;
		contentPane.add(jtfFFin, gbc_jtfFFin);
		jtfFFin.setColumns(10);

		lblNewLabel_2 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);

		jtfInquilino = new JTextField();
		GridBagConstraints gbc_jtfInquilino = new GridBagConstraints();
		gbc_jtfInquilino.insets = new Insets(0, 0, 5, 0);
		gbc_jtfInquilino.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfInquilino.gridx = 1;
		gbc_jtfInquilino.gridy = 2;
		contentPane.add(jtfInquilino, gbc_jtfInquilino);
		jtfInquilino.setColumns(10);

		jlistInquilino = new JList<Inquilino>(this.getDefaultListModel());
		jlistInquilino.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		JScrollPane scrollPane = new JScrollPane(jlistInquilino);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.weighty = 1.0;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 3;
		contentPane.add(scrollPane, gbc_scrollPane);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 5, 0);
		gbc_btnGuardar.gridwidth = 2;
		gbc_btnGuardar.gridx = 0;
		gbc_btnGuardar.gridy = 4;
		contentPane.add(btnGuardar, gbc_btnGuardar);

		btnInquilino = new JButton("Nuevo Inquilino");
		btnInquilino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}
		});

		btnNewButton_1 = new JButton("Insertar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 5;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		GridBagConstraints gbc_btnInquilino = new GridBagConstraints();
		gbc_btnInquilino.insets = new Insets(0, 0, 5, 0);
		gbc_btnInquilino.gridx = 1;
		gbc_btnInquilino.gridy = 5;
		contentPane.add(btnInquilino, gbc_btnInquilino);

		btnNewButton = new JButton("Borrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 6;
		contentPane.add(btnNewButton, gbc_btnNewButton);

		agregarJlist();
	}

	/**
	 * M�todo que construye el modelo de JList, a utilizar para agregar y eliminar
	 * provincias
	 */
	private DefaultListModel<Inquilino> getDefaultListModel() {
		this.listModelInquilino = new DefaultListModel<Inquilino>();
		return this.listModelInquilino;
	}

	private void agregarJlist() {
		for (Inquilino inquilino : this.inquilinos) {
			this.listModelInquilino.addElement(inquilino);
		}
	}

	private void guardar() {
		List<Inquilino> l = new ArrayList<Inquilino>();

		for (int i = jlistInquilino.getSelectedIndices().length - 1; i >= 0; i--) {
			l.add(listModelInquilino.getElementAt(jlistInquilino.getSelectedIndices()[i]));
		}

//		for (int i = 0; i < listModelInquilino.size(); i++) {
//			l.add(listModelInquilino.getElementAt(i));
//		}

		SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
		for (Inquilino inquilino : l) {
			try {
				if (!jtfFIni.getText().isEmpty()) {
					inquilino.setFechaInicioAlquiler(sfd.parse(jtfFIni.getText()));
				} else {
					inquilino.setFechaInicioAlquiler(null);
				}

				if (!jtfFFin.getText().isEmpty()) {
					inquilino.setFechaFinAlquiler(sfd.parse(jtfFFin.getText()));
				} else {
					inquilino.setFechaFinAlquiler(null);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}

			InquilinoController.update(inquilino);
		}
	}

	private void nuevo() {
		Inquilino o = new Inquilino();

		o.setDni("jfdlsñak");
		o.setNombreCompleto(jtfInquilino.getText());
		o.setCuotaMensual(33f);
//		
//		Vivienda v = new Vivienda();
//		v.setId(1);
//		v.setDescripcion("Calle del Porrón");
//		
//		Localidad l = new Localidad();
//		l.setId(1);
//		l.setDescripcion("Villanueva de Arriba");
//		
//		v.setLocalidad(l);
		
		o.setVivienda(null);
//		o.setId(5);

		this.listModelInquilino.addElement(o);
	}

	private void insert() {
		List<Inquilino> l = new ArrayList<Inquilino>();
		for (int i = jlistInquilino.getSelectedIndices().length - 1; i >= 0; i--) {
			l.add(listModelInquilino.getElementAt(jlistInquilino.getSelectedIndices()[i]));
		}

		SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
		for (Inquilino inquilino : l) {
			System.out.println(inquilino.toString());
			try {
				if (!jtfFIni.getText().isEmpty()) {
					inquilino.setFechaInicioAlquiler(sfd.parse(jtfFIni.getText()));
				} else {
					inquilino.setFechaInicioAlquiler(null);
				}

				if (!jtfFFin.getText().isEmpty()) {
					inquilino.setFechaFinAlquiler(sfd.parse(jtfFFin.getText()));
				} else {
					inquilino.setFechaFinAlquiler(null);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}

			InquilinoController.insert(inquilino);
		}
	}

	private void eliminar() {
		for (int i = jlistInquilino.getSelectedIndices().length - 1; i >= 0; i--) {
			InquilinoController.delete(listModelInquilino.getElementAt(jlistInquilino.getSelectedIndices()[i]));
			listModelInquilino.removeElementAt(jlistInquilino.getSelectedIndices()[i]);
		}
	}
}
