package cn.dwd.sqlpattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xiaoyanzi on 16/10/18.
 */
public class SqlPattern {

    public static void main(String[] args) {
//        String sql = "select a1,a2,a3 from b where c=d and( m=n or x=y) group by a1,a2,a3 order by a1 limit 10";
        String sql = "select a1,a2,a3 from b where mm in (asfa,a,2) or  c=d and( m=n or x=y)  group by a1,a2,a3 order by a1 limit 10 interval (111,222) granularity 2";
        Pattern pattern = Pattern.compile("^select\\s+(?<result>\\w+(?:,\\w+)*)\\s+from\\s+(?<dataSource>\\w+)(?:\\s+where\\s+(?<filter>(?:[\\s\\(\\)\\w=]+(\\((?:[,\\d\\w]+)\\))?)+))?(?:\\s+group\\s+by\\s+(?<groupBy>\\w+(?:,\\w+)*))?(?:\\s+order\\s+by\\s+(?<orderBy>\\w+))?(?:\\s+limit\\s+(?<limit>\\d+))?(?:\\s+interval\\s+\\((?<interval>[\\d]+,[\\d]+)\\))(?:\\s+granularity\\s+(?<granularity>[\\d]+))$");
        Matcher m = pattern.matcher(sql);
        if(m.matches()){
            String result = m.group("result");
            String dataSource = m.group("dataSource");
            String filter = m.group("filter");
            String groupBy = m.group("groupBy");
            String orderBy = m.group("orderBy");
            String limit = m.group("limit");
            String interval = m.group("interval");
            String granularity = m.group("granularity");
            System.out.println(result);
            System.out.println(dataSource);
            System.out.println(filter);
            System.out.println(groupBy);
            System.out.println(orderBy);
            System.out.println(limit);
            System.out.println(interval);
            System.out.println(granularity);
        }
//        String a = "abbbaabbbaaabbb";
//        Pattern p = Pattern.compile("(?:(.*+)bbb)");
//        Matcher mm = p.matcher(a);
//        System.out.println(mm.matches());
//        mm.group(1);
//        System.out.println(mm.group(1));
    }
}
