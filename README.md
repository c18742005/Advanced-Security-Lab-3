# Advanced Security 1 - Lab 3
## Lab Instructions
- Write a Java program to encrypt plaintext using a 2 * 2 Hill cipher
- Write a Java program to perform a letter frequency attack on any monoalphabetic substitution cipher without human intervention. Your software should produce possible plaintexts in rough order of likelihood. It would be good if your user interface allowed the user to specify “give me the top 5 possible plaintexts”.

## How to run the Hill Cipher App
- Navigate to the Scripts/ folder
- Execute compileHill.sh to compile the program
- Execute executeHill.sh to start the GUI
- Enter the key you want to encrypt with
- Enter the text you wish to encrypt
- Click "Submit" to receive the encrypted message

## How to run the Letter Frequency Attack App
- Navigate to the Scripts/ folder
- Execute compileLetter.sh to compile the program
- Execute executeLetter.sh to start the GUI
- Enter the ciphertext you wish to perform the analysis on
- Choose the number of plaintexts you wish to decrypt
- Click "Submit" to receive the top possibilities with them substituted into the original ciphertext