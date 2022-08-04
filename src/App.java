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
        "c plus plus", 
        "css", 
        "html",
        "python", 
        "javascript", 
        "c sharp",
        "carbon",
        "c",
        "mysql"};
        Random r = new Random();
        int random_index=r.nextInt(names.length);
        String random_name=names[random_index];
        
        return random_name;
    }

    public boolean check_answer(String guess, String answer){
        guess=guess.strip();
        answer=answer.strip();        
        if (guess.toLowerCase().equals(answer.toLowerCase())){
            return true;
        }
        else {
            return false;
        }
    }

    public void welcome(){
        
        boolean reply=true;
     
        System.out.println("Hello Welcome to the coding language guessing game\nWould you like to see the rules?");
        while (reply){
            String answer=scan.nextLine();
            answer.strip();
            if (answer.equals("yes")){
                System.out.println("--------------------------");
                System.out.println("---------- RULES ---------");
                System.out.println("A blank language will be displayed.\nYou must guess the correct name within 10 tries.\n3 hints will be given after the first 3 guesses");
                System.out.println("--------------------------");
                reply=false;
            }
            else if (answer.equals("no")){
                
                System.out.println("--------------------------");
                System.out.println("----- BEGINNINER GAME ----");
                System.out.println("--------------------------");
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
        System.out.println("Would you like to play again.\nyes/no:");
        String answer=scan.nextLine();
        if (answer.equals("yes")){
            System.out.println("--------------------------");
            System.out.println("----- RESETTING GAME -----");
            System.out.println("--------------------------");
            return true;
        }
        else if (answer.equals("no")){
            System.out.println("Thank you for playing.");
            System.out.println("--------------------------");
            System.out.println("------- GAME OVER --------");
            System.out.println("--------------------------");
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
            
            String guess_name;
            int guesses=10;
            while (round){
                System.out.println(blank);
                System.out.println("Guess the name: ");
                guess_name=scan.nextLine();
                System.out.println("Your guess was "+guess_name.toUpperCase());
                guesses--;
                boolean result=game.check_answer(guess_name, random_name);
                if (result & guesses>0){
                    System.out.println("--------------------------");
                    System.out.println("--------- WINNER ---------");
                    System.out.println("--------------------------");
                    round=false;
                    play=game.play_again();
                    
                }
                else if (guesses == 0 & !(result)){
                    System.out.println("Ran out of guesses");
                    System.out.println("--------------------------");
                    System.out.println("------- ROUND OVER -------");
                    System.out.println("--------------------------");
                    play=game.play_again();
                    round=false;
                }
                else{

                    System.out.println("Good guess but not correct. Try again");
                    System.out.println("--------------------------");
                    System.out.println("----------- HINTS --------");
                    System.out.println("--------------------------");
                    if (guesses < 10){
                        System.out.println("HINT 1: The length of the name is " + random_name.length());
                    }
                    if (guesses < 9){
                        System.out.println("HINT 2: The first character of the name is " + random_name.charAt(0));
                    }
                    if (guesses < 8){
                        System.out.println("HINT 3: The last character of the name is " + random_name.charAt(random_name.length() - 1));
                    }
                    System.out.println("Guesses Left: " + guesses);
                }

            }
            
        }
        scan.close();
        }
}
