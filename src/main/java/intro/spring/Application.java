package intro.spring;

import intro.spring.config.AppConfig;
import intro.spring.model.User;
import intro.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        User roma = new User("Roma", "123", 27);
        User mila = new User("Mila", "321",26);
        userService.add(roma);
        userService.add(mila);
        userService.listUsers().forEach(System.out::println);
    }
}
