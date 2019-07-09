package Thread;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by lyx on 2019/4/12.
 */
public class System1 {
        private final static System1 sys=new System1();
        private  System1() {
        }
        public static System1 getInstance(){
            return sys;
        }
        private ArrayList<Ticket> vector=new ArrayList<Ticket>();
        {
            for(int i=10;i<100;i++){
                vector.add(new Ticket("西安"+i,"河南"+i,239));
            }
        }
        public synchronized Ticket getTicket(){
            try {
                return vector.remove(0);
            }catch (Exception e){
                return null;
            }
        }
    }

