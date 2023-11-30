package utility;

import entity.User;
import lombok.Getter;
public class SecurityContext {

    private SecurityContext() {
    }
    @Getter
    private static User currentUser;
    public static void fillContext(User baseUser) {
        currentUser = baseUser;
    }
    public static Integer getCurrentUserId() {
        return currentUser.getId();
    }
}
