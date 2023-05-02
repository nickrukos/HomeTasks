package hw15.task4;

import java.util.function.*;

@FunctionalInterface
public interface ValidateFile
{
    public boolean validate(Predicate<File> file);
    default ValidateFile andRule(ValidateFile valid)
    {
        return file ->
        {
            if(validate(file) && valid.validate(file))
            {

            }
        };
    }
}
