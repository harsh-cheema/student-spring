
import com.example.student.model.Student;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Student")
public class StudentController{
    Map<String,Student> idToStu=new HashMap<>();
    Map<String,List<Student>> uniToStu=new HashMap<>();
    int id_g=0;

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody String name,
    @RequestBody int age,@RequestBody String adhaar,
    @RequestBody String University){
        id_g++;
        String id=String.valueOf(id_g);
        Student student=new Student(id,name,age,adhaar,University);

        idToStu.put(id,student);
        List<Student> st=uniToStu.getOrDefault(University,new ArrayList<>());
        st.add(student);
        uniToStu.put(University,st);
        return id;
    }


    @GetMapping("/getStudentsByUniversity/{University}")
    public List<Student> getStudentsByUniversity(@PathVariable String University){
        return uniToStu.getOrDefault(University,null);
    }

    @GetMapping("/getStudentById/{id}")
    public Student getStudentById(@PathVariable String id){
        return idToStu.getOrDefault(id,null);
    }


}
