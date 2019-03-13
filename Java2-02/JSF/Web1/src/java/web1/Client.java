package web1;
import java.io.Serializable;
import javax.faces.bean.*; 

@ManagedBean(name = "client", eager = true) 
@SessionScoped 
public class Client implements Serializable {
   String fname="Alex";
   int    year =2015;
   public String getFname() {return fname;}
   public void   setFname(String s) { fname=s; }

   public int  getYear() {return year;}
   public void setYear(int y) { year=y; }

   public String saveDB() { 
       if (year<2001) return "old?faces-redirect=true";
       else return "new?faces-redirect=true";
   }
}
