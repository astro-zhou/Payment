import java.time.ZonedDateTime;

/**
 * @author zyh
 * @create 2022-11-26 12:27
 */
public class T2 {
    /**
     * 时间
     */
    public static void main(String[] args) {
        ZonedDateTime zbj = ZonedDateTime.now();    // 默认时区
        System.out.println(zbj);    // 2022-11-26T12:28:54.072+08:00[Asia/Shanghai]
    }
}
