import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логин");
        String login = scanner.nextLine();
        try {
            checkLogin(login);
        }catch (wrongLoginException e){
            throw new RuntimeException();
        }
        System.out.println("Введите пароль");
        String password = scanner.nextLine();
        System.out.println("ВВедите пароль еще раз");
        String confirmPassword = scanner.nextLine();
        try {
            checkPassword(password, confirmPassword);
        }catch (wrongPasswordException e){
            throw new RuntimeException();
        }
    }

    public static void checkLogin(String login) throws wrongLoginException{
        if (!login.matches("^[a-zA-Z0-9_]{1,20}$")) {
                throw new wrongLoginException(login);
        }

    }
    public static void checkPassword(String password, String confirmPassword) throws wrongPasswordException{
        if (!password.matches("^[a-zA-Z0-9_]{1,20}$")) {
            if (!password.equals(confirmPassword)) {
                throw new wrongPasswordException(password);
            }
        }

        }
    private static class wrongLoginException extends Throwable{
        public wrongLoginException(String login) {
            System.out.println();
        }
    }
    private static class wrongPasswordException extends Throwable{
        public wrongPasswordException(String password) {
            System.out.println();
        }
    }
}