
public class stringMethods {
    public static void main(String args[]){
        // String = a reference data type that can store one or more characters
        //   reference data types have access to useful methods
  
        String name = "Bro";
  
        boolean result = name.equalsIgnoreCase("bro");
        //int result = name.length();
        //char result = name.charAt(0); //B
        //int result = name.indexOf("o"); //2
        //boolean result = name.isEmpty();
        //String result = name.toUpperCase();
        //String result = name.toLowerCase();
        //String result = name.trim(); //Ignora espaços
        //String result = name.replace('o', 'a');
   
        System.out.println(result);
    }
}
