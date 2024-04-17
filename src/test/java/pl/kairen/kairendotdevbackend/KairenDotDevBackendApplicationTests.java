package pl.kairen.kairendotdevbackend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.multipart.MultipartFile;
import pl.kairen.kairendotdevbackend.Gallery.GalleryDTO;
import pl.kairen.kairendotdevbackend.Gallery.GalleryService;
import pl.kairen.kairendotdevbackend.Image.ImageService;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class KairenDotDevBackendApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private GalleryService galleryService;

	@MockBean
	private ImageService imageService;

//	@Test
//	public void shouldReturnGallery() throws Exception {
//
//		MockMultipartFile image1 = new MockMultipartFile("image","image.jpg","image/jpeg", "testdata".getBytes());
//		MockMultipartFile image2 = new MockMultipartFile("img2","image2.jpg","image/jpeg", "tedsadsadsastdata".getBytes());
//		MockMultipartFile image3 = new MockMultipartFile("img3","image3.jpg","image/jpeg", "testdatadasdasd".getBytes());
//
//		when(galleryService.createNewGallery(new GalleryDTO(new ArrayList<>(file1))))
//	}





}
