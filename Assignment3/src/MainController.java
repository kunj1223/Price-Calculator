import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private Button btnClr; // clear button

    @FXML
    private Button btnext; // exit button

    @FXML
    private Button bttnSub;  // submit button

    @FXML
    private CheckBox chkboxC;  //check box for Charger

    @FXML
    private CheckBox chkbxM;   //check box for Mouse

    @FXML
    private CheckBox chkbxU;   //check box for USB

    @FXML
    private TextArea txtArea; // TEXT AREA TO DISPLAY RESULT

    @FXML
    private TextField txtfldDiscount; // text field for discount

    @FXML
    private TextField txtfldc;  // text field for charger

    @FXML
    private TextField txtfldm;   // text field for mouse

    @FXML
    private TextField txtfldu;   // text field for USB

    @FXML
    void btnExit(ActionEvent event) {

      
      Alert a=new Alert(Alert.AlertType.CONFIRMATION); // new instance of alert to show when user click on exit button.
      a.setTitle("Confirmation Message ");  //to set title of exit page
      a.setContentText("Click Ok to exit! "); 
      a.showAndWait().ifPresent(response -> {
          if(response==ButtonType.OK)
          {
              System.exit(0);
          }
      });


    }

    @FXML
    void bttnClear(ActionEvent event) // TO reset form when button is clicked.
      {

        txtfldc.clear();
        txtfldm.clear();
        txtfldu.clear();
        txtfldDiscount.clear();
        txtArea.clear();
      
        txtfldc.setDisable(true);
        txtfldu.setDisable(true);
        txtfldm.setDisable(true);

        chkboxC.setSelected(false);
        chkbxU.setSelected(false);
        chkbxM.setSelected(false);
    }

    @FXML
    void bttnsubmit(ActionEvent event)  //  to count and display the result
    {
        
        double totalC=0.0;
        double totalU=0.0;
        double totalM=0.0;
        double total=0.0;

          if(chkboxC.isSelected()==true) // to get input if the check bx for charger is selected
           {

             totalC=Double.parseDouble(txtfldc.getText())*15;
           }

          
          if(chkbxM.isSelected()==true)  // to get input if the check bx for mouse is selected
           {

             totalM=Double.parseDouble(txtfldm.getText())*10;

           }

         
          if(chkbxU.isSelected()==true)  // to get input if the check bx for usb is selected
           {

             totalU=Double.parseDouble(txtfldu.getText())*20;

           }

           
        if(txtfldDiscount.getText().isEmpty()) //when dicsount field is empty.
        {
           total= totalC + totalM + totalU;
           txtArea.setText("Your Total  will be $ " + total +".");
        } else
        {
          double discount= Double.parseDouble(txtfldDiscount.getText()); // to get the value of discount if entered
          total= totalC + totalM + totalU - discount;
          txtArea.setText("Your Total after $ " + discount + " discount will be $ " + total +"."); // to calculate the total
        }
      
      }

    
    @FXML
    void chkBoxThree(ActionEvent event) // to visible and disable the text field for charger when check box is selected or not
    {

       if (chkboxC.isSelected()==true)
        {
          txtfldc.setDisable(false);
        } else
        {
        txtfldc.setDisable(true);
        }

    }

    @FXML
    void chkboxTwo(ActionEvent event) // to visible and disable the text field for usb when check box is selected or not
     {

      if (chkbxU.isSelected()==true) 
      {
        txtfldu.setDisable(false);
      } else
      {
        txtfldu.setDisable(true);
      }

    }

    @FXML
    void chkbxOne(ActionEvent event) // to visible and disable the text field for charger when mouse is selected or not
    {
          
      if (chkbxM.isSelected()==true) 
      {
        txtfldm.setDisable(false);
      } else
        txtfldm.setDisable(true);
      }

    }


