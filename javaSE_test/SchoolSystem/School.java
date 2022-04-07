package SchoolSystem;

/**
 * @author Komorebi
 * @since 2021.10.28.20:13
 */
public class School implements Introduce{
    private BWPrinter BWprinter = new BWPrinter();
    private ColourPrinter Colourprinter = new ColourPrinter();

    public void BWprint(Introduce introduce){
        BWprinter.print(introduce.detail());
    }
    public void colourPrint(Introduce introduce){
        Colourprinter.print(introduce.detail());
    }

    @Override
    public String detail(){
        return "There is a school.";
    }

    public static void main(String[] args){
        School school = new School();
        Teacher teacher = new Teacher();
        Student student = new Student();
        school.BWprint(school);
        school.colourPrint(school);
        school.BWprint(teacher);
        school.colourPrint(teacher);
        school.BWprint(student);
        school.BWprint(student);
    }

}
