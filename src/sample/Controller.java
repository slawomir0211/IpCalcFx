package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    Label calcLabel;

    @FXML
    Button ipAddressBtn;

    @FXML
    TextField ipAddressText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ipAddressBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ipCalc();
            }
        });
        ipAddressText.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.ENTER){
                    ipCalc();
                }
            }
        });
    }

    public void ipCalc(){
        IpCalc myip = new IpCalc(ipAddressText.getText());
        calcLabel.setText(
                "IP Calc for   : " + ipAddressText.getText() + "\n\n" +
                "Address IP    : " + myip.getIpAddress() + "\n" +
                "Netmask       : " + myip.getNetmask() + "\n" +
                "Network       : " + myip.getNetwork() + "\n" +
                "Address Min   : " + myip.getAddressMin() + "\n" +
                "Address Max   : " + myip.getAddressMax() + "\n" +
                "Broadcast     : " + myip.getBroadcast() + "\n" +
                "Address Count : " + myip.getAddressCount()
        );
    }

}
