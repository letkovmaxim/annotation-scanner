import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MarkScanner {
    private int recursionMaxLevel = 4;
    private int recursionLevel = 0;

    public MarkScanner(int recursionMaxLevel) {
        this.recursionMaxLevel = recursionMaxLevel;
    }

    public MarkScanner() {}

    private String getSpace() {
        String res = "";
        for (int i = 0; i < recursionLevel; i++) {
            if (i == recursionLevel - 1) {
                res += "\\__ ";
            } else {
                res += "    ";
            }
        }
        return res;
    }

    public void scan(Class<?> cls) {
        if (recursionLevel <= recursionMaxLevel) {
            //Поля
            Field[] fld = cls.getDeclaredFields();
            for (Field fl : fld) {
                //Аннотации поля
                Annotation[] ann = fl.getAnnotations();
                for (Annotation an : ann) {
                    System.out.print(getSpace() + ((Marked) an).name() + ": ");
                    //Примитивный или строка - выводим значение
                    if (fl.getType().isPrimitive() || (fl.getType() == String.class)) {
                        try {
                            fl.setAccessible(true);
                            System.out.println(fl.get(cls.getDeclaredConstructor().newInstance()));
                        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException | InstantiationException e) {
                            System.out.println(fl.getType().getSimpleName());
                        }
                    } else { //Разбираем уровень ниже
                        System.out.println(fl.getType().getSimpleName());
                        recursionLevel++;
                        scan(fl.getType());
                        recursionLevel--;
                    }
                }
            }
        } else {
            System.out.println(getSpace() + "...");
        }
    }
}