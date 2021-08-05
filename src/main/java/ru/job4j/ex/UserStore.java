package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
       for (int i = 0; i < users.length; i++) {
           if (users[i].getUsername().equals(login)) {
               return users[i];
           }
       }
       throw new UserNotFoundException("Пользователь не найден");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.isValid() && user.getUsername().length() >= 3) {
            return true;
        } else {
            throw new UserInvalidException("Пользователь не валидный");
        }
    }

    public static void main(String[] args) throws UserInvalidException {
        User[] users = {
                new User("sds", true)
        };
        try {
            User user = findUser(users, "sds");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        }  catch (UserInvalidException ei) {
            ei.printStackTrace();
        }
        catch (UserNotFoundException en) {
            en.printStackTrace();
        }
    }
}
