import exception.WrongLoginException;
import exception.WrongPasswordException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void authorization(String login, String password, String confirmPassword) {
        if (login.length() > 20 || Pattern.matches("(.*)[^\\da-zA-Z_](.*)", login)) {
            throw new WrongLoginException();
        }
        if (!password.equals(confirmPassword) || Pattern.matches("(.*)[^\\da-zA-Z_](.*)", password)) {
            throw new WrongPasswordException();
        }

    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        try {
            authorization("snf123125", "asdasd", "asdasd");
        } catch (WrongLoginException с) {
            System.out.println("Непровильно введен логин");
        } catch (WrongPasswordException с) {
            System.out.println("Неправильно введен пароль, либо повторный ввод пароля не соответствует первому");
        } finally {
            System.out.println("Метод authorization завершил свою работу");
        }
    }
}