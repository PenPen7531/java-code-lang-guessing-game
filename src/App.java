import java.util.Random;
import java.util.Scanner;


public class App {
    static final Scanner scan= new Scanner(System.in);
    public String convertBlank(String word){
        String new_Word="";
        char[] chars=word.toCharArray();
        for (char ch: chars){
            String character=String.valueOf(ch);
            if (character != " "){
                new_Word += "_";
            }
            else{
                new_Word += " ";
            }
            }
        return new_Word;
    };

    public String getRandomName(){
        String[] names={ 
        "jeff", 
        "wendy", 
        "jack",
        "leah", 
        "thomas", 
        "cindy", 
        "chelsey", 
        "carlos", 
        "abby", 
        "christopher", 
        "xavier", 
        "becky", 
        "diego", 
        "gabriel", 
        "harry", 
        "indigo", 
        "kelly", 
        "sally", 
        "trisha", 
        "victoria"};
        Random r = new Random();
        int random_index=r.nextInt(names.length);
        String random_name=names[random_index];
        
        return random_name;
    }

    public boolean check_answer(String guess, String answer){
        guess=guess.strip();
        answer=answer.strip();        
        if (guess.equals(answer)){
            return true;
        }
        else {
            return false;
        }
    }

    public void welcome(){
        
        boolean reply=true;
     
        System.out.println("Hello Welcome to the name guessing game\nWould you like to see the rules?");
        while (reply){
            String answer=scan.nextLine();
            answer.strip();
            if (answer.equals("yes")){
                System.out.println("A blank hidden name will be given, you must guess the correct name within 10 tries.");
                reply=false;
            }
            else if (answer.equals("no")){
                System.out.println("Lets begin the game!");
                reply=false;
            }
            else{
                System.out.println("Sorry I did not understand that. Would you like to see the rules?");
            }
        }

        
    }

    public boolean play_again(){
        boolean play_a=true;
        while (play_a){
            System.out.println("Would you like to play agian");
        String answer=scan.nextLine();
        if (answer.equals("yes")){
            System.out.println("Resetting Game");
            return true;
        }
        else if (answer.equals("no")){
            System.out.println("Thank you for playing. GAME OVER");
            return false;
        }
        else{
            System.out.println("Sorry. I didn't understand that. Please try again.");
        }
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        App game=new App();
        game.welcome();
        Scanner scan=new Scanner(System.in);
        boolean play=true;
        
        


        while (play){
            boolean round=true;
            String random_name=game.getRandomName();
            System.out.println(random_name);
            String blank=game.convertBlank(random_name);
            System.out.println(blank);
            String guess_name;
            while (round){
                
                System.out.println("Guess the name: ");
                guess_name=scan.nextLine();
                System.out.println("Your guess was "+guess_name);
                boolean result=game.check_answer(guess_name, random_name);
                if (result){
                    System.out.println("Winner");
                    round=false;
                    play=game.play_again();
                }
                else{
                    System.out.println("Good guess but not correct. Try again");
                }

            }
            
        }
        scan.close();
        }
}
