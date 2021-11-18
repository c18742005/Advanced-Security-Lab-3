/**
 * Advanced Security 1 - Lab 3 Part A
 * GUI application that performs Hill Cipher encryption
 * User enters the key they wish to use in the key matrix
 * User enters the plaintext they wish to encrypt in the
 * plaintext matrix
 * User presses submit to encrypt and reveal the result
 * @author steven
 */
public class HillCipherApp extends javax.swing.JFrame {

    /**
     * Creates new Hill Cipher Application
     */
    public HillCipherApp() {
        initComponents();        
    }
    
    /**
     * Function that handles the Hill Cipher algorithm
     * Function takes the keyMatrix and the plaintextMatrix
     * and multiplies these together before completing 
     * modulo 26 to get the ciphertextMatrix
     */
    private void hillCipherEncrypt() {
        int [][]keyMatrix = new int[2][2];
        int [][]plaintextMatrix = new int[2][2];
        int [][]cipherMatrix = new int[2][2];
        
        // Create the key and plaintext matrices
        createKeyMatrix(keyMatrix);
        createPlaintextMatrix(plaintextMatrix);
        
        // loop through the matrices and encrypt the plaintext using Hill Cipher
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                cipherMatrix[i][j] = 0;

                for (int k = 0; k < 2; k++) {
                    cipherMatrix[i][j] += keyMatrix[i][k] * plaintextMatrix[k][j];
                }

                cipherMatrix[i][j] = cipherMatrix[i][j] % 26;
            }
        }
        
        // Format the result to be shown by the UI
        showResult(cipherMatrix);
    }
    
    // Function to handle the creation of the key matrix
    private void createKeyMatrix(int keyMatrix[][]) {
        keyMatrix[0][0] = matrix11.getText().toUpperCase().charAt(0) % 65;
        keyMatrix[0][1] = matrix12.getText().toUpperCase().charAt(0) % 65;
        keyMatrix[1][0] = matrix21.getText().toUpperCase().charAt(0) % 65;
        keyMatrix[1][1] = matrix22.getText().toUpperCase().charAt(0) % 65;
    }
    
    // Function to handle the creation of the plaintext matrix
    private void createPlaintextMatrix(int plaintextMatrix[][]) {
        plaintextMatrix[0][0] = plaintextMatrix11.getText().toUpperCase().charAt(0) % 65;
        plaintextMatrix[0][1] = plaintextMatrix12.getText().toUpperCase().charAt(0) % 65;
        plaintextMatrix[1][0] = plaintextMatrix21.getText().toUpperCase().charAt(0) % 65;
        plaintextMatrix[1][1] = plaintextMatrix22.getText().toUpperCase().charAt(0) % 65;
    }
    
    // Function to print the ciphertext matrix to the UI
    private void showResult(int cipherMatrix[][]) {
        ciphertextMatrix11.setText(String.valueOf((char)(cipherMatrix[0][0] + 65)));
        ciphertextMatrix12.setText(String.valueOf((char)(cipherMatrix[0][1] + 65)));
        ciphertextMatrix21.setText(String.valueOf((char)(cipherMatrix[1][0] + 65)));
        ciphertextMatrix22.setText(String.valueOf((char)(cipherMatrix[1][1] + 65)));
    }

    /**
     * Function to initialise the components of the GUI
     */
    private void initComponents() {
        // Create new GUI components
        keyLabel = new javax.swing.JLabel();
        plaintextLabel = new javax.swing.JLabel();
        resultLabel = new javax.swing.JLabel();

        clearButton = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();

        matrix11 = new javax.swing.JTextField();
        matrix21 = new javax.swing.JTextField();
        matrix12 = new javax.swing.JTextField();
        matrix22 = new javax.swing.JTextField();
        parentheses1 = new javax.swing.JLabel();
        parentheses2 = new javax.swing.JLabel();
        
        plaintextMatrix11 = new javax.swing.JTextField();
        plaintextMatrix21 = new javax.swing.JTextField();
        plaintextMatrix22 = new javax.swing.JTextField();
        plaintextMatrix12 = new javax.swing.JTextField();
        parentheses3 = new javax.swing.JLabel();
        parentheses4 = new javax.swing.JLabel();
        
        ciphertextMatrix12 = new javax.swing.JTextField();
        ciphertextMatrix11 = new javax.swing.JTextField();
        ciphertextMatrix21 = new javax.swing.JTextField();
        ciphertextMatrix22 = new javax.swing.JTextField();
        parentheses5 = new javax.swing.JLabel();
        parentheses6 = new javax.swing.JLabel();

        menuBar = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        // Set application defaults
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hill Cipher App");
        setLocation(new java.awt.Point(500, 250));
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        keyLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13));
        keyLabel.setText("Key:");

        plaintextLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13));
        plaintextLabel.setText("Plaintext:");

        resultLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13));
        resultLabel.setText("Ciphertext:");

        clearButton.setBackground(new java.awt.Color(51, 153, 255));
        clearButton.setForeground(new java.awt.Color(255, 255, 255));
        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        submitButton.setBackground(new java.awt.Color(51, 153, 255));
        submitButton.setForeground(new java.awt.Color(255, 255, 255));
        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        parentheses1.setFont(new java.awt.Font("Lucida Grande", 0, 80)); 
        parentheses1.setText("(");

        parentheses2.setFont(new java.awt.Font("Lucida Grande", 0, 80)); 
        parentheses2.setText(")");

        parentheses3.setFont(new java.awt.Font("Lucida Grande", 0, 80)); 
        parentheses3.setText("(");

        parentheses4.setFont(new java.awt.Font("Lucida Grande", 0, 80)); 
        parentheses4.setText(")");

        parentheses5.setFont(new java.awt.Font("Lucida Grande", 0, 80)); 
        parentheses5.setText(")");

        parentheses6.setFont(new java.awt.Font("Lucida Grande", 0, 80));
        parentheses6.setText("(");

        ciphertextMatrix11.setEditable(false);
        ciphertextMatrix12.setEditable(false);
        ciphertextMatrix21.setEditable(false);
        ciphertextMatrix22.setEditable(false);

        jMenu2.setText("Edit");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("Cut");
        jMenu2.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setText("Copy");
        jMenu2.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem3.setText("Paste");
        jMenu2.add(jMenuItem3);

        menuBar.add(jMenu2);

        setJMenuBar(menuBar);

        // Create the layout of the GUI application
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(resultLabel)
                            .addGap(18, 18, 18)
                            .addComponent(parentheses6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(ciphertextMatrix11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(ciphertextMatrix12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(parentheses5))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(ciphertextMatrix21, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(ciphertextMatrix22, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(plaintextLabel)
                        .addComponent(keyLabel)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(parentheses1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(matrix11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(matrix12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(parentheses2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(matrix21, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(matrix22, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(parentheses3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(plaintextMatrix11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(plaintextMatrix12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(parentheses4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(plaintextMatrix21, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(plaintextMatrix22, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(clearButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(submitButton)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(parentheses1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(parentheses2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(matrix11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(matrix12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(matrix22, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(matrix21, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(keyLabel)
                        .addGap(43, 43, 43)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(parentheses3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(parentheses4))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(plaintextMatrix11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(plaintextMatrix12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(plaintextMatrix22, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(plaintextMatrix21, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(plaintextLabel)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton)
                    .addComponent(clearButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(parentheses6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(parentheses5))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ciphertextMatrix11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ciphertextMatrix12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ciphertextMatrix22, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ciphertextMatrix21, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(resultLabel)))
                .addContainerGap())
        );

        pack();
    }                    

    /**
     * Function that handles when the clear button is clicked
     * Sets all text fields to empty
     * @param evt
     */
    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        matrix11.setText("");
        matrix12.setText("");
        matrix21.setText("");
        matrix22.setText("");
        
        plaintextMatrix11.setText("");
        plaintextMatrix12.setText("");
        plaintextMatrix21.setText("");
        plaintextMatrix22.setText("");
        
        ciphertextMatrix11.setText("");
        ciphertextMatrix12.setText("");
        ciphertextMatrix21.setText("");
        ciphertextMatrix22.setText("");
    }                                           

    /**
     * Function that handles what happens when the submit button is clicked
     * Performs encryption using the Hill Cipher algorithm
     * @param evt
     */
    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        hillCipherEncrypt();
    }                                            

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch(ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HillCipherApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch(InstantiationException ex) {
            java.util.logging.Logger.getLogger(HillCipherApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch(IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HillCipherApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch(javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HillCipherApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the application */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HillCipherApp().setVisible(true);
            }
        });
    }

    // Variables declaration  
    private javax.swing.JLabel keyLabel;
    private javax.swing.JLabel plaintextLabel;
    private javax.swing.JLabel resultLabel;

    private javax.swing.JButton clearButton;
    private javax.swing.JButton submitButton;

    private javax.swing.JTextField matrix11;
    private javax.swing.JTextField matrix12;
    private javax.swing.JTextField matrix21;
    private javax.swing.JTextField matrix22;

    private javax.swing.JTextField ciphertextMatrix11;
    private javax.swing.JTextField ciphertextMatrix12;
    private javax.swing.JTextField ciphertextMatrix21;
    private javax.swing.JTextField ciphertextMatrix22;

    private javax.swing.JTextField plaintextMatrix11;
    private javax.swing.JTextField plaintextMatrix12;
    private javax.swing.JTextField plaintextMatrix21;
    private javax.swing.JTextField plaintextMatrix22;

    private javax.swing.JLabel parentheses1;
    private javax.swing.JLabel parentheses2;
    private javax.swing.JLabel parentheses3;
    private javax.swing.JLabel parentheses4;
    private javax.swing.JLabel parentheses5;
    private javax.swing.JLabel parentheses6;

    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuBar menuBar;                 
}
