package guiritan_system_oop;

import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InventoryDashboard extends javax.swing.JFrame {

    DB_CONNECTION DB = new DB_CONNECTION();
    Color beige = new Color(229, 221, 209);
    String[] categories = {
        "-------",
        "Electronics & Gadgets",
        "Computer Components",
        "Office Supplies",
        "Furniture & Home",
        "Clothing & Apparel",
        "Tools & Equipment",
        "Miscellaneous / Other"
    };
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(InventoryDashboard.class.getName());

    public InventoryDashboard() {
        setSize(950, 720);
        initComponents();
        setResizable(false);
        setTitle("Inventory Dashboard");
        getContentPane().setBackground(beige);
        categoryComboBox.setModel(
                new javax.swing.DefaultComboBoxModel<>(categories)
        );

        productIDField.setEditable(false);
        productIDField.setBackground(new java.awt.Color(240, 240, 240));

        //button colors
        addButton.setBackground(new java.awt.Color(46, 204, 113));
        addButton.setForeground(java.awt.Color.WHITE);
        updateButton.setBackground(new java.awt.Color(52, 152, 219));
        updateButton.setForeground(java.awt.Color.WHITE);
        deleteButton.setBackground(new java.awt.Color(231, 76, 60));
        deleteButton.setForeground(java.awt.Color.WHITE);
        clearButton.setBackground(new java.awt.Color(241, 196, 15));

        //fonts
        java.awt.Font uiFont = new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 13);
        java.awt.Font boldUiFont = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 13);

        //input fields
        productNameField.setFont(uiFont);
        priceField.setFont(uiFont);
        searchField.setFont(uiFont);
        categoryComboBox.setFont(uiFont);
        quantitySpinner.setFont(uiFont);

        //buttond
        addButton.setFont(boldUiFont);
        updateButton.setFont(boldUiFont);
        deleteButton.setFont(boldUiFont);
        clearButton.setFont(boldUiFont);
        find.setFont(boldUiFont);

        //column header
        productTable.getTableHeader().setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 13));
        productTable.setFont(uiFont);
        productTable.setRowHeight(24);

        loadTableData();

        //column width
        productTable.getColumnModel().getColumn(0).setPreferredWidth(80);
        productTable.getColumnModel().getColumn(0).setMaxWidth(100);
        productTable.getColumnModel().getColumn(0).setMinWidth(60);

        productTable.getColumnModel().getColumn(1).setPreferredWidth(180);
        productTable.getColumnModel().getColumn(2).setPreferredWidth(140);

        productTable.getColumnModel().getColumn(3).setPreferredWidth(90);
        productTable.getColumnModel().getColumn(3).setMaxWidth(120);

        productTable.getColumnModel().getColumn(4).setPreferredWidth(70);
        productTable.getColumnModel().getColumn(4).setMaxWidth(90);
    }

    private void loadTableData() {
        DefaultTableModel model = (DefaultTableModel) productTable.getModel();
        model.setRowCount(0);

        try {
            String query = "SELECT * FROM products";
            ResultSet rs = DB.stat.executeQuery(query);

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("category"),
                    rs.getDouble("price"),
                    rs.getInt("quantity")
                };
                model.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error Loading Data: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        productIDField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        productNameField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        priceField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        categoryComboBox = new javax.swing.JComboBox<>();
        quantitySpinner = new javax.swing.JSpinner();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        find = new javax.swing.JButton();
        sortComboBox = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        clearSearch = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Product ID (Auto)");

        jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Product Details");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Product ID (Auto)");

        productIDField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Product Name");

        productNameField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Category");

        priceField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Quantity");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Price");

        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "......." }));

        addButton.setText("Add");
        addButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addButtonMouseClicked(evt);
            }
        });

        updateButton.setText("Update");
        updateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateButtonMouseClicked(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteButtonMouseClicked(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productIDField)
                    .addComponent(productNameField)
                    .addComponent(priceField)
                    .addComponent(categoryComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(quantitySpinner)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(addButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updateButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteButton))
                            .addComponent(clearButton))
                        .addGap(0, 31, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(202, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Search");

        find.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        find.setText("Find");
        find.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                findMouseClicked(evt);
            }
        });

        sortComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Name", "Category", "Price", "QTY" }));
        sortComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortComboBoxActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Sort");

        clearSearch.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        clearSearch.setText("Clear");
        clearSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearSearchMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(find)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sortComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchField, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addComponent(find, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clearSearch))
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(sortComboBox)
                        .addContainerGap())))
        );

        jPanel3.setBackground(new java.awt.Color(0, 204, 255));

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Product ID", "Product Name", "Category", "Price", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseClicked
        String name = productNameField.getText().trim();
        String category = categoryComboBox.getSelectedItem().toString();
        String priceStr = priceField.getText().trim();
        int quantity = (Integer) quantitySpinner.getValue();

        if (name.isEmpty() || priceStr.isEmpty() || category.equals("-------")) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields and select a category!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            double price = Double.parseDouble(priceStr);
            String query = "INSERT INTO products (name, category, price, quantity) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = DB.con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, category);
            pst.setDouble(3, price);
            pst.setInt(4, quantity);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Product added successfully!");
            loadTableData();
            clearFields();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for price!", "Format Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addButtonMouseClicked

    private void updateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButtonMouseClicked
        String idStr = productIDField.getText().trim();
        if (idStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a product from the table to update!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int id = Integer.parseInt(idStr);
            String name = productNameField.getText().trim();
            String category = categoryComboBox.getSelectedItem().toString();
            double price = Double.parseDouble(priceField.getText().trim());
            int quantity = (Integer) quantitySpinner.getValue();

            String query = "UPDATE products SET name=?, category=?, price=?, quantity=? WHERE id=?";
            PreparedStatement pst = DB.con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, category);
            pst.setDouble(3, price);
            pst.setInt(4, quantity);
            pst.setInt(5, id);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Product updated successfully!");
            loadTableData();
            clearFields();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error updating product: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_updateButtonMouseClicked

    private void deleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseClicked
        String idStr = productIDField.getText().trim();
        if (idStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a product from the table to delete!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this product?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                int id = Integer.parseInt(idStr);
                String query = "DELETE FROM products WHERE id=?";
                PreparedStatement pst = DB.con.prepareStatement(query);
                pst.setInt(1, id);
                pst.executeUpdate();

                JOptionPane.showMessageDialog(this, "Product deleted successfully!");
                loadTableData();
                clearFields();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error deleting product: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_deleteButtonMouseClicked

    private void clearButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearButtonMouseClicked
        clearFields();
    }//GEN-LAST:event_clearButtonMouseClicked

    private void findMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_findMouseClicked
        String searchText = searchField.getText().trim();
        DefaultTableModel model = (DefaultTableModel) productTable.getModel();
        model.setRowCount(0);

        try {
            String query = "SELECT * FROM products WHERE name LIKE ?";
            PreparedStatement pst = DB.con.prepareStatement(query);
            pst.setString(1, "%" + searchText + "%");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("category"),
                    rs.getDouble("price"),
                    rs.getInt("quantity")
                };
                model.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Search Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_findMouseClicked

    private void productTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productTableMouseClicked
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow >= 0) {
            productIDField.setText(productTable.getValueAt(selectedRow, 0).toString());
            productNameField.setText(productTable.getValueAt(selectedRow, 1).toString());
            categoryComboBox.setSelectedItem(productTable.getValueAt(selectedRow, 2).toString());
            priceField.setText(productTable.getValueAt(selectedRow, 3).toString());
            quantitySpinner.setValue(Integer.valueOf(productTable.getValueAt(selectedRow, 4).toString()));
        }
    }//GEN-LAST:event_productTableMouseClicked

    private void sortComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortComboBoxActionPerformed
        String selectedSort = sortComboBox.getSelectedItem().toString();
        String columnQueryPart = "id";

        switch (selectedSort) {
            case "ID":
                columnQueryPart = "id";
                break;
            case "Name":
                columnQueryPart = "name";
                break;
            case "Category":
                columnQueryPart = "category";
                break;
            case "Price":
                columnQueryPart = "price";
                break;
            case "QTY":
                columnQueryPart = "quantity";
                break;
        }

        DefaultTableModel model = (DefaultTableModel) productTable.getModel();
        model.setRowCount(0);

        try {
            String query = "SELECT * FROM products ORDER BY " + columnQueryPart + " ASC";
            ResultSet rs = DB.stat.executeQuery(query);

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("category"),
                    rs.getDouble("price"),
                    rs.getInt("quantity")
                };
                model.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Sorting Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_sortComboBoxActionPerformed

    private void clearSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearSearchMouseClicked
        searchField.setText(null);
        loadTableData();
        productTable.clearSelection();
    }//GEN-LAST:event_clearSearchMouseClicked
    private void clearFields() {
        productIDField.setText("");
        productNameField.setText("");
        categoryComboBox.setSelectedIndex(0);
        priceField.setText("");
        quantitySpinner.setValue(0);
        searchField.setText("");
        productTable.clearSelection();
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new InventoryDashboard().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JComboBox<String> categoryComboBox;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton clearSearch;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton find;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField priceField;
    private javax.swing.JTextField productIDField;
    private javax.swing.JTextField productNameField;
    private javax.swing.JTable productTable;
    private javax.swing.JSpinner quantitySpinner;
    private javax.swing.JTextField searchField;
    private javax.swing.JComboBox<String> sortComboBox;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
