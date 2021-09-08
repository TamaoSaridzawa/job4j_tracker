package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User variable: users) {
            if (variable.getUsername().equals(login)) {
                return variable;
            }
        }

       throw new UserNotFoundException("Пользователь не найден");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.isValid() && user.getUsername().length() >= 3) {
            return true;
        }
        throw new UserInvalidException("Пользователь не валидный");
    }

    public static void main(String[] args) throws UserInvalidException {
        User[] users = {
                new User("sd", true)
        };
        try {
            User user = findUser(users, "sd");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        }  catch (UserInvalidException ei) {
            ei.printStackTrace();
        }  catch (UserNotFoundException en) {
            en.printStackTrace();
        }
    }
}
