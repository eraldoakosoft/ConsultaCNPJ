/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultacnpj;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author erald
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button button;

    @FXML
    private Label txtNome;

    @FXML
    private TextField txtCNPJ;

    @FXML
    private Label lblNome;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblTelefone;

    @FXML
    private Label lblCapital;

    @FXML
    private Label lblSituacao;

    @FXML
    private Label lblLogra;

    @FXML
    private Label lblNum;

    @FXML
    private Label lblBairro;

    @FXML
    private Label lblMunicipio;

    @FXML
    private Label lblUF;

    @FXML
    private Label lblNatureza;

    @FXML
    private Label lblStatus;

    @FXML
    private Label lblFantasia;

    @FXML
    private Label lblTipo;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        consultar(txtCNPJ.getText());

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void consultar(String cnpj) {
        JSONObject jSONObject;
        JSONParser parser = new JSONParser();

        Empresa empresa = new Empresa();

        CoonsumidorAPI consumir = CoonsumidorAPI.getInstance();
        
      

        try {
            jSONObject = (JSONObject) parser.parse(consumir.request(cnpj));

            empresa.setNome((String) jSONObject.get("nome"));
            empresa.setCapitalSocial((String) jSONObject.get("capital_social"));
            empresa.setTelefone((String) jSONObject.get("telefone"));
            empresa.setEmail((String) jSONObject.get("email"));
            empresa.setSituacao((String) jSONObject.get("situacao"));
            empresa.setLogradouro((String) jSONObject.get("logradouro"));
            empresa.setNumero((String) jSONObject.get("numero"));
            empresa.setBairro((String) jSONObject.get("bairro"));
            empresa.setMunicipio((String) jSONObject.get("municipio"));
            empresa.setUf((String) jSONObject.get("uf"));
            empresa.setNatureza((String) jSONObject.get("natureza_juridica"));
            empresa.setStatus((String) jSONObject.get("status"));
            empresa.setFantasia((String) jSONObject.get("fantasia"));
            empresa.setTipo((String) jSONObject.get("tipo"));
            
            
            
            
            
            
            
            

            lblNome.setText(empresa.getNome());
            lblEmail.setText(empresa.getEmail());
            lblTelefone.setText(empresa.getTelefone());
            lblCapital.setText(empresa.getCapitalSocial());
            lblSituacao.setText(empresa.getSituacao());
            lblLogra.setText(empresa.getLogradouro());
            lblNum.setText(empresa.getNumero());
            lblBairro.setText(empresa.getBairro());
            lblMunicipio.setText(empresa.getMunicipio());
            lblUF.setText(empresa.getUf());
            lblNatureza.setText(empresa.getNatureza());
            lblStatus.setText(empresa.getStatus());
            lblFantasia.setText(empresa.getFantasia());
            lblTipo.setText(empresa.getTipo());
            
            

        } catch (ParseException ex) {
            Logger.getLogger(ConsultaCNPJ.class.getName()).log(Level.SEVERE, null, ex);
           
            
            
        } 

    }
   

}
