package sample;

import cesar.CesarCipher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import rot13.Rot13Cipher;
import java.io.*;


public class Controller {

    ObservableList<String> listCipher = FXCollections.observableArrayList("Cesar", "Rot13");
    @FXML
    private RadioButton encodeRButton;
    @FXML
    private RadioButton decodeRButton;
    @FXML
    private ChoiceBox<String> cb;
    @FXML
    private TextArea textArea;
    @FXML
    private TextArea codeTextArea;
    @FXML
    private TextField sourceTextBox;
    @FXML
    private  TextField destinationTextBox;

    @FXML
    private void initialize() {
        cb.setItems(listCipher);
        cb.setValue("Cesar");
    }

    public void startApp() {

        String textToCode;
        String encodedText;
        textToCode = textArea.getText();

        CesarCipher cesarCipher;
        Rot13Cipher rot13Cipher;

        if (encodeRButton.isSelected() && cb.getValue().equals("Cesar")) {
            cesarCipher = new CesarCipher(textToCode);
            encodedText = cesarCipher.encode();
            codeTextArea.setText(encodedText);

        }else if (encodeRButton.isSelected() && cb.getValue().equals("Rot13")) {
            rot13Cipher = new Rot13Cipher(textToCode);
            encodedText = rot13Cipher.encode();
            codeTextArea.setText(encodedText);
        }
        if (decodeRButton.isSelected() && cb.getValue().equals("Cesar")) {
            cesarCipher = new CesarCipher(textToCode);
            encodedText = cesarCipher.decrypt();
             codeTextArea.setText(encodedText);

        }else if (decodeRButton.isSelected() && cb.getValue().equals("Rot13")) {
           rot13Cipher = new Rot13Cipher(textToCode);
           encodedText = rot13Cipher.decode();
           codeTextArea.setText(encodedText);
        }

    }


    /// Method to open file
    public void setSelectSourceButton() throws IOException {

            String textFile = " ";
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("*txt", "*.txt"));
            File openFile = fileChooser.showOpenDialog(null);

            String fileName = openFile.getAbsolutePath();
            sourceTextBox.setText(fileName);

            FileReader reader = new FileReader((fileName));
            BufferedReader bufferedReader = new BufferedReader(reader);
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                textFile += ' ';
                textFile += line;
                textArea.setText(textFile);
            }

    }

    /// Method to save file
    public void setSelectDestinationButton() throws IOException {
        String contentText = " ";
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("*.txt", "*.txt"));
        File savedFile = fileChooser.showSaveDialog(null);

        String filename = savedFile.getAbsolutePath();
        destinationTextBox.setText(filename);

        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(savedFile));
        contentText = textArea.getText();
        fileWriter.write(contentText);
        fileWriter.close();
    }

}
