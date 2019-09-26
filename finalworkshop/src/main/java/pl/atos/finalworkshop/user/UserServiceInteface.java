package pl.atos.finalworkshop.user;

public interface UserServiceInteface {

    User findByUserName(String name);

    void saveUser(User user);

    User findByEmail(String email);

    void createVerificationToken(String token, User user);

    VerificationToken getVerificationToken(String token);
}
