package restaurant.restaurant.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "like_table")
public class LikesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "myplaceId", referencedColumnName = "id")
    private MyplaceEntity myplace;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private UserEntity user;

    public void setMyplaceId(int myplaceId) {
        this.myplace = new MyplaceEntity();
        this.myplace.setId(myplaceId);
    }

    public void setUserId(int userId) {
        this.user = new UserEntity();
        this.user.setId(userId);
    }

}
