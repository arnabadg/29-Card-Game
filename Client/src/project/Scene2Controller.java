package project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import static project.Project.drawcard1;
import static project.Project.play1;

import static project.Project.bid;
import static project.Project.bidder;
import static project.Project.drawcard2;
import static project.Project.ourpoint;
import static project.Project.ourscore;
import static project.Project.theirpoint;
import static project.Project.theirscore;
import static project.Project.trump;



public class Scene2Controller implements Initializable {

    
    ImageView x=new ImageView();
    int z=0;
    
    @FXML
    ImageView face1=new ImageView();
    @FXML
    ImageView face2=new ImageView();
    @FXML
    ImageView face3=new ImageView();
    @FXML
    ImageView face4=new ImageView();
    @FXML
    ImageView card1=new ImageView();
    @FXML
    ImageView card2=new ImageView();
    @FXML
    ImageView card3=new ImageView();
    @FXML
    ImageView card4=new ImageView();
    @FXML
    ImageView card5=new ImageView();
    @FXML
    ImageView card6=new ImageView();
    @FXML
    ImageView card7=new ImageView();
    @FXML
    ImageView card8=new ImageView();
    @FXML
    ImageView draw1=new ImageView();
    @FXML
    ImageView draw2=new ImageView();
    @FXML
    ImageView draw3=new ImageView();
    @FXML
    ImageView draw4=new ImageView();
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    ChoiceBox<String> settrump = new ChoiceBox<>();
    
    @FXML
    private Button trumpbutton;
    @FXML
    private ChoiceBox<String> placebid=new ChoiceBox<>();
    @FXML
    private Button bidbutton;
    @FXML
    private Button newdealbutton;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Label label5;
    @FXML
    private Button showtrumpbutton;
    @FXML
    private Label label6;
    @FXML
    private Label label7;
    
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        
        settrump.setVisible(false);
        trumpbutton.setVisible(false);
        placebid.setVisible(false);
        bidbutton.setVisible(false);
        showtrumpbutton.setDisable(true);
        label2.setVisible(false);
        label5.setVisible(false);
        
        //setlabel
        label2.setText(bidder+bid);
        label3.setText("Our Points: "+ourpoint);
        label4.setText("Their Points: "+theirpoint);
        label6.setText("Our Scores: "+ourscore);
        label7.setText("Their Scores: "+theirscore);
        
        //choicebox
        settrump.setValue("Clubs");
        settrump.getItems().addAll("Clubs", "Diamonds", "Spades","Hearts");
        //choicebox
        placebid.setValue("PASS");
        placebid.getItems().addAll("PASS","16", "17", "18","19",
                "20","21","22","23","24","25","26","27","28");
        
        
        newdealbutton.setOnAction(e->
        {
            newdealbutton.setVisible(false);
            show1(play1);
            placebid.setVisible(true);
            bidbutton.setVisible(true);
            
        });
        bidbutton.setOnAction(e ->{
            String s1=getChoice(placebid);
            if(s1!="PASS")
            {
                bid=Integer.parseInt(s1);
            }
            placebid.setVisible(false);
            bidbutton.setVisible(false);
            
            trumpbutton.setVisible(true);
            settrump.setVisible(true);
        });
        trumpbutton.setOnAction(e -> 
        {
            trump=getChoice(placebid);
            
            trumpbutton.setVisible(false);
            settrump.setVisible(false);
            show2(play1);
        });
        
        
        playcard(play1);
        
    }
    
    
    //showing card after newdeal
    public void show1(int arr[])
    {
        drawcard1();
        for(int i=1;i<=4;i++)
        {
            if(i==1)
            {
              x=card3;
            }
            else if(i==2)
            {
               x=card4;
            }
            else if(i==3)
            {
               x=card5;
            }
            else
            {
               x=card6;
            }
            
            imageupload(x,arr[i]);
        }
    }
    
    //showing card after trump set
    public void show2(int arr[])
    {
        drawcard2();
        for(int i=1;i<=8;i++)
        {
            if(i==1)
            {
              x=card1;
            }
            else if(i==2)
            {
               x=card2;
            }
            else if(i==3)
            {
               x=card3;
            }
            else if(i==4)
            {
               x=card4;
            }
            else if(i==5)
            {
               x=card5;
            }
            else if(i==6)
            {
               x=card6;
            }
            else if(i==7)
            {
               x=card7;
            }
            else
            {
               x=card8;
            }
            
            imageupload(x,arr[i]);
        }
    }

    public void playcard(int arr[])
    {
        
        card1.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
        z=1;
        card1.setVisible(false);
        event.consume();
        imageupload(draw1,arr[z]);
        });
        
        card2.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
        z=2;
        card2.setVisible(false);
        event.consume();
        imageupload(draw1,arr[z]);
        });
        
    
    }
    
    //image upload in imageview
    public void imageupload(ImageView x,int a)
    {
            if(a==1)
            {
                Image img=new Image("cardpic/A01.png");
                x.setImage(img);
       
            }
            if(a==2)
            {
                Image img=new Image("cardpic/A02.png");
                x.setImage(img);
       
            }
            if(a==3)
            {
                Image img=new Image("cardpic/A03.png");
                x.setImage(img);
       
            }
            if(a==4)
            {
                Image img=new Image("cardpic/A04.png");
                x.setImage(img);
       
            }
            if(a==5)
            {
                Image img=new Image("cardpic/A05.png");
                x.setImage(img);
       
            }
            if(a==6)
            {
                Image img=new Image("cardpic/A06.png");
                x.setImage(img);
       
            }
            if(a==7)
            {
                Image img=new Image("cardpic/A07.png");
                x.setImage(img);
       
            }
            if(a==8)
            {
                Image img=new Image("cardpic/A08.png");
                x.setImage(img);
       
            }
            if(a==9)
            {
                Image img=new Image("cardpic/A09.png");
                x.setImage(img);
       
            }
            if(a==10)
            {
                Image img=new Image("cardpic/A10.png");
                x.setImage(img);
       
            }
            if(a==11)
            {
                Image img=new Image("cardpic/A11.png");
                x.setImage(img);
       
            }
            if(a==12)
            {
                Image img=new Image("cardpic/A12.png");
                x.setImage(img);
       
            }
            if(a==13)
            {
                Image img=new Image("cardpic/A13.png");
                x.setImage(img);
       
            }
            if(a==14)
            {
                Image img=new Image("cardpic/A14.png");
                x.setImage(img);
       
            }
            if(a==15)
            {
                Image img=new Image("cardpic/A15.png");
                x.setImage(img);
       
            }
            if(a==16)
            {
                Image img=new Image("cardpic/A16.png");
                x.setImage(img);
       
            }
            if(a==17)
            {
                Image img=new Image("cardpic/A17.png");
                x.setImage(img);
       
            }
            if(a==18)
            {
                Image img=new Image("cardpic/A18.png");
                x.setImage(img);
       
            }
            if(a==19)
            {
                Image img=new Image("cardpic/A19.png");
                x.setImage(img);
       
            }
            if(a==20)
            {
                Image img=new Image("cardpic/A20.png");
                x.setImage(img);
       
            }
            if(a==21)
            {
                Image img=new Image("cardpic/A21.png");
                x.setImage(img);
       
            }
            if(a==22)
            {
                Image img=new Image("cardpic/A22.png");
                x.setImage(img);
       
            }
            if(a==23)
            {
                Image img=new Image("cardpic/A23.png");
                x.setImage(img);
       
            }
            if(a==24)
            {
                Image img=new Image("cardpic/A24.png");
                x.setImage(img);
       
            }
            if(a==25)
            {
                Image img=new Image("cardpic/A25.png");
                x.setImage(img);
       
            }
            if(a==26)
            {
                Image img=new Image("cardpic/A26.png");
                x.setImage(img);
       
            }
            if(a==27)
            {
                Image img=new Image("cardpic/A27.png");
                x.setImage(img);
       
            }
            if(a==28)
            {
                Image img=new Image("cardpic/A28.png");
                x.setImage(img);
       
            }
            if(a==29)
            {
                Image img=new Image("cardpic/A29.png");
                x.setImage(img);
       
            }
            if(a==30)
            {
                Image img=new Image("cardpic/A30.png");
                x.setImage(img);
       
            }
            if(a==31)
            {
                Image img=new Image("cardpic/A31.png");
                x.setImage(img);
       
            }
            if(a==32)
            {
                Image img=new Image("cardpic/A32.png");
                x.setImage(img);
       
            }
    }
    
    //getting choice from choice box

    public String getChoice(ChoiceBox<String> choiceBox){
        String food = choiceBox.getValue();
        return food;
    }

    private void addAll(String clubs, String diamonds, String spades, String hearts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
