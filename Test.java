import java.util.*;

public class Test {
    public boolean[] chkSubStr(String[] p, int n, String s) {
        // 现有一个小写英文字母组成的字符串 s 和一个包含较短小写英文字符串的数组 p.
        // 请设计一个高效算法，对于 p 中的每一个较短字符串，判断其是否为 s 的子串.

        // 给定一个 String 数组 p 和它的大小 n，同时给定 String s 为母串
        // 请返回一个 bool 数组，每个元素代表 p 中的对应字符串是否为 s 的子串。
        // 保证 p 中的串长度小于等于 8，且 p 中的串的个数小于等于 500，同时保证 s 的长度小于等于 1000。

        // 测试样例：
        // ["a", "b", "c", "d"], 4, "abc"
        // 返回：[true,true,true,false]

        boolean[] booleans = new boolean[n];
        int x = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (s.contains(p[i])) {
                    booleans[x] = true;
                    break;
                }else {
                    booleans[x] = false;
                }
            }
            x++;
        }
        return booleans;
    }

    public static void main(String[] args) {

        // 输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列.
        // 相同成绩都按先录入排列在前的规则处理.

        // 例示：
        // jack      70
        // peter     96
        // Tom       70
        // smith     67

        // 从高到低  成绩
        // peter     96
        // jack      70
        // Tom       70
        // smith     67

        // 从低到高
        // smith     67
        // Tom       70
        // jack      70
        // peter     96
        // 注：0 代表从高到低，1 代表从低到高

        // 输入描述:
        // 输入多行，先输入要排序的人的个数，然后分别输入他们的名字和成绩，以一个空格隔开
        // 输出描述:
        // 按照指定方式输出名字和成绩，名字和成绩之间以一个空格隔开

        // 示例:
        // 输入
        // 3
        // 0
        // fang 90
        // yang 50
        // ning 70
        // 输出
        // fang 90
        // ning 70
        // yang 50

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int order = sc.nextInt();
            // 1 代表从低到高输出, 0 代表从高到低输出
            int[] strs = new int[n];
            Map<String, Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < n; i++) {
                String name = sc.next();
                int score = sc.nextInt();
                map.put(name + " " + score, score);
                strs[i] = score;
            }
            // 给 score 按要求排序
            if (order == 1) {
                for (int i = 0; i < n - 1; i++) {
                    for (int j = i + 1; j < n; j++) {
                        if (strs[i] > strs[j]) {
                            int tmp = strs[i];
                            strs[i] = strs[j];
                            strs[j] = tmp;
                        }
                    }
                }
            }
            if (order == 0) {
                for (int i = 0; i < n - 1; i++) {
                    for (int j = i + 1; j < n; j++) {
                        if (strs[i] < strs[j]) {
                            int tmp = strs[i];
                            strs[i] = strs[j];
                            strs[j] = tmp;
                        }
                    }
                }
            }
            int pre = -1;
            // 判断不重复遍历
            for (int i : strs) {
                if (pre == i) {
                    // 新一次循环相当于 i++, 如果相等条件成立, 则说明两次 i 相同.
                    // 为避免重复遍历, continue 跳出循环.
                    continue;
                    // 跳过本次循环
                }
                for (String name : map.keySet()) {
                    if (map.get(name)== i) {
                        System.out.println(name);
                    }
                }
                pre = i;
            }
        }
        sc.close();
    }
}
