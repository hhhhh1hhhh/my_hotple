package restaurant.restaurant.myplace.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurant.restaurant.myplace.repository.MyplaceFileRepository;

import java.io.File;

@Service
@RequiredArgsConstructor
public class MyplaceFileService {

    private final MyplaceFileRepository myplaceFileRepository;


    @Transactional
    public void deleteFile(String storedFileName, String originalFileName) {

        // 로컬에서 삭제
         File fileToDelete = new File("c:/springboot_img/" + storedFileName);
         if (fileToDelete.exists()) {
             fileToDelete.delete();
             System.out.println("로컬에서 삭제되었습니다.");
         }

        // 데이터베이스에서 삭제
        myplaceFileRepository.deleteByStoredFileNameAndOriginalFileName(storedFileName, originalFileName);
        System.out.println("데이터베이스에서 삭제되었습니다.");

    }
}
