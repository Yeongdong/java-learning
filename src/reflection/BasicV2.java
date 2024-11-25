package reflection;

import reflection.data.BasicData;

import java.lang.reflect.Modifier;
import java.util.Arrays;

public class BasicV2 {
    public static void main(String[] args) {
        Class<BasicData> basicData = BasicData.class;

        System.out.println("basicDataClass.getName() = " + basicData.getName());
        System.out.println("basicDataClass.getSimpleName() = " + basicData.getSimpleName());
        System.out.println("basicDataClass.getPackage() = " + basicData.getPackage());

        System.out.println("basicDataClass.getSuperClass() = " + basicData.getSuperclass());
        System.out.println("basicDataClass.getInterfaces() = " + Arrays.toString(basicData.getInterfaces()));

        System.out.println("basicData.isInterface() = " + basicData.isInterface());
        System.out.println("basicData.isEnum() = " + basicData.isEnum());
        System.out.println("basicData.isAnnotation() = " + basicData.isAnnotation());

        int modifiers = basicData.getModifiers();
        System.out.println("basicDataModifiers = " + modifiers);
        System.out.println("isPublic = " + Modifier.isPublic(modifiers));
        System.out.println("Modifier.toString() = " + Modifier.toString(modifiers));
    }
}
