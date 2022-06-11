package com.mark.oom2visualVM.oommat;

import java.util.List;

/**
 * 文档地址
 * https://blog.csdn.net/weixin_39553272/article/details/110709631?utm_term=idea%20%E6%80%8E%E4%B9%88%E6%9F%A5%E7%9C%8Bdump%E6%96%87%E4%BB%B6&utm_medium=distribute.pc_aggpage_search_result.none-task-blog-2~all~sobaiduweb~default-0-110709631-null-null&spm=3001.4430
 * https://baijiahao.baidu.com/s?id=1724882640459490952&wfr=spider&for=pc
 * -Xms120m -Xmx120m -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
 * <p>
 * 根据visualVM分析出老年代对象过多，
 */
public class ReplayApplication {
    public static void main(String[] args) throws InterruptedException {
        //创建有内存泄露的回放客户端
        ReplayWithProblem replay1 = new ReplayWithProblem();
        // 加载一万条请求数据放入缓存

        List cache1 = replay1.loadMockRequest(10000);
        // 开始循环回放
        replay1.start(cache1);
    }
}
