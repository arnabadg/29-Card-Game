package project;

import java.util.Arrays;
import java.util.Random;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Project extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
    static Random rndNumbers = new Random();
    
        static String trump;
        static int bid=0;
        static String bidder="";
        static int ourpoint=0;
        static int theirpoint=0;
        static int ourscore=0;
        static int theirscore=0;
        
        static int array[]=new int[33];
        static int x;
        static int play1[]=new int[9];
        static int play2[]=new int[9];
        static int play3[]=new int[9];
        static int play4[]=new int[9];    

//draw card first time
    public static void drawcard1() {
        
        for(int i=0;i<33;i++)
        {
            array[i]=0;
        }
        for(int i=1;i<=4;i++)
        {
            x=rndNumbers.nextInt();
            if(x<0){x=-x;}
            x=x%32+1;
            if(array[x]==0)
            {
                play1[i]=x;
                array[x]=1;
            
            }
            else
            {
                while(true)
                {
                    x++;
                    if(x>32){x-=32;}
                    if(array[x]==0)
                    {
                       play1[i]=x;
                       array[x]=1;
                       break;
                    }
                }
            }
        }
        
        for(int i=1;i<=4;i++)
        {
            
            x=rndNumbers.nextInt();
            if(x<0){x=-x;}
            x=x%32+1;
            
            if(array[x]==0)
            {
                play2[i]=x;
                array[x]=1;
            
            }
            else
            {
                while(true)
                {
                    x++;
                    if(x>32){x-=32;}
                    if(array[x]==0)
                    {
                       play2[i]=x;
                       array[x]=1;
                       break;
                    }
                }
            }
        }
        
        for(int i=1;i<=4;i++)
        {
            x=rndNumbers.nextInt();
            if(x<0){x=-x;}
            x=x%32+1;
            if(array[x]==0)
            {
                play3[i]=x;
                array[x]=1;
            
            }
            else
            {
                while(true)
                {
                    x++;
                    if(x>32){x-=32;}
                    if(array[x]==0)
                    {
                       play3[i]=x;
                       array[x]=1;
                       break;
                    }
                }
            }
        }
        
        for(int i=1;i<=4;i++)
        {
            x=rndNumbers.nextInt();
            if(x<0){x=-x;}
            x=x%32+1;
            if(array[x]==0)
            {
                play4[i]=x;
                array[x]=1;
            
            }
            else
            {
                while(true)
                {
                    x++;
                    if(x>32){x-=32;}
                    if(array[x]==0)
                    {
                       play4[i]=x;
                       array[x]=1;
                       break;
                    }
                }
            }
        }
        
        Arrays.sort(play1,1,5);
        Arrays.sort(play2,1,5);
        Arrays.sort(play3,1,5);
        Arrays.sort(play4,1,5);
        
    }
    
    public static void drawcard2() {
       
        for(int i=5;i<=8;i++)
        {
            x=rndNumbers.nextInt();
            if(x<0){x=-x;}
            x=x%32+1;
            if(array[x]==0)
            {
                play1[i]=x;
                array[x]=1;
            
            }
            else
            {
                while(true)
                {
                    x++;
                    if(x>32){x-=32;}
                    if(array[x]==0)
                    {
                       play1[i]=x;
                       array[x]=1;
                       break;
                    }
                }
            }
        }
        
        for(int i=5;i<=8;i++)
        {
            x=rndNumbers.nextInt();
            if(x<0){x=-x;}
            x=x%32+1;
            if(array[x]==0)
            {
                play2[i]=x;
                array[x]=1;
            
            }
            else
            {
                while(true)
                {
                    x++;
                    if(x>32){x-=32;}
                    if(array[x]==0)
                    {
                       play2[i]=x;
                       array[x]=1;
                       break;
                    }
                }
            }
        }
        
        for(int i=5;i<=8;i++)
        {
            x=rndNumbers.nextInt();
            if(x<0){x=-x;}
            x=x%32+1;
            if(array[x]==0)
            {
                play3[i]=x;
                array[x]=1;
            
            }
            else
            {
                while(true)
                {
                    x++;
                    if(x>32){x-=32;}
                    if(array[x]==0)
                    {
                       play3[i]=x;
                       array[x]=1;
                       break;
                    }
                }
            }
        }
        
        for(int i=5;i<=8;i++)
        {
            x=rndNumbers.nextInt();
            if(x<0){x=-x;}
            x=x%32+1;
            if(array[x]==0)
            {
                play4[i]=x;
                array[x]=1;
            
            }
            else
            {
                while(true)
                {
                    x++;
                    if(x>32){x-=32;}
                    if(array[x]==0)
                    {
                       play4[i]=x;
                       array[x]=1;
                       break;
                    }
                }
            }
        }
        
        Arrays.sort(play1,1,9);
        Arrays.sort(play2,1,9);
        Arrays.sort(play3,1,9);
        Arrays.sort(play4,1,9);
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
}











