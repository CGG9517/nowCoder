package interveiw;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Class: MyTask
 * @Description:
 * @Author: Jiang Chao
 * @Date: 2018/6/2
 */
public class MyTask implements Callable<Integer> {
    private int upperBounds;

    public MyTask(int upperBounds) {
        this.upperBounds = upperBounds;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= upperBounds; i++)
        {
            sum += i;
        }
        return sum;
    }
}
class Test{



    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 使用FutureTask构建可返回的对象
        FutureTask<Integer> task = new FutureTask<>(() -> {

            return null;});

        Thread thread = new Thread(task);
        thread.start();
        task.get(); // get方法获得线程执行后的结果，线程未执行完，处于阻塞态



        List<Future<Integer>> list = new ArrayList<>();
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++)
        {
            list.add(service.submit(new MyTask((int) (Math.random()*100))));
        }

        service.shutdown();
//        while (!service.isTerminated()){}

        int sum = 0;
        for (Future<Integer> future : list)
            {
                sum += future.get();
            }
        System.out.println(sum);
    }
}