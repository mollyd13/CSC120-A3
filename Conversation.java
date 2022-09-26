//imports all required components from java
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

//runs a conversation between user and computer
class Conversation {
  //creates scanner to take user input and array to store transcript
  static Scanner input = new Scanner(System.in);
  static ArrayList<String> transcript = new ArrayList<String>();
  public static void main(String[] arguments) {
    //gets how many rounds the user would like and starts a convo with the proper amount of rounds
    System.out.print("How many rounds of conversation would you like? ");
    int numRounds = input.nextInt();
    input.nextLine();
    System.out.println("You have chosen " + numRounds + " rounds of conversation.");
    startConversation(numRounds);
    }

    public static void startConversation(int numRounds){
      //computer asks initial question
      System.out.println("Hi, what's on ur mind?");
      transcript.add("Hi, what's on ur mind?");
      
      //loops through convo for chosen amount of rounds
      for (int i = 1; i<=numRounds; i++){      
        String userResp = input.nextLine();
        transcript.add(userResp);
        
        //says hi to the user if they input a greeting
        if(userResp.equals("hi") || userResp.contains("hello") || userResp.contains("what's up") || userResp.contains("hey")){
          System.out.println("hi!");
          transcript.add("hi!");
        }
        
        //if the user asks a question the computer responds that it doesn't know
        else if (userResp.contains("?")){
          System.out.println("i'm not sure about that sorry");
          transcript.add("i'm not sure about that sorry");
        }

        //mirrors the users words and puts them in question form
        else if(userResp.contains("i ") || userResp.contains("am ") || userResp.contains("your ")){
          String newResp = userResp.replace("i ", "you ");
          newResp = newResp.replace("am ", "are ");
          newResp = newResp.replace("your ", "my ");
          System.out.println(newResp + "?");
          transcript.add(newResp + "?");
        }

        //mirrors the users words and puts them in question form
        else if(userResp.contains("you ") || userResp.contains("are ") || userResp.contains("my") || userResp.contains("me ")){
          String newResp = userResp.replace("you ", "i ");
          newResp = newResp.replace("me ", "you ");
          newResp = newResp.replace("are ", "am ");
          newResp = newResp.replace("my ", "your ");
          System.out.println(newResp + "?");
          transcript.add(newResp + "?");
        }

        //if no mirror words are found, a canned response will be outputted
        else{
          System.out.println(createResponse());
        }

        //once the convo is over, say goodbye and print the transcript
        if (i == numRounds){
          System.out.println("Thanks for chatting, see ya!");
          transcript.add("Thanks for chatting, see ya!");
          System.out.println("Transcript: ");
          printTranscript(numRounds);
          input.close();
            break;
          }
        }
    }

    //randomly chooses a canned response from an array
    public static String createResponse(){
      String[] basicResponses;
      basicResponses = new String[9];
      basicResponses[0] = "Wow interesting!";
      basicResponses[1] = "That's crazy I was just thinking that!";
      basicResponses[2] = "Awesome!";
      basicResponses[3] = "Cool.";
      basicResponses[4] = "Interesting, I've never heard that before.";
      basicResponses[5] = "Are you sure?";
      basicResponses[6] = "I know right";
      basicResponses[7] = "lmao";
      basicResponses[8] = "seriously?";

      Random generator = new Random();
      int randomIndex = generator.nextInt(basicResponses.length);
      String computerResponse = basicResponses[randomIndex];
      transcript.add(computerResponse);
      return computerResponse;  
    }

    //loops through and prints each line of the transcript
    public static void printTranscript(int numRounds){
      for (String i : transcript){
          System.out.println(i);
      }
    }

  }

