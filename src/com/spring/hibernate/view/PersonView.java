/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.hibernate.view;

import com.spring.hibernate.Main;
import com.spring.hibernate.entity.MaritalStatus;
import com.spring.hibernate.entity.Person;
import com.spring.hibernate.util.ComponentUtils;
import com.spring.hibernate.util.TextComponentUtils;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Fadli Hudaya
 */
public class PersonView extends javax.swing.JInternalFrame {

    /**
     * Creates new form PersonView
     */
    public PersonView() {
        initComponents();
        TextComponentUtils.setMaximumLength(50, txtNama);
        personTable.setAutoCreateColumnsFromModel(false);
        personTable.getSelectionModel().addListSelectionListener(new PersonTableListener());
        refreshTable();
        enableForm(false);
        cmbStatus.setModel(new DefaultComboBoxModel(MaritalStatus.values()));

        txtId.setEnabled(false);
        btnDelete.setEnabled(false);
        btnAdd.setEnabled(true);
        btnCancel.setEnabled(false);
        btnSave.setEnabled(false);
        btnEdit.setEnabled(false);
    }

    private void refreshTable() {
        list = Main.getSecurityService().getPersons();
        personTable.setModel(new PersonTableModel(list));
    }

    private void enableForm(boolean status) {
        txtNama.setEnabled(status);
        txtPassword.setEnabled(status);
        jdcBirthDate.setEnabled(status);
        btnBrowse.setEnabled(status);
        txtFoto.setEnabled(status);
        txtCatatan.setEnabled(status);
        cmbStatus.setEnabled(status);
    }

    private void clearForm() {
        txtId.setText("");
        txtNama.setText("");
        txtPassword.setText("");
        jdcBirthDate.setDate(null);
        //btnBrowse.setEnabled(status);
        txtFoto.setText("");
        txtCatatan.setText("");
        cmbStatus.setSelectedIndex(-1);
        personTable.getSelectionModel().clearSelection();
        lblFoto.setIcon(null);
        person = null;
    }

    private boolean validateForm() {
        if (txtNama.getText().isEmpty() | txtPassword.getPassword().toString().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    private void loadFormToModel() {
        person.setName(txtNama.getText());
        if (person.getPassword() == null || !person.getPassword().equals(String.valueOf(txtPassword.getPassword()))) {
            try {
                String toEnc = "Hash This!"; // Value to hash
                MessageDigest mdEnc = MessageDigest.getInstance("MD5");
                mdEnc.update(toEnc.getBytes(), 0, txtPassword.getPassword().toString().length());
                String md5 = new BigInteger(1, mdEnc.digest()).toString(16);
                person.setPassword(md5);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(PersonView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        person.setRemark(txtCatatan.getText());
        person.setBirthDate(jdcBirthDate.getDate());
        person.setStatus((MaritalStatus) cmbStatus.getSelectedItem());
        if (!txtFoto.getText().isEmpty()) {
            ObjectOutputStream dataOutputStream = null;
            try {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                dataOutputStream = new ObjectOutputStream(outputStream);
                dataOutputStream.writeObject(image);
                dataOutputStream.flush();
                person.setPicture(outputStream.toByteArray());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void loadModelToForm() {
        txtId.setText(String.valueOf(person.getId()));
        txtNama.setText(person.getName());
        txtPassword.setText(person.getPassword().toString());
        jdcBirthDate.setDate(person.getBirthDate());
        cmbStatus.setSelectedItem(person.getStatus());
        txtCatatan.setText(person.getRemark());
        if (person.getPicture() != null) {
            try {
                ObjectInputStream dataInputStream = new ObjectInputStream(new ByteArrayInputStream(person.getPicture()));
                image = (ImageIcon) dataInputStream.readObject();
                lblFoto.setIcon(image);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            lblFoto.setIcon(null);
        }
    }

    private void buttonConfig() {
        btnDelete.setEnabled(false);
        btnAdd.setEnabled(true);
        btnEdit.setEnabled(false);
        btnCancel.setEnabled(false);
        btnSave.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        personTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jdcBirthDate = new com.toedter.calendar.JDateChooser();
        txtFoto = new javax.swing.JTextField();
        btnBrowse = new javax.swing.JButton();
        cmbStatus = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCatatan = new javax.swing.JTextArea();
        lblFoto = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Pengguna");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        btnAdd.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnAdd.setText("Tambah");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnDelete.setText("Hapus");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnSave.setText("Simpan");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnCancel.setText("Batal");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnExit.setText("Keluar");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel1.setText("Cari :");

        txtCari.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });

        personTable.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        personTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama", "Tanggal Lahir"
            }
        ));
        personTable.setGridColor(new java.awt.Color(204, 204, 204));
        personTable.setRowHeight(22);
        jScrollPane1.setViewportView(personTable);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel2.setText("ID :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel3.setText("Nama :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel4.setText("Password :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setText("Tanggal Lahir :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setText("Foto :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel7.setText("Status Perkawinan :");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setText("Catatan :");

        txtId.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        txtNama.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jdcBirthDate.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        txtFoto.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        btnBrowse.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnBrowse.setText("...");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        cmbStatus.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jScrollPane2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        txtCatatan.setColumns(20);
        txtCatatan.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtCatatan.setRows(5);
        jScrollPane2.setViewportView(txtCatatan);

        lblFoto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Foto"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPassword))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdcBirthDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNama))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFoto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBrowse))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jdcBirthDate, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCari))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExit)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd, btnCancel, btnDelete, btnEdit, btnExit, btnSave});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete)
                    .addComponent(btnSave)
                    .addComponent(btnCancel)
                    .addComponent(btnExit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        Main.getMainFrame().personView = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        clearForm();
        enableForm(true);
        //pengaturan tombol
        btnDelete.setEnabled(false);
        btnAdd.setEnabled(false);
        btnCancel.setEnabled(true);
        btnEdit.setEnabled(false);
        btnSave.setEnabled(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (person != null) {
            enableForm(true);
            //pengaturan tombol
            btnDelete.setEnabled(false);
            btnAdd.setEnabled(false);
            btnCancel.setEnabled(true);
            btnSave.setEnabled(true);
            btnEdit.setEnabled(false);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (person != null) {
            try {
                Main.getSecurityService().delete(person);
                clearForm();
                person = null;
                refreshTable();
                enableForm(false);
                //pengaturan tombol
                buttonConfig();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Data Masih Digunakan, Tidak Bisa Dihapus!",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (validateForm()) {
            if (person == null) {
                person = new Person();
            }
            loadFormToModel();
            try {
                Main.getSecurityService().save(person);
                clearForm();
                refreshTable();
                enableForm(false);
                //pengaturan tombol
                buttonConfig();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Penyimpanan Data Gagal!",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nama dan Password Masih Kosong !",
                        "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        clearForm();
        enableForm(false);
        //pengaturan tombol
        buttonConfig();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        Main.getMainFrame().personView = null;
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        if (fileChooser == null) {
            fileChooser = new JFileChooser(System.getProperty("user.home"));
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setFileFilter(new FileNameExtensionFilter("jpg|png|gif", "jpg", "png", "gif"));
        }
        int ret = fileChooser.showOpenDialog(this);
        if (ret == JFileChooser.APPROVE_OPTION) {
            File f = fileChooser.getSelectedFile();
            try {
                Image img = ImageIO.read(new FileInputStream(f));
                //cek ke ukuran foto, jika terlalu besar resize ke max picture size
                if (img.getHeight(this) > maxPictureSize || img.getWidth(this) > maxPictureSize) {
                    if (img.getHeight(this) > img.getWidth(this)) {
                        float scale = img.getHeight(this) / maxPictureSize;
                        int widthSize = (int) (img.getWidth(this) / scale);
                        img = img.getScaledInstance(maxPictureSize, widthSize, Image.SCALE_SMOOTH);
                    } else {
                        float scale = img.getHeight(this) / maxPictureSize;
                        int heightSize = (int) (img.getHeight(this) / scale);
                        img = img.getScaledInstance(maxPictureSize, heightSize, Image.SCALE_SMOOTH);
                    }
                }
                image = new ImageIcon(img);
                lblFoto.setIcon(image);
                txtFoto.setText(f.getAbsolutePath());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Gagal membuka foto !",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        for (int i = 0; i < personTable.getRowCount(); i++) {
            if (personTable.getValueAt(i, 0).toString().startsWith(txtCari.getText())) {
                //select baris yang ditemukan
                personTable.getSelectionModel().setSelectionInterval(i, i);
                //scroll ke baris tersebut kalau ada dibawah atau diatas
                ComponentUtils.scrollToRect(personTable, i);
                break;
            }
        }
    }//GEN-LAST:event_txtCariKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cmbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdcBirthDate;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JTable personTable;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextArea txtCatatan;
    private javax.swing.JTextField txtFoto;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNama;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
    private List<Person> list;
    private Person person;
    private JFileChooser fileChooser;
    private final int maxPictureSize = 128;
    private ImageIcon image;
    //private static final Logger log = Logger.getLogger(PersonView.class);

    private class PersonTableListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (personTable.getSelectedRow() != -1) {
                person = list.get(personTable.getSelectedRow());
                person = Main.getSecurityService().getPerson(person.getId());
                loadModelToForm();
                btnDelete.setEnabled(true);
                btnAdd.setEnabled(false);
                btnCancel.setEnabled(true);
                btnEdit.setEnabled(true);
                btnSave.setEnabled(false);
            }
        }
    }

    private class PersonTableModel extends AbstractTableModel {

        private List<Person> list;

        public PersonTableModel(List<Person> list) {
            this.list = list;
        }

        @Override
        public int getRowCount() {
            return list.size();
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Person p = list.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return p.getName();
                case 1:
                    return p.getBirthDate();
                default:
                    return "";
            }
        }

    }
}
