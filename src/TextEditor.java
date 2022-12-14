import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class TextEditor implements ActionListener {
    JFrame frame;
    JMenuBar menubar;
    JMenu file,edit;
    JMenuItem newfile,openFile,saveFile;
    JMenuItem cut,copy,paste,selectAll,close;
    JTextArea textArea;
    TextEditor (){
        //initialize all the items of class
        frame=new JFrame();//initialize frame
        menubar=new JMenuBar();//initialize menubar
        file=new JMenu("File");//initialize menu
        edit=new JMenu("Edit");//initialize menu
        newfile=new JMenuItem("New");//initialize menuItem
        openFile=new JMenuItem("Open");
        saveFile=new JMenuItem("Save");
        cut=new JMenuItem("Cut");
        copy=new JMenuItem("Copy");
        paste=new JMenuItem("Paste");
        selectAll=new JMenuItem("Select All");
        close=new JMenuItem("Close");
        textArea=new JTextArea();//Initialized textarea

        //adding action listener to menuItems
        newfile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);
        close.addActionListener(this);

        //adding menuItems for file menu
        file.add(newfile);
        file.add(openFile);
        file.add(saveFile);

        //adding menuItems for edit menu
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        edit.add(close);

        //adding menus to menubar
        menubar.add(file);
        menubar.add(edit);

        //adding menubar to frame
        frame.setJMenuBar(menubar);
        //adding text area to frame
        frame.add(textArea);





        //setting boundary for frame (x axis,y axis , width, height)
        frame.setBounds(100,100,800,500);
        //making frame visible
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent){
        if(actionEvent.getSource()==cut){
            textArea.cut();
        }
        if(actionEvent.getSource()==copy){
            textArea.copy();
        }
        if(actionEvent.getSource()==paste){
            textArea.paste();
        }
        if(actionEvent.getSource()==selectAll){
            textArea.selectAll();
        }
        if(actionEvent.getSource()==close){
            System.exit(0);
        }
        if(actionEvent.getSource()==newfile){
            TextEditor tr=new TextEditor();
        }
        if(actionEvent.getSource()==openFile){
            JFileChooser fileChooser=new JFileChooser("C:");
            int chooseOption=fileChooser.showOpenDialog(null);
            if(chooseOption==JFileChooser.APPROVE_OPTION){
                File file=fileChooser.getSelectedFile();
                String filePath=file.getPath();

                try{
                    BufferedReader bufferedReader=new BufferedReader(new FileReader(filePath));
                    String intermediate="",output="";
                    while((intermediate = bufferedReader.readLine())!=null){
                        output+=intermediate;

                    }
                    textArea.setText(output);
                }
                catch(Exception exception){
                    exception.printStackTrace();

                }
            }
        }
        if(actionEvent.getSource()==saveFile){
        JFileChooser fileChooser=new JFileChooser("C:");
        int chooseOption=fileChooser.showOpenDialog(null);
        if(chooseOption==JFileChooser.APPROVE_OPTION){
            File file= new File(fileChooser.getSelectedFile().getAbsolutePath()+"txt");
            try{
                BufferedWriter outfile= new BufferedWriter(new FileWriter(file));
                textArea.write(outfile);
                outfile.close();
            }
            catch(Exception exception){
                exception.printStackTrace();
            }
        }

        }

    }

    public static void main(String[] args) {
        TextEditor tr=new TextEditor();


    }
}