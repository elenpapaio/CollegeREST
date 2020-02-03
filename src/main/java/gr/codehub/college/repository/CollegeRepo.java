package gr.codehub.college.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import gr.codehub.college.model.College;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * retrieve data for College
 * college.json in main/resources is used instead of a database
 */
@Data
@NoArgsConstructor
public class CollegeRepo {
    private College college;

    public CollegeRepo(String filename) {
        ObjectMapper mapper = new ObjectMapper();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        mapper.setDateFormat(df);

        try {
            college = mapper.readValue(ResourceUtils.getFile(filename), College.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
