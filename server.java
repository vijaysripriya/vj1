import java.util.*;
import java.io.*;
import java.net.*;
  public class ServerTest
{


final static int SERVER_PORT=8001;
 public static void main(String arg [])


{


Server server;
String ClientRequest;
BufferedReader reader;
PrintWriter writer;
server=new Server (SERVER_PORT);
reader=new BufferedReader(new InputStreamReader( server.in));
writer=new PrintWriter(new OutputStreamWriter(server.out));




writer.println("Java Test Server vo.02" + new Date());
writer.flush();
while(true)


{
try
{

ClientRequest=reader.readLine();
System.out.println("Client Says: " +ClientRequest);



if (ClientRequest.startsWith("HELP"))


{


  writer.println("Vocabularly:HELP QUIT");

  writer.flush();
}

else

{

if (ClientRequest.startsWith("QUIT"))
{
System.exit(10);
}


else
{


writer.println("ERR Command"+ClientRequest+"not understood");
writer.flush();
}}
}catch(IOException e)
{

  System.out.println("IOEx in server" +e);
}
}
 }
}

class Server
{

private ServerSocket Server;
private Socket socket;
public InputStream in;
public OutputStream out;
public Server (int port)


{
try
{
Server=new ServerSocket(port);
System.out.println("ServerSocket before accept:"+Server);
System.out.println("Jva Test Server vo.02,on -line:");


socket=Server.accept();
System.out.println("ServerSocket after accept:"+Server);


in=socket.getInputStream();
out=socket.getOutputStream();
}catch (IOException e)



{
System.out.println("Server Condtruction IOEx:"+e);
}
}}