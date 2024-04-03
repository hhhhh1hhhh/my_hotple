package restaurant.restaurant.myplace.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.restaurant.myplace.entity.MyplaceFileEntity;

public interface MyplaceFileRepository extends JpaRepository<MyplaceFileEntity, Integer>{

    void deleteByStoredFileNameAndOriginalFileName(String storedFileName, String originalFileName);

}

