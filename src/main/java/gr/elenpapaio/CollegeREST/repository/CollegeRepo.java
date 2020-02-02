package gr.elenpapaio.CollegeREST.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import gr.elenpapaio.CollegeREST.model.College;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

@Data
@NoArgsConstructor

public class CollegeRepo {
    private College college;

    public CollegeRepo(String filename) {
        ObjectMapper mapper = new ObjectMapper();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        mapper.setDateFormat(df);

        try {
            college = mapper.readValue(new File(filename), College.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
