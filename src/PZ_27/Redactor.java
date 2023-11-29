package PZ_27;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Redactor extends JFrame {
    private JButton открытьФайлButton;
    private JPanel panel1;
    private JLabel открытФайлLabel;
    private JButton сохранитьButton;
    private JButton сокранитьКакButton;
    private JTextArea textArea1;
    public File file;
    public Redactor(){
        this.getContentPane().add(panel1);

        открытьФайлButton.addActionListener(e -> {
            if(dialog(FileDialog.LOAD, "Открыть файл", "*.txt")){
                StringBuilder s = new StringBuilder();
                try(FileReader reader = new FileReader(file)){
                    int c;
                    while((c = reader.read()) != -1)
                        s.append((char)c);
                }catch (IOException ex){
                    ex.printStackTrace();
                }
                textArea1.setText(s.toString());
                открытФайлLabel.setText(file.getName());
            }
        });
        сохранитьButton.addActionListener(e ->{
            if(file != null) save();
            else saveNew();
        });
        сокранитьКакButton.addActionListener(e ->{
            saveNew();
        });
    }

    private void saveNew(){
        if(textArea1.getText().length() > 0)
            if(dialog(FileDialog.SAVE, "Сохранить текстовый файл", "*.txt")){
                save();
                открытФайлLabel.setText(file.getName());
            }
    }

    private void save(){
        try{
            FileWriter writer = new FileWriter(file);
            writer.write(textArea1.getText());
            writer.flush();
            writer.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    private boolean dialog(int dialog, String title, String filter){
        FileDialog fileDialog = new FileDialog(new Frame(), title, dialog);
        fileDialog.setFile(filter);
        fileDialog.setVisible(true);
        File[] files = fileDialog.getFiles();
        if(files.length > 0){
            file = files[0];
            return true;
        }else return false;
    }
}
