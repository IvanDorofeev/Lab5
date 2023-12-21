package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * Class for searching AutoInjectable annotation and create objects by properties file
 */
public class Injector {
    private static Properties properties=new Properties();

    /**
     *
     * @param object object for initializing
     * @return created object
     * @param <Type> type of object
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static <Type> Type inject(Type object) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        try {
            FileInputStream im = new FileInputStream("injector.properties");
            properties.load(im);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Field[] fields=object.getClass().getDeclaredFields();
        for(Field field:fields){
            AutoInjectable a = field.getAnnotation(AutoInjectable.class);
            if(a != null){
                field.setAccessible(true);
                String f_class_name=field.getType().getName();
                Object o=Class.forName(properties.getProperty(f_class_name)).newInstance( );
                field.set(object,o);
            }
        }
        return object;
    }
}
