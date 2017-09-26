import com.valeo.threadtools.*;

public class testthreadtools {

  static {
    System.loadLibrary("javathreadtools");
  }

  public static void main(String[] args) {
    int x = JavaThreadTools.tt_get_current_thread_id();
    System.out.println("Current Thread:" + new Integer(x).toString());
  }
}
