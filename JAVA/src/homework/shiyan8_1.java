package homework;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

//编写基于TCP的客户端程序，将二个学生（或其它实体类）对象的信息发送到服务器。
public class shiyan8_1 {
    public static void main(String[] args) throws Exception {
        Socket socket=new Socket("127.0.0.1",8080);
        OutputStream os=socket.getOutputStream();
        DataOutputStream dos=new DataOutputStream(os);

        Stu zhangsan = new Stu("2019001", "张三");
        Stu lisi = new Stu("2019002", "李四");

        MyList<Stu>l=new MyList<>();
        l.addEntity(zhangsan);
        l.addEntity(lisi);

        for(int i=0;i<l.size();i++) {
            dos.writeUTF("id:" + l.getEntity(i).getId() + "\nname:" + l.getEntity(i).getName() + "\n");
            dos.flush();
        }

        dos.close();
        socket.close();
    }
}
