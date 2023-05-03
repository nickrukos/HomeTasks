package hw15.task4;

import java.util.function.*;

public interface ValidateFile
{
    boolean rule();
    default ValidateFile andRule(ValidateFile vf)
    {
       boolean rule1;
        ValidateFile validateFile = () ->
        {
            rule1 = rule();
            vf.rule();
        };
        return validateFile;
    }

}
