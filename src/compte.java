import java.util.Random;

public class compte {


    public String generermdp(){

        String ret = "";
        Random random = new Random();

        String setOfCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        for(int i = 0; i < 6; i++){
            int randomInt = random.nextInt(setOfCharacters.length());
            ret = ret + setOfCharacters.charAt(randomInt);

        }


        return ret;
    }
    
}
