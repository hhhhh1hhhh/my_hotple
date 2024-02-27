package restaurant.restaurant.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import restaurant.restaurant.entity.UserEntity;

import java.util.Date;

@Getter
@Service
public class PlaceDTO {

    private String category;
    private String placeName;
    private String address;
    private String memo;
    private String photo;
    private boolean share;
    private int likes;
    private int views;
}

