import java.util.HashMap;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

/**
 * Advanced Security 1 - Lab 3 Part B 
 * Letter frequency attack on any monoalphabetic substitution cipher without human intervention
 * User inputs the ciphertext they want to decrypt
 * User chooses the number of possible plaintexts they want 
 * User presses submit to decrypt and reveal the result
 * @author steven
 */
public class LetterFrequencyAttack extends javax.swing.JFrame {

    /**
     * Creates new form cipherApp
     */
    public LetterFrequencyAttack() {
        initComponents();        
    }
    
    // Holds english frequency of alphabet
    char[] freqAlpha = {'E','T','A','O','I','N','S', 
                            'H','R','L','D','C','U','M', 
                            'W','F','G','Y','P','B','V', 
                            'K','J','X','Q','Z'};

    /**
     * Function that performs the letter frequency attack
     */
    private void letterFreqAttack() {
        String ciphertext = ciphertextArea.getText().toUpperCase().replaceAll("\\s", "");
        HashMap<Character, Double> cipherFreq = new HashMap<>();

        // Get the frequency of the letters
        cipherFreq = getLetterFreq(ciphertext);

        // Replace letters in ciphertext with possible corresponding plaintext letters
        String decipheredText = replaceLetters(ciphertext, cipherFreq);

        // Set result text to the possible deciphered text
        possibilityTextArea.setText(decipheredText);
    }

    /**
     * Function that gets the letter frequencies of the ciphertext
     * @param ciphertext the ciphertext string
     * @return the frequency of each letter in a hash map
     */
    private HashMap<Character, Double> getLetterFreq(String ciphertext) {
        HashMap<Character, Double> cipherFreq = new HashMap<>();

        // Loop through the ciphertext
        for(int i = 0; i < ciphertext.length(); i++) {
            char ch = ciphertext.charAt(i);

            // if character is a letter, increment the letter in the hashmap
            if(Character.isLetter(ch)) {
                // if letter is not currently in the hashmap then add it and increment
                // else increment the value by 1
                double count = cipherFreq.containsKey(ch) ? cipherFreq.get(ch) : 0;
                cipherFreq.put(ch, count + 1);
            }
        }

        // Loop through the hashmap and calculate the frequnecy each letter appears
        cipherFreq.forEach((key, val) -> cipherFreq.put(key, val = (val / ciphertext.length()) * 100));

        return cipherFreq;
    }

    /**
     * Function that replaces letters in the ciphertext with the deciphered letters
     * @param ciphertext the ciphertext string
     * @param cipherFreq the frequency each letter has
     * @return the deciphered text string
     */
    private String replaceLetters(String ciphertext, HashMap<Character, Double> cipherFreq) {
        char[] decipheredText = new char[ciphertext.length()];
        int numPossibilities = (Integer) numPossibilitiesSpinner.getValue();
        StringBuilder str = new StringBuilder("Top " + numPossibilities + " possibilities are:\n");
        
        // If the number of possibilities the user wants exceeds the number of distinct letters in the ciphertext
        // Return an error message and ask to pick a lower number of possibilities
        if(numPossibilities > cipherFreq.size()) {
            return "Not enough letters in the ciphertext to map to possibilities\nPlease choose a lower number of possibilities.";
        }

        // Loop through the hashmap that contains the frequency of letters in the cipher
        for(int i = 0; i < numPossibilities; i++) {
            // store the letter with the highest frequency
            char ch = Collections.max(cipherFreq.entrySet(), Comparator.comparingDouble(Map.Entry::getValue)).getKey();

            // Print the substitution that should occur
            str.append(ch);
            str.append(" -> ");
            str.append(freqAlpha[i]);
            str.append("\n");
            
            // Loop through the ciphertext
            for(int j = 0; j < ciphertext.length(); j++) {
                /* If the ciphertext letter and the max frequency letter match
                  * Then replace the ciphertext letter with the next letter in the 
                  * English frequency alphabet */
                if(ciphertext.charAt(j) == ch) {
                    decipheredText[j] = freqAlpha[i];
                } else if(decipheredText[j] == '\u0000') {
                    // if deciphered text is not yet set then set it
                    decipheredText[j] = ciphertext.charAt(j);
                }
            }

            // Remove the key from the hashmap
            cipherFreq.remove(ch);
        }
        
        // Pritn the deciphered text once the letters are swapped
        str.append("\nSubstituting letters gives:\n");
        str.append(String.valueOf(decipheredText));

        return str.toString();
    }

    /**
     * Function to initialise components of the application
     */
    private void initComponents() {

        ciphertextArea = new javax.swing.JTextArea();
        clearButton = new javax.swing.JButton();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        menuBar = new javax.swing.JMenuBar();
        numPossibilitiesLabel = new javax.swing.JLabel();
        numPossibilitiesSpinner = new javax.swing.JSpinner();
        plaintextLabel = new javax.swing.JLabel();
        posibilitiesLabel = new javax.swing.JLabel();
        possibilityTextArea = new javax.swing.JTextArea();
        submitButton = new javax.swing.JButton();

        // Set default settings
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Letter Frequency Attack");
        setLocation(new java.awt.Point(500, 250));
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        plaintextLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13));
        plaintextLabel.setText("Ciphertext:");

        posibilitiesLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13));
        posibilitiesLabel.setText("Possibilities:");

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

        ciphertextArea.setColumns(20);
        ciphertextArea.setLineWrap(true);
        ciphertextArea.setRows(5);
        jScrollPane1.setViewportView(ciphertextArea);

        possibilityTextArea.setColumns(20);
        possibilityTextArea.setLineWrap(true);
        possibilityTextArea.setRows(5);
        jScrollPane2.setViewportView(possibilityTextArea);

        numPossibilitiesLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13));
        numPossibilitiesLabel.setText("Number of Possibilities Wanted:");

        numPossibilitiesSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 26, 1));

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

        // Set the layout of the app
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(plaintextLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(posibilitiesLabel)
                        .addGap(430, 431, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(numPossibilitiesLabel)
                        .addGap(18, 18, 18)
                        .addComponent(numPossibilitiesSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clearButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(submitButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(plaintextLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numPossibilitiesLabel)
                    .addComponent(numPossibilitiesSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearButton)
                    .addComponent(submitButton))
                .addGap(18, 18, 18)
                .addComponent(posibilitiesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }                     

    /**
     * Function to handle what happens when the clear button is clicked
     * @param evt
     */
    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        ciphertextArea.setText("");
        possibilityTextArea.setText("");
    }                                           

    /**
     * Function to handle what happens when the submit button is clicked
     * @param evt
     */
    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        letterFreqAttack();
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
            java.util.logging.Logger.getLogger(LetterFrequencyAttack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch(InstantiationException ex) {
            java.util.logging.Logger.getLogger(LetterFrequencyAttack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch(IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LetterFrequencyAttack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch(javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LetterFrequencyAttack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the app */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LetterFrequencyAttack().setVisible(true);
            }
        });
    }

    // Variables declaration                  
    private javax.swing.JTextArea ciphertextArea;
    private javax.swing.JButton clearButton;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JLabel numPossibilitiesLabel;
    private javax.swing.JSpinner numPossibilitiesSpinner;
    private javax.swing.JLabel plaintextLabel;
    private javax.swing.JLabel posibilitiesLabel;
    private javax.swing.JTextArea possibilityTextArea;
    private javax.swing.JButton submitButton;                 
}