package ui.robo;

import aplicacao.ACMERobots;
import dados.robo.Industrial;
import ui.Aplicacao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaI {
    private ACMERobots acmeRobots = ACMERobots.getInstance();
    private Aplicacao aplicacao ;
    private JPanel panel1;
    private JTextField setorField;
    private JButton cadastrarButton;
    private JLabel imgRoboField;
    private JButton fecharButton;
    private JTextArea estadoArea;
    private JTextField idField;
    private JTextField modeloField;
    private JButton menuRobosButton;
    private JButton limparButton;
    private JButton voltar;


    public TelaI(Aplicacao app) {
        aplicacao = app;

        fecharButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int id = Integer.parseInt(idField.getText());
                    String modelo = modeloField.getText();
                    String setor = setorField.getText();
                    Industrial robo = new Industrial(id, modelo, setor);
                    if (acmeRobots.adicionarRobo(robo)){
                        JOptionPane.showMessageDialog(aplicacao, "Robo industrial cadastrado com sucesso!");
                        estadoArea.setText(robo.toString());
                    } else {
                        JOptionPane.showMessageDialog(aplicacao, "Id já existente!");
                    }
                } catch(NumberFormatException npe){
                    JOptionPane.showMessageDialog(aplicacao, "Insira os valores corretamente");
                    estadoArea.setText("Id deve receber inteiros\nModelo deve ser caracteres\nSetor deve ser caracteres");
                }
            }
        });
        menuRobosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aplicacao.mudaPainel(1);
            }
        });
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                estadoArea.setText("");
                idField.setText("");
                modeloField.setText("");
                setorField.setText("");
            }
        });
        voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(1);
            }
        });
    }

    public JPanel getPainel() {
        estadoArea.setText("");
        return panel1;
    }
}
