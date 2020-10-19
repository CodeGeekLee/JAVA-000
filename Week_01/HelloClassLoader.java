import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloClassLoader extends ClassLoader {
    public static void main(String[] args) {

        HelloClassLoader helloClassLoader = new HelloClassLoader();
        try {
            Class<?> hello = helloClassLoader.findClass("Hello");
            Object object = hello.getDeclaredConstructor().newInstance();
            Method method = hello.getMethod("hello");
            method.invoke(object);
        } catch (ClassNotFoundException | NoSuchMethodException |
                IllegalAccessException | InstantiationException |
                InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String fileName = "/Users/seven/project/JAVA-000/Week_01/Hello.xlass";
        try (InputStream inputStream = new FileInputStream(fileName)) {
            int available = inputStream.available();
            byte[] bytes = new byte[available];
            inputStream.read(bytes);
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (255 - bytes[i]);
            }
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }
}
