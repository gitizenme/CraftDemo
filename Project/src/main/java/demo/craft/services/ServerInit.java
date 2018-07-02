package demo.craft.services;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import demo.craft.models.Message;
import demo.craft.models.MessageRepository;
import demo.craft.models.User;
import demo.craft.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;

@Component
public class ServerInit {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MessageRepository messageRepository;


    @PostConstruct
    public void init() {
        List<User> users = userRepository.findAll();

        Lorem lorem = LoremIpsum.getInstance();
        Random r = new Random();

        for(int i = 1; i < 2000; i++) {
            String words = lorem.getWords(20);
            words = words.substring(0, Math.min(words.length(), 240));
            int userIdx = r.nextInt(users.size());

            messageRepository.save(new Message(words, users.get(userIdx), true));

        }
    }
}
