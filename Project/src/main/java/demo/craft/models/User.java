package demo.craft.models;

import javax.persistence.*;
import java.text.MessageFormat;

@Entity
@Table(name = "users")
public class User extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "userid", nullable = false)
    private String userId;

    @Column(name = "username", nullable = false)
    private String userName;

    protected User() {}

    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return MessageFormat.format("User'{'id={0}, userId=''{1}'', userName=''{2}'''}'", id, userId, userName);
    }
}
