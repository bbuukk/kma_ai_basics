import java.util.Scanner;

public class ChatBotTUIApp {

    public static void main(String[] args) {
        System.out.println("Ласкаво просимо до Фоті");
        String question;
        boolean askAQuestion = true;
        Scanner keyboard = new Scanner(System.in);
        Bot bot = new Bot();
        do {
            System.out
                    .println("Скажи щось Фоті (введи До побачення щоб вийти): ");
            question = keyboard.nextLine();
            if (question.equalsIgnoreCase("до побачення")
                    || question.equalsIgnoreCase("допобачення")
                    || question.equalsIgnoreCase("бувай")
                    || question.equalsIgnoreCase("пока")){
                askAQuestion = false;
            } else
            System.out.println("Фотя каже: \"" + bot.ask(question) + "\"");
        } while (askAQuestion);
        keyboard.close();
        System.out.println("Фотя каже: \"До побачення!\"");
    }
}
