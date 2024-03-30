package restaurant.restaurant.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import restaurant.restaurant.repository.MyplaceFileRepository;

import java.io.File;

@Service
@RequiredArgsConstructor
public class MyplaceFileService {

//    private final MyplaceFileRepository myplaceFileRepository;

    public void deleteFile(String storedFileName, String originalFileName) {
        System.out.println("storedFileName: " + storedFileName);
        System.out.println("originalFileName: " + originalFileName);

         File fileToDelete = new File("c:/springboot_img/" + storedFileName);
         if (fileToDelete.exists()) {
             fileToDelete.delete();
             System.out.println("로컬에서 삭제되었습니다.");
         }

//         // 데이터베이스에서 파일 정보 삭제
//         myplaceFileRepository.deleteByOriginalFileName(originalFileName);
//        System.out.println(originalFileName + "을 데이터베이스에서 삭제했습니다.");
    }
}
