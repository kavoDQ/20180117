package forfun.good.a20180117;

import android.widget.EditText;

import org.junit.Test;

import forfun.good.a20180117.data.Student;
import forfun.good.a20180117.data.StudentscoreDAO;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void day1() throws Exception{
        Mytest1 M = new Mytest1();
        assertEquals(10,M.getAdd(1,9));
    }
    @Test
    public void tt1() throws Exception{
       StudentscoreDAO dao = new StudentscoreDAO();
       dao.add(new Student(1,"john",100));
       dao.add(new Student(2,"han",70));
       assertEquals(2,dao.getList().size());
    }
    @Test
    public void tt2() throws Exception{
        StudentscoreDAO dao = new StudentscoreDAO();
        dao.add(new Student(1,"john",100));
        dao.add(new Student(2,"han",60));
        assertEquals(100,dao.getList().get(0).score);
    }
    @Test
    public void tt3() throws Exception{
        StudentscoreDAO dao = new StudentscoreDAO();
        dao.add(new Student(1,"ben",70));
        dao.add(new Student(2,"sam",40));
        assertEquals(70,dao.getStudent(1).score);
    }
    @Test
    public void tt4delete() throws Exception {

        StudentscoreDAO dao = new StudentscoreDAO();
        dao.add(new Student(1, "ben", 70));
        dao.add(new Student(2, "sam", 40));
        dao.delete(2);
        assertEquals(1, dao.getList().size());

    }
    @Test
    public void tt5update() throws Exception{
        StudentscoreDAO dao = new StudentscoreDAO();
        dao.add(new Student(1, "ben", 70));
        dao.add(new Student(2, "sam", 40));
        dao.update(new Student(1,"Dada",40));
        assertEquals("Dada", dao.getStudent(1).name);


    }
    @Test
    public void tt6sum() throws Exception{
        StudentscoreDAO dao = new StudentscoreDAO();
        dao.add(new Student(1, "ben", 70));
        dao.add(new Student(2, "sam", 40));
        //assertEquals("sum",dao.getsum(110));
    }

}