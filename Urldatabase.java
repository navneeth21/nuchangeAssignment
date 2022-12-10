import java.util.*;
import java.io.*;
import org.json.simple.JSONObject;



public class Urldatabase{
    static int no=0;


    String urls;
    Integer count;
    UUID key;

    Urldatabase(String link){
        urls=link;
        key = UUID.randomUUID();
        count =0;
    }

    public static void JSonify(ArrayList<Urldatabase> x2,ArrayList<JSONObject> jj){
        
        for(int i=0; i<x2.size();i++){
            Urldatabase entry = x2.get(i);
            JSONObject newjs = jj.get(i);
            System.out.println("The link is "+ entry.urls + " usage count is "+ entry.count + " unique key is "+ entry.key);
            newjs.put("id", entry.key);
            newjs.put("website url", entry.urls);
            newjs.put("usage count", entry.count);
            jj.set(i,newjs);
    
        }   
    }

    public static void display(ArrayList<Urldatabase> x2){
        
        for(int i=0; i<x2.size();i++){
            Urldatabase entry = x2.get(i);
           // JSONObject newjs = jj.get(i);
            System.out.println("The link is "+ entry.urls + " usage count is "+ entry.count + " unique key is "+ entry.key);
            
            /*newjs.put("id", entry.key);
            newjs.put("website url", entry.urls);
            newjs.put("usage count", entry.count);
            jj.set(i,newjs);
            */
        }   
    }
  
    public String inputUrl(){
        System.out.println("InputUrl working!\n Enter the link to be stored:");
        Scanner in = new Scanner(System.in);
        String Url = in.nextLine();
        return Url;
        
    }

    
    public Urldatabase searchobj(String link,ArrayList<Urldatabase> x1){
        System.out.println("GetUrl in progress for link "+ link);
        int flag=0;
        //int position=0;
        Urldatabase found=null;
        for(int i=0; i<x1.size(); i++){
            Urldatabase e = x1.get(i);
            System.out.println(e.key+ " "+ e.urls+ " "+ e.count);
            String check =e.urls;
            
            if(check.equals(link)){
                //System.out.println(e.count+ " is the latest usage count of  "+ e.urls +"\n");
                found =e;
                //lastcount=e.count;
               // e.count+=1;
               // x1.set(i,e);
                flag=1;
                no=i;
            }
            
        }
        
        if(flag==0){
         
            System.out.println("the url is not found in the database");

        } 
        return found;
    }

  
    public void Menu(ArrayList<Urldatabase> x1,ArrayList<JSONObject> obji){
       

        Scanner in= new Scanner(System.in);
        int choice=0;

        char x='n';
        do{
            System.out.println("Welcome to Url counter\n Options\n 1. Storeurl\n 2. Geturl\n 3. Counturl\n 4. listUrls\n 5. Exit\n Enter your input:");
            choice=in.nextInt();
                
            if(choice>=1 && choice<=5){

                switch(choice){
                case 1: 
                    System.out.println("storeurl mode activated");
                
                // x1.add(new Urldatabase(inputUrl()));     
                    x1.add(new Urldatabase("google.com")); 
                    x1.add(new Urldatabase("instagram.com"));
                    x1.add(new Urldatabase("fb.com"));
                    x1.add(new Urldatabase("naptser.com")); 

                    
                    break;
                case 2: 
                    System.out.println("geturl mode activated");
                    Urldatabase Obj = searchobj(inputUrl(),x1);
                    System.out.println("\n\nthe unique key is "+Obj.key);
                    Obj.count+=1;
                    x1.set(no,Obj);
                    
                    break;
                case 3: 
                    System.out.println("count mode activated");
                    Urldatabase Obj1 = searchobj(inputUrl(),x1);
                    System.out.println("\n\nthe latest usage count is "+Obj1.count);
                    break;
                case 4: 
                    System.out.println("list mode activated\n");
                    display(x1);
                   //JSonify(x1, obji);
                   //System.out.println(obji);
                    break;
                case 5 :
                    System.out.println("Exiting");
                    System.exit(0);

                    
                }
            }

            System.out.println("Do you wish to enter more (y/n)?");
            x = in.next().charAt(0);
            
            
        }while(x=='y');
        
    } 
     




public static void main(String[] args) throws Exception {
    ArrayList<Urldatabase> U = new ArrayList<Urldatabase>();
    ArrayList<JSONObject> JS = new ArrayList<JSONObject>();
 
    Urldatabase ref = new Urldatabase(null);


    ref.Menu(U,JS);
    System.out.println(U);
    System.out.println(U.get(0).urls);
    for(int i=0; i<U.size(); i++){
        Urldatabase data = U.get(i);
        System.out.println(data + "\t"+data.urls+"\t"+ data.key +"\t"+data.count);
    }
    

    }
}

