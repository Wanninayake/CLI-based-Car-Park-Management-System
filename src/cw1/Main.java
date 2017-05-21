package cw1;

import java.util.Scanner;

public class Main {
    
    
    public static void main(String[] args) throws NullPointerException{
        
      WestminsterCarParkManager wmin = new WestminsterCarParkManager();
     
      Scanner sc  = new Scanner(System.in);

      System.out.println(" *****************************");
      System.out.println("* Westminster Car Park System *");
      System.out.println(" *****************************");
      System.out.println(" ");
      System.out.println("  ██████╗█████╗██████╗     ██████╗ █████╗██████╗██╗  ██╗    █████████╗   ███████████████████████████╗   ███╗");
      System.out.println(" ██╔════██╔══████╔══██╗    ██╔══████╔══████╔══████║ ██╔╝    ██╔════╚██╗ ██╔██╔════╚══██╔══██╔════████╗ ████║");
      System.out.println(" ██║    █████████████╔╝    ██████╔█████████████╔█████╔╝     ███████╗╚████╔╝███████╗  ██║  █████╗ ██╔████╔██║");
      System.out.println(" ██║    ██╔══████╔══██╗    ██╔═══╝██╔══████╔══████╔═██╗     ╚════██║ ╚██╔╝ ╚════██║  ██║  ██╔══╝ ██║╚██╔╝██║");
      System.out.println(" ╚████████║  ████║  ██║    ██║    ██║  ████║  ████║  ██╗    ███████║  ██║  ███████║  ██║  █████████║ ╚═╝ ██║");
      System.out.println("  ╚═════╚═╝  ╚═╚═╝  ╚═╝    ╚═╝    ╚═╝  ╚═╚═╝  ╚═╚═╝  ╚═╝    ╚══════╝  ╚═╝  ╚══════╝  ╚═╝  ╚══════╚═╝     ╚═╝");
                                                                                                                 

      System.out.println(" ");
  
      //selecting whether the user wants to continue or exit
      System.out.println("Press Y to continue or N to exit.");
      String accept = sc.next();
      System.out.println(" ");
      
      if(accept.equalsIgnoreCase("Y")){         
        wmin.menu();
      }
      
      else if (accept.equalsIgnoreCase("N")){
       System.out.println(" ");
       System.err.println("Program Terminated. Thank you");
       System.exit(0);
      }
      
      else{
    	//printout an error if user enters selection other than Y/N and go back to main again
       System.out.println("");
       System.err.println("Invalid Response.");
       System.out.println("");
       Main.main(args);
      }
        
    }
    
}
