import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class MyLoader extends ClassLoader{
    private String rootDir;

    public MyLoader( String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] bytes=findata(name);
            if(bytes==null){
                throw  new ClassNotFoundException();
            }else{
                return defineClass(name,bytes,0,bytes.length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private byte[] findata(String name) throws IOException {
        String path=topath(name);
        InputStream inputStream=new FileInputStream(path);
        ByteArrayOutputStream byteOutputStream=new ByteArrayOutputStream();
        byte[] b=new byte[1024];
        int a;
        while((a=inputStream.read(b))!=-1){
            byteOutputStream.write(b,0,a);
        }
        return byteOutputStream.toByteArray();
        }

    private String topath(String name) {
        return rootDir+"\\"+name+".class";

    }
}
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> person = new MyLoader("C:\\Users\\lyx\\IdeaProjects\\CodeTest\\out\\production\\Day5_17\\ClassLoadTest").findClass("Student");
        Constructor constructor = person.getConstructor(String.class);
        constructor.setAccessible(true);
       Object o=constructor.newInstance("hello");
    }
}
