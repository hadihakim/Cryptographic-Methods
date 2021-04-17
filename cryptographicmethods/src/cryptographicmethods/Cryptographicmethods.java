
package cryptographicmethods;

//import cryptographicmethods.cryptomethods;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 *
 * @author Admin
 */
public class Cryptographicmethods extends Application {
    int mode;
    
    @Override
    public void start(Stage primaryStage) {
        Scene scenepowermod, scene, sceneinvmod, scenediffhell, scenersa, sceneelgamal ;
        
        
        VBox vboxpowermod, vboxinvmod, vboxdiffhell, vboxrsa, vboxelgamal;

        Button btn1 = new Button();
        Button btn2 = new Button();
        Button btn3 = new Button();
        Button btn4 = new Button();
        Button btn5 = new Button();
        Label label = new Label("Choose CryptoMethod");
        
        btn1.setText("1");
        btn2.setText("2");
        btn3.setText("3");
        btn4.setText("4");
        btn5.setText("5");
        btn1.setStyle("-fx-background-color: #000000; -fx-text-fill: #EAEAEA; -fx-border-color: #FFBF00");
        btn2.setStyle("-fx-background-color: #000000; -fx-text-fill: #EAEAEA; -fx-border-color: #FFBF00");
        btn3.setStyle("-fx-background-color: #000000; -fx-text-fill: #EAEAEA; -fx-border-color: #FFBF00");
        btn4.setStyle("-fx-background-color: #000000; -fx-text-fill: #EAEAEA; -fx-border-color: #FFBF00");
        btn5.setStyle("-fx-background-color: #000000; -fx-text-fill: #EAEAEA; -fx-border-color: #FFBF00");
        
        HBox gridPane = new HBox();
        gridPane.setSpacing(20);
        label.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        gridPane.setStyle("-fx-background-color:rgb(0, 0, 0);-fx-padding: 30;-fx-font-size: 14px");
        gridPane.getChildren().addAll(label,btn1,btn2,btn3,btn4,btn5);
         scene = new Scene(gridPane, 700, 500);

      
        ////////////////////////ELGAMAL\\\\\\\\\\\\\\\\\\\
        Text elgamalchoose = new Text ("Choose Encryption/Decryption mode");
        Button elgamalencbtn = new Button("Encryption");
        Button elgamaldecbtn = new Button("Decryption");
       elgamalencbtn.setMaxWidth(100);
       elgamaldecbtn.setMaxWidth(100);
       
        Text elgamaltext1 = new Text();
        TextField elgamaltextfield1 = new TextField();//
        Text elgamaltext2 = new Text();
        TextField elgamaltextfield2 = new TextField();//
        Text elgamaltext3 = new Text();
        TextField elgamaltextfield3 = new TextField();//
        Text elgamaltext4 = new Text();
        TextField elgamaltextfield4 = new TextField();//
        
        elgamaltextfield1.setMaxWidth(350);
        elgamaltextfield2.setMaxWidth(350);
        elgamaltextfield3.setMaxWidth(350);
        elgamaltextfield4.setMaxWidth(350);
        
        Button elgamalsend = new Button("Send");
        Button elgamalback = new Button("Back");
        Text elgamaloutput = new Text();
         
        elgamalsend.setMaxWidth(70);
        elgamalback.setMaxWidth(70);
        
         elgamalsend.setOnAction((ActionEvent event) -> {
             if (cryptomethods.isnum(elgamaltextfield1.getText()) && cryptomethods.isnum(elgamaltextfield3.getText()) && cryptomethods.isnum(elgamaltextfield4.getText()) &&!elgamaltextfield1.getText().isEmpty() && !elgamaltextfield3.getText().isEmpty()&& !elgamaltextfield4.getText().isEmpty() && mode == 1 && cryptomethods.gcd(Integer.parseInt(elgamaltextfield3.getText()), Integer.parseInt(elgamaltextfield4.getText())) == 1 && !elgamaltextfield3.getText().equals("1")) {
                 int publickey = cryptomethods.generatepublic(Integer.parseInt(elgamaltextfield4.getText()), Integer.parseInt(elgamaltextfield3.getText()));
                 int [] cipher = cryptomethods.ElgamalEnc(Integer.parseInt(elgamaltextfield4.getText()),Integer.parseInt(elgamaltextfield3.getText()) , publickey ,Integer.parseInt(elgamaltextfield1.getText()));
                 elgamaloutput.setText("Ciphertext1 : "+cipher[0]+", Ciphertext2 : "+cipher[1]);
                 elgamaltext2.setText("Recieved public key");
                 elgamaltextfield2.setText(String.valueOf(publickey));
             }
             else if(cryptomethods.isnum(elgamaltextfield1.getText()) && cryptomethods.isnum(elgamaltextfield3.getText()) && cryptomethods.isnum(elgamaltextfield4.getText()) &&!elgamaltextfield1.getText().isEmpty()  && !elgamaltextfield3.getText().isEmpty()&& !elgamaltextfield4.getText().isEmpty() && mode == 1 && (cryptomethods.gcd(Integer.parseInt(elgamaltextfield3.getText()), Integer.parseInt(elgamaltextfield4.getText())) != 1 || elgamaltextfield3.getText().equals("1"))){
             elgamaloutput.setText("Be sure 'g' and 'p' are coprime and 'p' different than 1");
             }
             else if (cryptomethods.isnum(elgamaltextfield1.getText()) && cryptomethods.isnum(elgamaltextfield2.getText()) && cryptomethods.isnum(elgamaltextfield3.getText()) && cryptomethods.isnum(elgamaltextfield4.getText()) &&!elgamaltextfield1.getText().isEmpty() && !elgamaltextfield2.getText().isEmpty() && !elgamaltextfield3.getText().isEmpty()&& !elgamaltextfield4.getText().isEmpty() && mode == 2) {
                 int [] cipher = new int[2];
                 cipher[0] = Integer.parseInt(elgamaltextfield1.getText());
                 cipher[1] = Integer.parseInt(elgamaltextfield2.getText());
                 int  message = cryptomethods.ElgamalDec(cipher,Integer.parseInt(elgamaltextfield4.getText()) , Integer.parseInt(elgamaltextfield3.getText()));
                 elgamaloutput.setText("Plaintext: "+message);
             }
             else if (mode == 0) {
                 elgamaloutput.setText("Be sure you choose Decryption or Encryption mode!");
             }
             else
                 elgamaloutput.setText("Be sure you enter the requirements!");
             });
         
        vboxelgamal = new VBox();
        vboxelgamal.getChildren().addAll(elgamalchoose,elgamalencbtn,elgamaldecbtn,elgamaltext1,elgamaltextfield1,elgamaltext2,elgamaltextfield2,elgamaltext3,elgamaltextfield3,elgamaltext4,elgamaltextfield4,elgamalsend,elgamalback,elgamaloutput);
         vboxelgamal.setStyle("-fx-background-color:rgb(0, 0, 0);-fx-font-size: 14px");
         sceneelgamal = new Scene(vboxelgamal,700,500);
         elgamalencbtn.setStyle("-fx-background-color: #000000; -fx-text-fill: #EAEAEA; -fx-border-color: #FFBF00");
         elgamaldecbtn.setStyle("-fx-background-color: #000000; -fx-text-fill: #EAEAEA; -fx-border-color: #FFBF00");
         elgamalsend.setStyle("-fx-background-color: #000000; -fx-text-fill: #EAEAEA; -fx-border-color: #FFBF00");
         elgamalback.setStyle("-fx-background-color: #000000; -fx-text-fill: #EAEAEA; -fx-border-color: #FFBF00");
         elgamalchoose.setFont(Font.font("Gold", FontWeight.BOLD, FontPosture.REGULAR, 20));
         elgamalchoose.setFill(Color.GOLD);
         elgamaltext1.setFont(Font.font("Gold", FontWeight.BOLD, FontPosture.REGULAR, 20));
         elgamaltext1.setFill(Color.GOLD);
         elgamaltext2.setFont(Font.font("Gold", FontWeight.BOLD, FontPosture.REGULAR, 20));
         elgamaltext2.setFill(Color.GOLD);
         elgamaltext3.setFont(Font.font("Gold", FontWeight.BOLD, FontPosture.REGULAR, 20));
         elgamaltext3.setFill(Color.GOLD);
         elgamaltext4.setFont(Font.font("Gold", FontWeight.BOLD, FontPosture.REGULAR, 20));
         elgamaltext4.setFill(Color.GOLD);
         elgamaloutput.setFont(Font.font("Gold", FontWeight.BOLD, FontPosture.REGULAR, 20));
         elgamaloutput.setFill(Color.GOLD);
         
        
         
         elgamalencbtn.setOnAction((ActionEvent event) -> {
            mode = 1;
            elgamalchoose.setText("Elgamal Encryption Mode");
            elgamaltext1.setText("Enter Plaintext");
            elgamaltext2.setText("Loading...");
            elgamaltext3.setText("Enter mod 'p', Agreed upon");
            elgamaltext4.setText("Enter 'g', Agreed upon");
            elgamaltextfield2.setDisable(true);
            elgamaloutput.setText("");
            elgamaltextfield1.clear();
                elgamaltextfield2.clear();
                elgamaltextfield3.clear();
                elgamaltextfield4.clear();
                
                
             });
         elgamaldecbtn.setOnAction((ActionEvent event) -> {
            mode = 2;
            elgamalchoose.setText("Elgamal Decryption Mode");
            elgamaltext1.setText("Enter Ciphertext 1");
            elgamaltext2.setText("Enter Ciphertext 2");
            elgamaltext3.setText("Enter mod 'p', Agreed upon");
            elgamaltext4.setText("Enter your private key");
            elgamaloutput.setText("");
            elgamaltextfield2.setDisable(false);
            elgamaltextfield1.clear();
                elgamaltextfield2.clear();
                elgamaltextfield3.clear();
                elgamaltextfield4.clear();
                
            
             });
         elgamalback.setOnAction((ActionEvent event) -> {
            mode = 0;
            elgamalchoose.setText("Choose Encryption/Decryption mode");
            elgamaltext1.setText("");
            elgamaltext2.setText("");
            elgamaltext3.setText("");
            elgamaltext4.setText("");
            elgamaloutput.setText("");
            
                elgamaltextfield1.clear();
                elgamaltextfield2.clear();
                elgamaltextfield3.clear();
                elgamaltextfield4.clear();
                
                primaryStage.setScene(scene);
                primaryStage.setTitle("Crypto Methods");
             });
        
        
        
        
        ////////////////////////END ELGAMAL\\\\\\\\\\\\\\\\\
        
        
        
        ////////////////////////RSA\\\\\\\\\\\\\\\\\\\\\\\\\
        Text rsachoose = new Text ("Choose Encryption/Decryption mode");
        Button rsaencbtn = new Button("Encryption");
        Button rsadecbtn = new Button("Decryption");
        
        rsaencbtn.setMaxWidth(100);
        rsadecbtn.setMaxWidth(100);
        Text rsatext = new Text();
        TextField rsatextfield = new TextField();//
        Text rsatextkey = new Text();
        TextField rsakeyfield = new TextField();//
        Text rsamod = new Text("");
        TextField rsamodfield = new TextField();//
        
        rsatextfield.setMaxWidth(350);
        rsakeyfield.setMaxWidth(350);
        rsamodfield .setMaxWidth(350);
        Button rsasend = new Button("Send");
        Button rsaback = new Button("Back");
        Text rsaoutput = new Text();
        
        rsasend.setMaxWidth(70);
        rsaback.setMaxWidth(70);
        
         rsasend.setOnAction((ActionEvent event) -> {
             if (cryptomethods.isnum(rsatextfield.getText()) && cryptomethods.isnum(rsakeyfield.getText()) && cryptomethods.isnum(rsamodfield.getText()) && !rsatextfield.getText().isEmpty() && !rsakeyfield.getText().isEmpty() && !rsamodfield.getText().isEmpty() && mode == 1) {
                 int cipher = cryptomethods.RsaEnc(Integer.parseInt(rsatextfield.getText()),Integer.parseInt(rsakeyfield.getText()) , Integer.parseInt(rsamodfield.getText()));
                 rsaoutput.setText("Ciphertext: "+cipher);
             }
             else if (cryptomethods.isnum(rsatextfield.getText()) && cryptomethods.isnum(rsakeyfield.getText()) && cryptomethods.isnum(rsamodfield.getText()) && !rsatextfield.getText().isEmpty() && !rsakeyfield.getText().isEmpty() && !rsamodfield.getText().isEmpty() && mode == 2) {
                 int plain = cryptomethods.RsaDec(Integer.parseInt(rsatextfield.getText()),Integer.parseInt(rsakeyfield.getText()) , Integer.parseInt(rsamodfield.getText()));
                 rsaoutput.setText("Plaintext: "+plain);
             }
             else if (mode == 0) {
                 rsaoutput.setText("Be sure you choose Decryption or Encryption mode!");
             }
             else
                 rsaoutput.setText("Be sure you enter the requirements!");
             });
         
        vboxrsa = new VBox();
         vboxrsa.getChildren().addAll(rsachoose,rsaencbtn,rsadecbtn,rsatext,rsatextfield,rsatextkey,rsakeyfield,rsamod,rsamodfield,rsasend,rsaback,rsaoutput);
         vboxrsa.setStyle("-fx-background-color:rgb(0, 0, 0);-fx-font-size: 14px");
         scenersa = new Scene(vboxrsa,700,500);
         rsaencbtn.setStyle("-fx-background-color: #000000; -fx-text-fill: #EAEAEA; -fx-border-color: #FFBF00");
         rsadecbtn.setStyle("-fx-background-color: #000000; -fx-text-fill: #EAEAEA; -fx-border-color: #FFBF00");
         rsasend.setStyle("-fx-background-color: #000000; -fx-text-fill: #EAEAEA; -fx-border-color: #FFBF00");
         rsaback.setStyle("-fx-background-color: #000000; -fx-text-fill: #EAEAEA; -fx-border-color: #FFBF00");
         rsachoose.setFont(Font.font("Gold", FontWeight.BOLD, FontPosture.REGULAR, 20));
         rsachoose.setFill(Color.GOLD);
         rsatext.setFont(Font.font("Gold", FontWeight.BOLD, FontPosture.REGULAR, 20));
         rsatext.setFill(Color.GOLD);
         rsatextkey.setFont(Font.font("Gold", FontWeight.BOLD, FontPosture.REGULAR, 20));
         rsatextkey.setFill(Color.GOLD);
         rsamod.setFont(Font.font("Gold", FontWeight.BOLD, FontPosture.REGULAR, 20));
         rsamod.setFill(Color.GOLD);
         rsaoutput.setFont(Font.font("Gold", FontWeight.BOLD, FontPosture.REGULAR, 20));
         rsaoutput.setFill(Color.GOLD);
         
        
         
         rsaencbtn.setOnAction((ActionEvent event) -> {
            mode = 1;
            rsachoose.setText("RSA Encryption Mode");
            rsamod.setText("Enter mod 'm', Agreed upon"); 
            rsatext.setText("Enter Plaintext");
            rsatextkey.setText("Enter public key 'e'");
             });
         rsadecbtn.setOnAction((ActionEvent event) -> {
            mode = 2;
            rsachoose.setText("RSA Decryption Mode");
            rsamod.setText("Enter mod 'm', Agreed upon"); 
            rsatext.setText("Enter Ciphertext");
            rsatextkey.setText("Enter your private key 'd'");
            
             });
         rsaback.setOnAction((ActionEvent event) -> {
            mode = 0;
            rsachoose.setText("Choose Encryption/Decryption mode");
            rsatext.setText("");
            rsamod.setText("");
            rsatextkey.setText("");
            rsatextfield.clear();
                rsakeyfield.clear();
                rsamodfield.clear();
                rsaoutput.setText("");
                primaryStage.setScene(scene);
                primaryStage.setTitle("Crypto Methods");
             });
        
        ///////////////////////END RSA\\\\\\\\\\\\\\\\\\\\\\\
        
        ////////////////////////DIFFIE HELLMAN SCENE\\\\\\\\\\\\\\\\\\\\\\\\
        Text text1diffhell = new Text("Diffie Hellman\n Generate a Secret key between You and Bob\nEnter 'g', Agreed upon");
        TextField textfield1diffhell = new TextField();//
        Text text2diffhell = new Text("Enter your private key");
        TextField textfield2diffhell = new TextField();//
        Text text3diffhell = new Text("Enter 'p', Agreed upon");
        TextField textfield3diffhell = new TextField();//
        Button senddiffhell = new Button("Send");
        Button backdiffhell = new Button("Back");
        
        textfield1diffhell.setMaxWidth(350);
        textfield2diffhell.setMaxWidth(350);
        textfield3diffhell.setMaxWidth(350);
        
        senddiffhell.setMaxWidth(70);
        backdiffhell.setMaxWidth(70);
        Text diffhelloutput = new Text();
          vboxdiffhell = new VBox();
          vboxdiffhell.setStyle("-fx-background-color:rgb(0, 0, 0);-fx-font-size: 14px");
        vboxdiffhell.getChildren().addAll(text1diffhell,textfield1diffhell,text2diffhell,textfield2diffhell,text3diffhell,textfield3diffhell,senddiffhell,backdiffhell,diffhelloutput);
         scenediffhell = new Scene(vboxdiffhell,700,500);
         senddiffhell.setStyle("-fx-background-color: #000000; -fx-text-fill: #EAEAEA; -fx-border-color: #FFBF00");
         backdiffhell.setStyle("-fx-background-color: #000000; -fx-text-fill: #EAEAEA; -fx-border-color: #FFBF00");
         
         text1diffhell.setFont(Font.font("Gold", FontWeight.BOLD, FontPosture.REGULAR, 20));
         text1diffhell.setFill(Color.GOLD);
         text2diffhell.setFont(Font.font("Gold", FontWeight.BOLD, FontPosture.REGULAR, 20));
         text2diffhell.setFill(Color.GOLD);
         text3diffhell.setFont(Font.font("Gold", FontWeight.BOLD, FontPosture.REGULAR, 20));
         text3diffhell.setFill(Color.GOLD);
         diffhelloutput.setFont(Font.font("Gold", FontWeight.BOLD, FontPosture.REGULAR, 20));
         diffhelloutput.setFill(Color.GOLD);
         
         senddiffhell.setOnAction((ActionEvent event) -> {
             
             if (cryptomethods.isnum(textfield1diffhell.getText()) && cryptomethods.isnum(textfield2diffhell.getText()) && cryptomethods.isnum(textfield3diffhell.getText()) && !textfield3diffhell.getText().isEmpty() && !textfield2diffhell.getText().isEmpty() && !textfield1diffhell.getText().isEmpty() && cryptomethods.gcd(Integer.parseInt(textfield1diffhell.getText()), Integer.parseInt(textfield3diffhell.getText())) == 1 && !textfield3diffhell.getText().equals("1")) {
                     int g = Integer.parseInt(textfield1diffhell.getText());
                     int a = Integer.parseInt(textfield2diffhell.getText());
                     int p = Integer.parseInt(textfield3diffhell.getText());
                     int publicB =  cryptomethods.generatepublic(g,p);
                     int key = cryptomethods.secretkey(publicB, a,p );
                     diffhelloutput.setText("Bob Public key: "+publicB+"\nSecret key shared is: "+key);
                     
                
            
               }
             else if(cryptomethods.isnum(textfield1diffhell.getText()) && cryptomethods.isnum(textfield2diffhell.getText()) && cryptomethods.isnum(textfield3diffhell.getText()) && !textfield3diffhell.getText().isEmpty() && !textfield2diffhell.getText().isEmpty() && !textfield1diffhell.getText().isEmpty() && (cryptomethods.gcd(Integer.parseInt(textfield1diffhell.getText()), Integer.parseInt(textfield3diffhell.getText())) != 1 || textfield3diffhell.getText().equals("1"))){
             
             diffhelloutput.setText("Be sure 'g' and 'p' are coprime, 'p' different than 1");
             }
             else
                 diffhelloutput.setText("Please be sure you enter the requirements !");
           
         });
            backdiffhell.setOnAction((ActionEvent event) -> {
                textfield1diffhell.clear();
                textfield2diffhell.clear();
                textfield3diffhell.clear();
                diffhelloutput.setText("");
                primaryStage.setScene(scene);
                primaryStage.setTitle("Crypto Methods");
                
                 
         });
        
        
        ////////////////////////END DIFFIE HELLMAN\\\\\\\\\\\\\\\\\\\\\\\\\\
        
        
        ////////////////////////INV MOD SCENE\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        Text text1invmod = new Text("       Find Inv of a mod m, gcd(a,m)=1\n Enter a");
        TextField textfield1invmod = new TextField();//
        Text text2invmod = new Text("Enter m ");
        TextField textfield2invmod = new TextField();//
        Button sendinvmod = new Button("Send");
        Button backinvmod = new Button("Back");
        
        textfield1invmod.setMaxWidth(350);
        textfield2invmod.setMaxWidth(350);
        
        
        sendinvmod.setMaxWidth(70);
        backinvmod.setMaxWidth(70);
        Text invmodoutput = new Text();
        vboxinvmod = new VBox();
        vboxinvmod.setStyle("-fx-background-color:rgb(0, 0, 0);-fx-font-size: 14px");
        vboxinvmod.getChildren().addAll(text1invmod,textfield1invmod,text2invmod,textfield2invmod,sendinvmod,backinvmod,invmodoutput);
         sceneinvmod= new Scene(vboxinvmod,700,500);
         
         sendinvmod.setStyle("-fx-background-color: #000000; -fx-text-fill: #EAEAEA; -fx-border-color: #FFBF00");
         backinvmod.setStyle("-fx-background-color: #000000; -fx-text-fill: #EAEAEA; -fx-border-color: #FFBF00");
         
         text1invmod.setFont(Font.font("Gold", FontWeight.BOLD, FontPosture.REGULAR, 20));
         text1invmod.setFill(Color.GOLD);
         
         text2invmod.setFont(Font.font("Gold", FontWeight.BOLD, FontPosture.REGULAR, 20));
         text2invmod.setFill(Color.GOLD);
         
         invmodoutput.setFont(Font.font("Gold", FontWeight.BOLD, FontPosture.REGULAR, 20));
         invmodoutput.setFill(Color.GOLD);
         
         sendinvmod.setOnAction((ActionEvent event) -> {
             
             if (cryptomethods.isnum(textfield1invmod.getText()) && cryptomethods.isnum(textfield2invmod.getText()) && !textfield1invmod.getText().isEmpty() && !textfield2invmod.getText().isEmpty() && (cryptomethods.gcd(Integer.parseInt(textfield1invmod.getText()), (Integer.parseInt(textfield2invmod.getText()))) == 1) && !textfield2invmod.getText().equals("1")) {
             
                int a = Integer.parseInt(textfield1invmod.getText());
                int p = Integer.parseInt(textfield2invmod.getText());
                int pow =  cryptomethods.modInverse(a, p);
                invmodoutput.setText("Inv of "+a+" mod "+p+" = "+pow);
             }
             else
                 invmodoutput.setText("Please be sure you enter the requirements !");
           
         });
            backinvmod.setOnAction((ActionEvent event) -> {
                textfield1invmod.clear();
                textfield2invmod.clear();
                invmodoutput.setText("");
                primaryStage.setScene(scene);
                primaryStage.setTitle("Crypto Methods");
                
                 
         });
            
        
        
        
        ////////////////////////END INV MOD SCENE\\\\\\\\\\\\\\\\\\\\\\\\\\\
        
                ////////////////POWER MOD SCENE\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        
        
        Text text1 = new Text("Power modulo calculator: g^e mod p\n Enter g");
        TextField textfield1 = new TextField();//
        Text text2 = new Text("Enter e");
        TextField textfield2 = new TextField();//
        Text text3 = new Text("Enter p");
        TextField textfield3 = new TextField();//
        Button sendpowermod = new Button("Send");
        Button backpowermod = new Button("Back");
        
        textfield1.setMaxWidth(350);
        textfield2.setMaxWidth(350);
        textfield3.setMaxWidth(350);
        
        
        
        sendpowermod.setMaxWidth(70);
        backpowermod.setMaxWidth(70);
        Text powermodoutput = new Text();
          vboxpowermod = new VBox();
          vboxpowermod.setStyle("-fx-background-color:rgb(0, 0, 0);-fx-font-size: 14px");
        vboxpowermod.getChildren().addAll(text1,textfield1,text2,textfield2,text3,textfield3,sendpowermod,backpowermod,powermodoutput);
         scenepowermod = new Scene(vboxpowermod,700,500);
         sendpowermod.setStyle("-fx-background-color: #000000; -fx-text-fill: #EAEAEA; -fx-border-color: #FFBF00");
         backpowermod.setStyle("-fx-background-color: #000000; -fx-text-fill: #EAEAEA; -fx-border-color: #FFBF00");
         
         text1.setFont(Font.font("Gold", FontWeight.BOLD, FontPosture.REGULAR, 20));
         text1.setFill(Color.GOLD);
         text2.setFont(Font.font("Gold", FontWeight.BOLD, FontPosture.REGULAR, 20));
         text2.setFill(Color.GOLD);
         text3.setFont(Font.font("Gold", FontWeight.BOLD, FontPosture.REGULAR, 20));
         text3.setFill(Color.GOLD);
         powermodoutput.setFont(Font.font("Gold", FontWeight.BOLD, FontPosture.REGULAR, 20));
         powermodoutput.setFill(Color.GOLD);
         
         
         sendpowermod.setOnAction((ActionEvent event) -> {
             
             if (cryptomethods.isnum(textfield1.getText()) && cryptomethods.isnum(textfield2.getText()) && cryptomethods.isnum(textfield3.getText()) && !textfield3.getText().isEmpty() && !textfield2.getText().isEmpty() && !textfield1.getText().isEmpty()) {
             
                int g = Integer.parseInt(textfield1.getText());
                int e = Integer.parseInt(textfield2.getText());
                int p = Integer.parseInt(textfield3.getText());
                int pow =  cryptomethods.modulo( g,e,p);
                powermodoutput.setText(g+"^"+e+" mod "+p+" = "+pow);
             }
             else
                 powermodoutput.setText("Please be sure you enter the requirements !");
           
         });
            backpowermod.setOnAction((ActionEvent event) -> {
                textfield1.clear();
                textfield2.clear();
                textfield3.clear();
                powermodoutput.setText("");
                primaryStage.setScene(scene);
                primaryStage.setTitle("Crypto Methods");
                
                 
         });
                 
          //////////////////END POWER MOD SCENE\\\\\\\\\\\\\\\\\\\\\\
        
         btn1.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(scenepowermod);
            primaryStage.setTitle("Power Modular Calculator");
            
             
         });
         
         btn2.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(sceneinvmod);
            primaryStage.setTitle("Modular Inverse Calculator");
            
             
         });
         
         btn3.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(scenediffhell);
            primaryStage.setTitle("Diffie Hellman");
            
             
         });
         
         btn4.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(scenersa);
            primaryStage.setTitle("RSA");
            });
         
         btn5.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(sceneelgamal);
            primaryStage.setTitle("Elgamal");
            });
        
        
         primaryStage.setTitle("Crypto Methods");
        primaryStage.setScene(scene);
        primaryStage.show();
        label.setTextFill(Color.web("#FFBF00"));
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
